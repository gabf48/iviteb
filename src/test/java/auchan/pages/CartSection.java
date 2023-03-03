package auchan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class CartSection extends BasePage {
    public CartSection(WebDriver driver) throws AWTException {
        super(driver);
    }

    By continueButton = By.cssSelector(".active span.btn-place-order-wrapper > a");
    By termsCheckBox = By.id("terms");
    By goToShippingButton = By.id("go-to-shipping");

    public String getPrice(){
        System.out.println(driver.findElement(By.cssSelector("#items-price > div")).getText());
        return driver.findElement(By.cssSelector("#items-price > div")).getText();
    }

    public void pressFinalOrderButton(){
        driver.findElement(By.cssSelector("div.mw9.center.vtex-auth-challenge-1-x-challengeContentWrapper > a > span")).click();
    }

    public void pressContinueButton(){
        click(continueButton);
    }

    public void acceptTerms(){
        click(termsCheckBox);
    }

    public void pressGoToShippingButton(){
        click(goToShippingButton);
    }
}
