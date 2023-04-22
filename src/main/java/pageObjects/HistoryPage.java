package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HistoryPage {


    WebDriver driver;
    public HistoryPage(WebDriver driver){

        this.driver= driver;

    }

    @FindBy(css = "h1[class='hero-primary']")
    WebElement message;

    /*
       String message = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();

     Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
     */


    public String getConfirmationMessage(){
        return message.getText();

    }

    public void confirmOrder(){
      Assert.assertTrue(getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }


}
