package Tests;

import Pages.P02_Domains;
import Utilities.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getPropertyValue;

public class TC02_Domains {
    WebDriver driver;

    P02_Domains domin;
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

      domin  = new P02_Domains(driver);
    }

    @Test
    public void SearchDomain(){

        domin.SearchForDomain();
    }
}
