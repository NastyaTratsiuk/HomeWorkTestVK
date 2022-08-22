package utils;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void startDriver() {
        AqualityServices.getBrowser().maximize();
    }

    @AfterClass
    public void closeDriver() {
        AqualityServices.getBrowser().quit();
    }
}
