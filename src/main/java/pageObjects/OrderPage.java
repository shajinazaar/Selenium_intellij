package pageObjects;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {

    WebDriver driver;
    public OrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }



    @FindBy(css = "[placeholder='Select Country']")
    WebElement dropDown;

    @FindBy(xpath = "//*[contains(text(),'Pakistan')]")
            WebElement selectCountry;


    @FindBy(css = ".action__submit")
            WebElement orderBtn;

    By slide = By.cssSelector(".ta-results");

/*
     a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"Pakistan").build().perform();

     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

     driver.findElement(By.xpath("//*[contains(text(),'Pakistan')]")).click();

     driver.findElement(By.cssSelector(".action__submit")).click();

    String message = driver.findElement(By.cssSelector(".hero-primary")).getText();

     Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

   */

    public void SearchCountry(String Country){
        Actions a = new Actions(driver);
        a.sendKeys(dropDown,Country).build().perform();
        waitForElementToAppear(slide);
        selectCountry.click();

    }

    public HistoryPage clickOrder(){
        HistoryPage historyPage = new HistoryPage(driver);
        orderBtn.click();
        return historyPage;
    }




}
