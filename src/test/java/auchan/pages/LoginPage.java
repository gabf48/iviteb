package auchan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    By emailField = By.id("identifierId");
    By passwordGoogleField = By.cssSelector("#password input");
    By continueGoogleButton = By.cssSelector("#identifierNext > div > button span");
    By continueGoogleButton1 = By.cssSelector("#passwordNext > div > button > span");
    By loginGoogleButton = By.cssSelector("div.mt5 div.mb5.tc > div > span");


    public void login(String username, String password) throws InterruptedException {
        driver.get("https://auchanqa.myvtex.com/");
        driver.manage().window().maximize();
        click(loginGoogleButton);
        Thread.sleep(2000);
        writeText(emailField,username);
        click(continueGoogleButton);
        writeText(passwordGoogleField,password);
        click(continueGoogleButton1);
    }
}
