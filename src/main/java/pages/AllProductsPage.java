package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

public class AllProductsPage extends CommonActionPages{

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    By lblAllProducts = By.xpath("//h2[contains(@class, 'title') and contains(text(), 'All Products')]");
    By lblSearchedProducts = By.xpath("//h2[contains(@class, 'title') and contains(text(), 'Searched Products')]");
    By inputSearch = By.xpath("//input[@name='search']");
    By btnSearch = By.xpath("//button[@id='submit_search']");
    By products = By.xpath("//div[contains(@class, 'productinfo')]/p");

    public List<String> searchProducts(String product) {
        fluidWaitVisibility(lblAllProducts, Duration.ofSeconds(10), Duration.ofSeconds(2));
        writeText(inputSearch, product);
        clickElement(btnSearch);
        fluidWaitVisibility(lblSearchedProducts, Duration.ofSeconds(10), Duration.ofSeconds(2));
        return getTextsByElements(products);
    }
}
