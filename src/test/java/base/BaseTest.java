package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ContactPage contactPage;
    protected ProductPage productPage;
    protected ShoppingCartPage shoppingCartPage;
    protected AllProductsPage allProductsPage;

    @BeforeEach
    public void setUp() {
        CommonActionPages commonActions = new CommonActionPages(driver);
        driver = commonActions.chromeDriverConection();

        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        allProductsPage = new AllProductsPage(driver);

        homePage.visitPage("https://automationexercise.com/");
    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }

}
