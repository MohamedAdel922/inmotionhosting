package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_Domains {

    private final WebDriverWait wait;
    private WebDriver driver;
    private final By domainSearchInput = By.id("domain_search_domain");
    private final By SearchButton = By.xpath("//button[@id='domain_submit']");
    private final By OrderSummary = By.xpath("//Span[text()='Order Summary']");

    private By domainNameField = By.xpath("(//div[text()=' myautomationtest123.org '])[1]");
    private By domainPriceField = By.xpath("(//span[text()=' $19.98 '])[1]");
    private By domianCart = By.xpath("//span[text()='DOMAIN']");
    private final By addDomain = By.xpath("(//span[text()=' Add & Continue '])[1]");

    public P02_Domains(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public P02_Domains SearchForDomain(){
        Utility.sendData(driver,domainSearchInput,"myautomationtest123.com");
        Utility.scrolling(driver,SearchButton);
        Utility.clickingOnElement(driver,SearchButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSummary));

        return this;
    }

    public String getDomainName() {
        return driver.findElement(domainNameField).getText().trim();
    }

    // Method to get the price from summary
    public String getDomainPrice() {
        return driver.findElement(domainPriceField).getText().trim();
    }
    public P02_Domains AddDomaintoCart(){

        Utility.clickingOnElement(driver,domianCart);
        return this;

    }

     public P02_Domains AddToCart(){

 Utility.clickingOnElement(driver,addDomain);
 return this;

     }


}




