package pageObjects;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCataloguePage extends AbstractComponents {

    WebDriver driver;

    public ProductCataloguePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
     WebElement loading;

    By productsBy = By.cssSelector(".mb-3");
    By addCartBtn = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList(){
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductsByName(String Name){

        WebElement prod= getProductList().stream().filter(i -> i.findElement(By.tagName("b")).getText().equals(Name))
                .findFirst().orElse(null);

        return prod;
    }

    public void addProductToCart(String Name){

        WebElement prod = getProductsByName(Name);

        prod.findElement(addCartBtn).click();

        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(loading);


    }



}
