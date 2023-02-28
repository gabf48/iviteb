package auchan.tests;

import auchan.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.io.IOException;

import static utils.Accounts.VALID_EMAIL;
import static utils.Accounts.VALID_PASSWORD;

public class OrderTests extends BaseTest {

    private LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws IOException {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void orderTest() {
        loginPage.login(VALID_EMAIL,VALID_PASSWORD);
    }
}
