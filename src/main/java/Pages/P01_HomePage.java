package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_HomePage {
    private WebDriver driver;

    private final  By headerLogo = By.xpath("(//img[@alt='InMotion Hosting Logo'])[1]");
    private final  By WebHosting = By.xpath("//a[@class='footer-heading-link' and text()='Web Hosting']");

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHeaderLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(headerLogo));
        logo.click();

    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public void scrollToWebHosting(){
        WebElement WebHost = driver.findElement(WebHosting);
        Utility.scrolling(driver,WebHosting);

    }
    public boolean isDomainsDisplayed() {
        return driver.findElement(WebHosting).isDisplayed();
    }

}

