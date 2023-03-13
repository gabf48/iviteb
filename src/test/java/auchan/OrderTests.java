package auchan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.BasePage;
import utils.BaseTest;
import utils.GenerateRandom;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static constants.Accounts.*;
import static constants.Environments.PRODUCTION_ENVIRONMENT;

public class OrderTests extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private BasePage basePage;
    private ProductPage productPage;
    private TopBar topBar;
    private CartSection cartSection;
    private LoginAuchanPage loginAuchanPage;
    private ProfilePage profilePage;
    private GenerateRandom generateRandom;
    private ShippingPage shippingPage;


    @BeforeMethod
    public void setUp() throws IOException, AWTException {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        productPage = new ProductPage(driver);
        topBar = new TopBar(driver);
        cartSection = new CartSection(driver);
        loginAuchanPage = new LoginAuchanPage(driver);
        profilePage = new ProfilePage(driver);
        generateRandom = new GenerateRandom();
        homePage = new HomePage(driver);
        shippingPage = new ShippingPage(driver);
    }

    @Test
    public void orderTest() throws InterruptedException {
        //access Auchan production
        loginPage.accessURL(PRODUCTION_ENVIRONMENT);

        //accept cookies
        homePage.acceptAllCookies();

        //open categories
        topBar.openCategoriesMenu();

        //open random subcategory
        basePage.clickRandomElement("[class=\"auchan-mega-menu-0-x-menuContainer list ma0 pa0 pb3 br b--muted-4\"] a");

        //add random product in the cart
        basePage.clickRandomElement(".vtex-product-summary-2-x-imageWrapper--defaultShelf div");

        //take price
        double x = 0;

        //add the product in the cart
        productPage.addInCart();

        //choose delivery option and store
        productPage.pressPickUpMethod();

        //delete product from cart
        productPage.deleteProductFromCart();

        //add 5 products from my-club Auchan
        for (int i = 1; i <= 2; i++) {
            Thread.sleep(1000);
            driver.get("https://www.auchan.ro/promotii/myclub-auchan");

            //add random product in the cart
            Thread.sleep(1000);
            basePage.scrollDownOfThePage();
            Thread.sleep(1000);
            basePage.scrollUpOfThePage();
            basePage.clickRandomElement(".vtex-product-summary-2-x-imageWrapper--defaultShelf div");

            //add the product in the cart
            productPage.addInCart();

            //take the price
            Thread.sleep(1000);
            x = x + productPage.takePrice();
        }

        //add 25 products from random categories
        for (int i = 1; i <= 2; i++) {
            //open categories
            Thread.sleep(1000);
            topBar.openCategoriesMenu();

            //open random subcategory
            basePage.clickRandomElement("[class=\"auchan-mega-menu-0-x-menuContainer list ma0 pa0 pb3 br b--muted-4\"] a");

            //add random product in the cart
            Thread.sleep(1000);
            basePage.clickRandomElement(".vtex-product-summary-2-x-imageWrapper--defaultShelf div");

            //add the product in the cart
            productPage.addInCart();

            //take the price
            Thread.sleep(1000);
            x = x + productPage.takePrice();
        }
        System.out.println("Suma toatala este = " + x);

        //open the cart
        topBar.openCart();

        //take the total price from cart
        cartSection.getPrice();

        //assert if the total price from cart is same with total amount of all product from cart
        double roundVal = Math.round(x*100.0)/100.0;
        if (roundVal>200){roundVal=roundVal-15;}
        Assert.assertEquals(cartSection.getPrice(), roundVal);

        cartSection.pressFinalOrderButton();

        loginAuchanPage.login(VALID_EMAIL2,VALID_PASSWORD2);

        Thread.sleep(25000);

        cartSection.pressContinueButton();

        //accept Terms
        Thread.sleep(5000);
        cartSection.acceptTerms();

        //press to go to next section
        cartSection.pressGoToPaymentButton();

        //choose random day to delivery
        shippingPage.chooseRandomDeliveryDay();

        //press to go to next section
        cartSection.pressGoToPaymentButton();

        //choose online payment
        shippingPage.pressOnlinePayment();

        //check if payment button is enabled
        Thread.sleep(15000);
        List<WebElement> list = driver.findElements(By.cssSelector("[class=\"submit btn btn-success btn-large btn-block\"]"));

        int size = list.size();

        Assert.assertEquals(size,3);
    }


}
