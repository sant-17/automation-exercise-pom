package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends CommonActionPages {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By lblProductPrice = By.xpath("//td[@class='cart_price']/p");
    By lblProcuctTotalPrice = By.xpath("//p[@class='cart_total_price']");
    By lblProductQuantity = By.xpath("//td[@class='cart_quantity']/button");

    public Integer getSinglePrice() {
        int value;

        try {
            value = Integer.parseInt(getElementText(lblProductPrice));
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }

    public Integer getTotalPrice() {
        int value;

        try {
            value = Integer.parseInt(getElementText(lblProcuctTotalPrice));
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }

    public Integer getQuantity() {
        int value;

        try {
            value = Integer.parseInt(getElementText(lblProductQuantity));
        } catch (NumberFormatException e) {
            value = 0;
        }

        return value;
    }
}
