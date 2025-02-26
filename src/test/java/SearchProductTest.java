import base.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProductTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        String searchParam = "blue";

        homePage.accessAllProducts();
        List<String> products = allProductsPage.searchProducts(searchParam);

        for (String product : products) {
            assertTrue(product.contains(searchParam), "El texto del producto no contiene el valor esperado: " + product);
        }
    }
}
