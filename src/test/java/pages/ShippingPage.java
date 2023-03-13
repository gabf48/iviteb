package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.awt.*;

public class ShippingPage extends BasePage {
    public ShippingPage(WebDriver driver) throws AWTException {
        super(driver);
    }

    public void chooseRandomDeliveryDay() throws InterruptedException {
        clickRandomElement(".react-datepicker__month > div:nth-child(3) > div.react-datepicker__day.react-datepicker__day");
    }

    public void pressOnlinePayment(){
        driver.findElement(By.cssSelector("[id=\"payment-group-custom203PaymentGroupPaymentGroup\"]")).click();
    }
}
