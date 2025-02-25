package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage extends CommonActionPages {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement inputQuantity;

    @FindBy(xpath = "//button[contains(@class, 'cart')]")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//p/a[@href='/view_cart']")
    private WebElement btnViewCart;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "review")
    private WebElement inputReview;

    @FindBy(id = "button-review")
    private WebElement btnSubmitReview;

    @FindBy(xpath = "//div[@id='review-section']/div/div/span")
    private WebElement lblReviewConfirmation;

    public void addProductByQuantity(int quantity) {
        inputQuantity.clear();
        inputQuantity.sendKeys(String.valueOf(quantity));
        btnAddToCart.click();
        fluidWaitVisibility(btnViewCart, Duration.ofSeconds(10), Duration.ofSeconds(2));
        btnViewCart.click();
    }

    public void addReviewToProduct() {
        String name = "Juan";
        String email = "juan@email.com";
        String review = "Good product";

        scrollIntoElement(inputName);

        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputReview.sendKeys(review);

        btnSubmitReview.click();
    }

    public String getReviewConfirmationMessage() {
        fluidWaitVisibility(lblReviewConfirmation, Duration.ofSeconds(5), Duration.ofSeconds(1));
        return lblReviewConfirmation.getText();
    }
}
