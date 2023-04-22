import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WebTable {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.cssSelector("a[href*='#/offers']")).click();
        // Locate the table element
        WebElement table = driver.findElement(By.cssSelector("table[class='table table-bordered']"));

        // Locate the column by its header name (assuming the table has a header row)
        WebElement headerRow = table.findElement(By.tagName("thead")).findElement(By.tagName("tr"));
        List<WebElement> headerCells = headerRow.findElements(By.tagName("th"));
        int columnIndex = -1;
        for (int i = 0; i < headerCells.size(); i++) {
            if (headerCells.get(i).getText().equals("column-header-name")) {
                columnIndex = i;
                break;
            }
        }

        // Iterate over the rows and extract the desired element in the column
        List<String> columnElements = new ArrayList<>();
        List<WebElement> bodyRows = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (WebElement row : bodyRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String columnElement = cells.get(columnIndex).getText();
            columnElements.add(columnElement);
        }

        // Print the extracted column elements
        System.out.println(columnElements);



     //  driver.findElement(By.xpath("//tr/th[1]")).click();


    }
}
