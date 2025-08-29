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


    public P02_Domains(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public P02_Domains SearchForDomain(){
        Utility.sendData(driver,domainSearchInput,"myautomationtest123.com");
        Utility.clickingOnElement(driver,SearchButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSummary));

        return this;
    }

}




