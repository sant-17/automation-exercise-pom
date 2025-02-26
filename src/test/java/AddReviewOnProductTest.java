import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddReviewOnProductTest extends BaseTest {

    @Test
    public void testAddReviewOnProduct() {
        homePage.accessRandomProduct();
        productPage.addReviewToProduct();
        assertEquals("Thank you for your review.", productPage.getReviewConfirmationMessage());
    }
}
