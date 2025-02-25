import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyProductQuantityInCartTest extends BaseTest {

    @Test
    public void testVerifyProductQuantityInCart() {
        int quantity = 5;

        homePage.accessRandomProduct();
        productPage.addProductByQuantity(quantity);
        assertEquals(quantity, shoppingCartPage.getQuantity());
        assertEquals(quantity * shoppingCartPage.getSinglePrice(), shoppingCartPage.getTotalPrice());
    }
}
