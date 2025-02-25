import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddReviewOnProductTest extends BaseTest {

    @Test
    public void testAddReviewOnProduct() {
        homePage.accessRandomProduct();
        productPage.addReviewToProduct();
        Assertions.assertEquals("Thank you for your review.", productPage.getReviewConfirmationMessage());
    }
}
