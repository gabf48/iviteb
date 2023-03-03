package auchan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

import static utils.Product.PRICE;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    public void takePrice(){
        String price = driver.findElement(By.cssSelector("[class=\"auchan-store-theme-1-x-pricePdpContainer\"]")).getText();
        System.out.println(price);
        PRICE = price;
    }

    public void addInCart(){
        driver.findElement(By.cssSelector(".auchan-add-to-cart-0-x-buttonText")).click();
    }

    public void pressPickUpMethod() throws InterruptedException {
        driver.findElement(By.cssSelector("[alt=\"Pickup Method\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".flex.flex-column.center.w-100 > div > button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div:nth-child(1) > div.auchan-delivery-methods-1-x-businessHoursChoose.flex.justify-between > div:nth-child(2) > div > button > div")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.auchan-delivery-methods-1-x-buttonsContainer.mt6 > div > button > div")).click();
    }
}
