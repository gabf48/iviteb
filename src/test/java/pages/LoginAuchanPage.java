package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class LoginAuchanPage extends BasePage {
    public LoginAuchanPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    By emailInput = By.id("uname1");
    By passwordInput = By.id("pwd1");
    By loginButton = By.id("btnSubmit_login");


    public void login(String email, String password){
        writeText(emailInput, email);
        writeText(passwordInput, password);
        click(loginButton);
    }
}
