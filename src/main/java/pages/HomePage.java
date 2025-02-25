package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonActionPages {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By btnContactUs = By.xpath("//a[@href='/contact_us']");
    By btnProducts = By.xpath("//a[@href='/products']");
    By btnViewProduct = By.xpath("(//a[contains(@href, '/product_details')])[1]");

    public void accessContactForm() {
        clickElement(btnContactUs);
    }

    public void accessAllProducts() {
        clickElement(btnProducts);
    }

    public void accessRandomProduct() {
        scrollIntoElement(btnViewProduct);
        clickElement(btnViewProduct);
    }
}
