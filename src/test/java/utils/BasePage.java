package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) throws AWTException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(80000));
    }

    Robot robot = new Robot();

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void readText(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).getText();
    }

    public String readAttribute(By elementBy, String attribute) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    public void clickRandomElement(String selector) throws InterruptedException {
        zoomOut();
        List<WebElement> list =
                driver.findElements(By.cssSelector(selector));
        int size = list.size();
        int randNumber = ThreadLocalRandom.current().nextInt(0, size);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", list.get(randNumber));
        WebElement html = driver.findElement(By.tagName("html"));
        Thread.sleep(2000);
        list.get(randNumber).click();
        zoomIn();
    }

    public void scrollDownOfThePage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");
    }



    public void zoomOut() throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        Thread.sleep(5000);
    }

    public void zoomIn() throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ADD);
        }
        Thread.sleep(5000);
    }
}
