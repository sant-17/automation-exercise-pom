package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CommonActionPages {

    protected WebDriver driver;
    private static final String START_MAXIMIZED = "--start-maximized";

    public CommonActionPages (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver chromeDriverConection() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(START_MAXIMIZED);
        driver = new ChromeDriver(options);
        return driver;
    }

    public void visitPage(String link) {
        driver.get(link);
    }

    public WebDriverWait waitTimeInSeconds(Duration duration) {
        return new WebDriverWait(driver, duration);
    }

    public void waitElementVisible(WebElement element, Duration timeInSecods) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeInSecods);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollIntoElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void fluidWaitVisibility(WebElement element, Duration maxWaitTime, Duration pollingInterval) {
        Wait<WebDriver> webDriverWait = new FluentWait<>(driver)
                .withTimeout(maxWaitTime)
                .pollingEvery(pollingInterval)
                .ignoring(NoSuchElementException.class);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<String> getTextsByElements(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
