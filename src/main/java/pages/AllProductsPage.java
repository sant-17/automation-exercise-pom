package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class AllProductsPage extends CommonActionPages{

    public AllProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(@class, 'title') and contains(text(), 'All Products')]")
    private WebElement lblAllProducts;

    @FindBy(xpath = "//h2[contains(@class, 'title') and contains(text(), 'Searched Products')]")
    private WebElement lblSearchedProducts;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@class, 'productinfo')]/p")
    private List<WebElement> products;

    public List<String> searchProducts(String product) {
        fluidWaitVisibility(lblAllProducts, Duration.ofSeconds(10), Duration.ofSeconds(2));
        inputSearch.sendKeys(product);
        btnSearch.click();
        fluidWaitVisibility(lblSearchedProducts, Duration.ofSeconds(10), Duration.ofSeconds(2));

        return getTextsByElements(products);
    }
}
