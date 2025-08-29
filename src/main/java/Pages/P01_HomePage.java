package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class P01_HomePage {
    private WebDriverWait wait;
    private WebDriver driver;

    private final  By headerLogo = By.xpath("(//img[@alt='InMotion Hosting Logo'])[1]");
    private final  By WebHosting = By.xpath("//a[@class='footer-heading-link' and text()='Web Hosting']");
    private final By DomainSearch = By.xpath("//a[text()='Domain Names']");
    private final By domainSearchInput = By.id("domain_search_domain");


    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    public void Domains(){
        Utility.scrolling(driver,DomainSearch);
        WebElement domainsTab = driver.findElement(DomainSearch);
        Actions actions = new Actions(driver);
        actions.moveToElement(domainsTab).perform();
        Utility.clickingOnElement(driver,DomainSearch);
        wait.until(ExpectedConditions.visibilityOfElementLocated(domainSearchInput));

        return ;
    }



}

