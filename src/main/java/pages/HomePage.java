package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonActionPages {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement btnContactUs;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement btnProducts;

    @FindBy(xpath = "(//a[contains(@href, '/product_details')])[1]")
    private WebElement btnViewProduct;

    public void accessContactForm() {
        btnContactUs.click();
    }

    public void accessAllProducts() {
        btnProducts.click();
    }

    public void accessRandomProduct() {
        scrollIntoElement(btnViewProduct);
        btnViewProduct.click();
    }
}
