import TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class EcommTest extends BaseTest {

    @Test
    public void submitOrder() throws IOException {

        String productName = "ADIDAS ORIGINAL";
        ProductCataloguePage productCatalogue =  loginPage.setCredentials("shajinazar10@gmail.com","P@kistan123");
        productCatalogue.addProductToCart(productName);
        CartPage cartPage= productCatalogue.goToCartPage();
        cartPage.CheckCartProductList(productName);
        OrderPage orderPage = cartPage.Checkout();
        orderPage.SearchCountry("Pakistan");
        HistoryPage historyPage= orderPage.clickOrder();
        historyPage.confirmOrder();

    }
}
