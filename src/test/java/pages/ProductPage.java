package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

import static constants.Product.PRICE;
import static constants.Product.PRICE_1;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    By addInCartButton = By.cssSelector(".auchan-add-to-cart-0-x-buttonText");
    By productName = By.cssSelector("[class=\"vtex-store-components-3-x-productBrand vtex-store-components-3-x-productBrand--productPage \"]");
    By closeButtonForAdd = By.cssSelector("[class=\"omni-widget-overlay__close\"]");

    public double takePrice() throws InterruptedException {
        Thread.sleep(2500);
        String price = driver.findElement(By.cssSelector("[class=\"auchan-store-theme-1-x-pricePdpContainer\"]")).getText();
        PRICE = price;
        price = price.split("lei", 3)[0];
        System.out.println(takeNameOfTheProduct() + " " + price);
        String y = price.replace(" lei","");
        String y1 = y.replace(",",".");
        PRICE_1 = Double.parseDouble(y1);
        return PRICE_1;
    }

    private String takeNameOfTheProduct(){
        return readText(productName);
    }

    public void addInCart() {
        try {driver.findElement(By.cssSelector("[r=\"14\"]")).click();} catch (Exception ignore){}
        try {
            click(addInCartButton);
        } catch (Exception ignore){}

    }

    public void pressPickUpMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.cssSelector("[alt=\"Pickup Method\"]")).click();
        Thread.sleep(2500);
        driver.findElement(By.cssSelector(".flex.flex-column.center.w-100 > div > button")).click();
        Thread.sleep(2500);
        driver.findElement(By.cssSelector("div:nth-child(1) > div.auchan-delivery-methods-1-x-businessHoursChoose.flex.justify-between > div:nth-child(2) > div > button > div")).click();
        Thread.sleep(2500);
        driver.findElement(By.cssSelector("div.auchan-delivery-methods-1-x-buttonsContainer.mt6 > div > button > div")).click();
    }

    public void deleteProductFromCart() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("[class=\"auchan-add-to-cart-0-x-rangeIcon auchan-add-to-cart-0-x-rangeIcon--productAdd\"]")).click();
    }

    public void pressCloseButtonForAdd(){
        click(closeButtonForAdd);
    }

}
