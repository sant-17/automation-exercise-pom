import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchProductTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        String searchParam = "blue";

        homePage.accessAllProducts();
        List<String> products = allProductsPage.searchProducts(searchParam);

        for (String product : products) {
            Assertions.assertTrue(product.contains(searchParam), "El texto del producto no contiene el valor esperado: " + product);
        }
    }
}
