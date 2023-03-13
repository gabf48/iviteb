package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) throws AWTException {
        super(driver);
    }

    By acceptAllCookiesButton = By.cssSelector("[id=\"onetrust-accept-btn-handler\"]");

    public void acceptAllCookies() throws InterruptedException {
        Thread.sleep(2500);
        click(acceptAllCookiesButton);
    }
}
