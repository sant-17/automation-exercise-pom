package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends CommonActionPages {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='cart_price']/p")
    private WebElement lblProductPrice;

    @FindBy(xpath = "//p[@class='cart_total_price']")
    private WebElement lblProductTotalPrice;

    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    private WebElement lblProductQuantity;

    public Integer getSinglePrice() {
        return parseInteger(lblProductPrice.getText());
    }

    public Integer getTotalPrice() {
        return parseInteger(lblProductTotalPrice.getText());
    }

    public Integer getQuantity() {
        return parseInteger(lblProductQuantity.getText());
    }

    private Integer parseInteger(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
