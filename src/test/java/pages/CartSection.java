package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.awt.*;

public class CartSection extends BasePage {
    public CartSection(WebDriver driver) throws AWTException {
        super(driver);
    }

    By continueButton = By.cssSelector(".active span.btn-place-order-wrapper > a");
    By termsCheckBox = By.id("terms");
    By goToShippingButton = By.id("go-to-shipping");
    By goToPaymentButton = By.id("btn-go-to-payment");
    By totalValue = By.id("total-price");

    public double getPrice() throws InterruptedException {
        Thread.sleep(2500);
        String price = driver.findElement(By.cssSelector("#total-price > div")).getText();
        price = price.split("lei", 3)[0];
        String y = price.replace(" lei","");
        String y1 = y.replace(",",".");
        System.out.println(y1);
        return Double.parseDouble(y1);
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

    public void pressGoToShippingButton() throws InterruptedException {
        WebElement btn = driver.findElement(By.id("go-to-shipping"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        Thread.sleep(2000);
        click(goToShippingButton);
    }

    public void pressGoToPaymentButton() throws InterruptedException {
        zoomOut();
        Thread.sleep(2000);
        click(goToPaymentButton);
        zoomIn();
    }
}
