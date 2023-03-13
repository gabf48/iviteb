package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) throws AWTException {
        super(driver);
    }

    By phoneNumberInput = By.id("client-phone");

    public void typePhoneNumber(String phoneNumber){
        writeText(phoneNumberInput, phoneNumber);
    }
}
