package auchan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.id("email");
    By passwordField = By.cssSelector("div.mb5 input");
    By continueButton = By.cssSelector("[style=\"padding-top: 0.25em; padding-bottom: 0.32em;\"]");


    public void login(String username, String password){
        driver.get("https://auchanqa.myvtex.com/");
        driver.manage().window().maximize();
        writeText(emailField, username);
        click(continueButton);
        writeText(passwordField,password);
        click(continueButton);
    }
}
