package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPage {

    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    //List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

  //  Boolean match = cartProducts.stream().anyMatch(cp -> cp.getText().equalsIgnoreCase(productName));

    //  Assert.assertTrue(match);
    // driver.findElement(By.xpath("//ul/li/button[@class='btn btn-primary']")).click();

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//ul/li/button[@class='btn btn-primary']")
    WebElement checkoutbtn;

    public List<WebElement>getCartProductList(){
        return cartProducts;

    }

    public boolean CheckCartProductList(String Name){
        Boolean match = getCartProductList().stream().anyMatch(cp -> cp.getText().equalsIgnoreCase(Name));
        Assert.assertTrue(match);
        return match;
    }

    public OrderPage Checkout(){
        OrderPage orderPage = new OrderPage(driver);
        checkoutbtn.click();
        return orderPage;
    }



}
