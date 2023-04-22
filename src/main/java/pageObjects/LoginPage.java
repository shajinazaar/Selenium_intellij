package pageObjects;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {

    WebDriver driver;

    public LoginPage(WebDriver driver){
    //Initialization
        super(driver);
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }

  //  WebElement emailId =driver.findElement(By.id("userEmail"));
   //   driver.findElement(By.id("userPassword")).sendKeys("P@kistan123");
     //   driver.findElement(By.id("login")).click();

    // Page factory design pattern
    @FindBy(id="userEmail")
    WebElement emailId;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement loginBtn;

    public ProductCataloguePage setCredentials(String Email, String pwd)
    {
        ProductCataloguePage productCatalogue = new ProductCataloguePage(driver);
        emailId.sendKeys(Email);
        password.sendKeys(pwd);
        loginBtn.click();
        return productCatalogue;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/");
    }

}
