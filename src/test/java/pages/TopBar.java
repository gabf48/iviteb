package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class TopBar extends BasePage {
    public TopBar(WebDriver driver) throws AWTException {
        super(driver);
    }

    By categoriesButton = By.cssSelector("[data-id=\"mega-menu-trigger-button\"]");
    By cartButton = By.cssSelector("[role=\"presentation\"] .vtex-minicart-2-x-minicartIconContainer");

    public void openCart() throws InterruptedException {
        Thread.sleep(2500);
        click(cartButton);
    }

    public void openCategoriesMenu() throws InterruptedException {
        Thread.sleep(2500);
        click(categoriesButton);
    }
}
