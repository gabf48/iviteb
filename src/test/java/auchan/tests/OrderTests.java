package auchan.tests;

import auchan.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BasePage;
import utils.BaseTest;
import utils.GenerateRandom;

import java.awt.*;
import java.io.IOException;

import static utils.Accounts.*;
import static utils.Product.PRICE;

public class OrderTests extends BaseTest {

    private LoginPage loginPage;
    private BasePage basePage;
    private ProductPage productPage;
    private TopBar topBar;
    private CartSection cartSection;
    private LoginAuchanPage loginAuchanPage;
    private ProfilePage profilePage;
    private GenerateRandom generateRandom;


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
    }

    @Test
    public void orderTest() throws InterruptedException {
        //login with Google account
        loginPage.login(VALID_EMAIL,VALID_PASSWORD);
        Thread.sleep(5000);

        //deschide pagian de produse electrocasnice
        driver.get("https://auchanqa.myvtex.com/electrocasnice-hitech-multimedia/electrocasnice-mici/c");
        Thread.sleep(5000);

        //adauga un produs random in cos
        basePage.clickRandomElement(".vtex-product-summary-2-x-imageWrapper--defaultShelf div");

        //memoreza si afiseaza pretul produsului deschis
        productPage.takePrice();
        productPage.addInCart();
        Thread.sleep(5000);
        productPage.pressPickUpMethod();

        Thread.sleep(10000);

        topBar.openCart();
        Thread.sleep(5000);
        cartSection.getPrice();

        Assert.assertEquals(PRICE,cartSection.getPrice());

        cartSection.pressFinalOrderButton();

        Thread.sleep(20000);

        loginAuchanPage.login(VALID_EMAIL,VALID_PASSWORD1);

        Thread.sleep(15000);

        cartSection.pressContinueButton();

        //accept Terms
        Thread.sleep(5000);
        cartSection.acceptTerms();

        //type random Phone Number
        profilePage.typePhoneNumber(generateRandom.generatePhoneNumber());

        //press to go to next section
        cartSection.pressGoToShippingButton();
    }


}
