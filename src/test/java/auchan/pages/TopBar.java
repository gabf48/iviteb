package auchan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class TopBar extends BasePage {
    public TopBar(WebDriver driver) throws AWTException {
        super(driver);
    }

    public void openCart(){
        driver.findElement(By.cssSelector("[role=\"presentation\"] .vtex-minicart-2-x-minicartIconContainer")).click();
    }
}
