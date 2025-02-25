package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductPage extends CommonActionPages {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By inputQuantity = By.xpath("//input[@name='quantity']");
    By btnAddToCart = By.xpath("//button[contains(@class, 'cart')]");
    By btnViewCart = By.xpath("//p/a[@href='/view_cart']");
    By inputName = By.xpath("//input[@id='name']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputReview = By.xpath("//textarea[@id='review']");
    By btnSubmitReview = By.xpath("//button[@id='button-review']");
    By lblReviewConfirmation = By.xpath("//div[@id='review-section']/div/div/span");

    public void addProductByQuantity(int quantity) {
        clearText(inputQuantity);
        writeText(inputQuantity, String.valueOf(quantity));
        clickElement(btnAddToCart);
        fluidWaitVisibility(btnViewCart, Duration.ofSeconds(10), Duration.ofSeconds(2));
        clickElement(btnViewCart);
    }

    public void addReviewToProduct() {
        String name = "Juan";
        String email = "juan@email.com";
        String review = "Good product";

        scrollIntoElement(inputName);

        writeText(inputName, name);
        writeText(inputEmail, email);
        writeText(inputReview, review);

        clickElement(btnSubmitReview);
    }

    public String getReviewConfirmationMessage() {
        fluidWaitVisibility(lblReviewConfirmation, Duration.ofSeconds(5), Duration.ofSeconds(1));
        return getElementText(lblReviewConfirmation);
    }
}
