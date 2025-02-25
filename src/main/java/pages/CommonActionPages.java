package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    public void writeText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebDriverWait waitTimeInSeconds(Duration duration) {
        return new WebDriverWait(driver, duration);
    }

    public void waitElementVisible(By locator, Duration timeInSecods) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSecods);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollIntoElement(By element) {
        WebElement jsElement = driver.findElement(element);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", jsElement);
    }

    public void fluidWaitVisibility(By element, Duration maxWaitTime, Duration pollingInterval) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(maxWaitTime)
                .pollingEvery(pollingInterval)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public List<String> getTextsByElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
