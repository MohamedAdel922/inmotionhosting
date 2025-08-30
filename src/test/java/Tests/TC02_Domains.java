package Tests;

import Pages.P02_Domains;
import Utilities.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getPropertyValue;

public class TC02_Domains {
    WebDriver driver;

    P02_Domains domain;
    P02_Domains orderSummaryPage;
    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getPropertyValue("environment", "Browser");
        LogsUtils.info(System.getProperty("browser"));

        setupDriver(browser);
        WebDriver driver = getDriver();
        LogsUtils.info(browser + " driver is opened");
        driver.get(getPropertyValue("environment", "Domains_URL"));
        LogsUtils.info("Page is redirected to the URL");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      domain  = new P02_Domains(driver);
        orderSummaryPage = new P02_Domains(driver);
        P02_Domains orderSummaryPage = new P02_Domains(driver);


    }

    @Test(priority = 1)

    public void SearchDomain() {

        domain.SearchForDomain();

        String expectedDomain = "myautomationtest123.com";
        String expectedPrice = "$19.99/year";


        String actualDomain = orderSummaryPage.getDomainName();
        String actualPrice = orderSummaryPage.getDomainPrice();

        Assert.assertEquals(actualDomain, expectedDomain,
                " Domain mismatch! Expected: " + expectedDomain + " but :" + actualDomain);

        Assert.assertEquals(actualPrice, expectedPrice,
                " Price mismatch! Expected: " + expectedPrice + " but : " + actualPrice);


        domain.AddDomaintoCart();
        domain.AddToCart();


}
}
