package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    WebDriverWait wait;
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //WebElement cartBtn = driver.findElement(By.cssSelector("[routerlink*='cart']"));

    @FindBy(css="[routerlink*='cart']")
    WebElement cartBtn;


    public CartPage goToCartPage(){
        CartPage cartPage = new CartPage(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", cartBtn);
        return cartPage;
    }

    public void waitForElementToAppear(By FindBy){

        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

    }

    public void waitForElementToDisappear(WebElement ele)
    {
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

}
