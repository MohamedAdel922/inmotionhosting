package Tests;

import Pages.P01_HomePage;
import Utilities.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class Tc01_HomePage {
    WebDriver driver;
    P01_HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getPropertyValue("environment", "Browser");
        LogsUtils.info(System.getProperty("browser"));

        setupDriver(browser);   // هنا الـ driver بيتعمله Setup
        driver = getDriver();   // نخزن الـ driver اللي جه من DriverFactory

        LogsUtils.info(browser + " driver is opened");
        driver.get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the URL");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new P01_HomePage(driver);
    }

    @Test
    public void verifyTitleContainsInMotionHosting() {
        homePage.clickHeaderLogo();
        String title = homePage.getPageTitle();
        Assert.assertTrue(title.contains("InMotion Hosting"),
                " Page title does not contain 'InMotion Hosting'. Actual title: " + title);
    }

    @Test
    public void verifyWebHostingVisible() {
        homePage.scrollToWebHosting();
        Assert.assertTrue(homePage.isDomainsDisplayed(),
                "Domains menu is not displayed");
    }

    @Test
    public void verifyDomainNameSearchNavigation() {
        homePage.Domains();           // Hover on Domains

    }
    @AfterMethod(alwaysRun = true)
    public void quit() {
        quitDriver();
    }
}


