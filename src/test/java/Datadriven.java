import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Datadriven {


    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\SampleData.xlsx");

        XSSFWorkbook work = new XSSFWorkbook(fis);

        int sheets = work.getNumberOfSheets();

        for(int i= 0 ; i < sheets; i++){

            if(work.getSheetName(i).equalsIgnoreCase("Test Data")){

                XSSFSheet sheet = work.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator(); // sheet is the collection of rows

                //Identify the test cases column by scanning entire rows

                Row firstRow = rows.next();
                Iterator<Cell>  ce = firstRow.cellIterator(); // rows is a collection of cellls
                int column = 0;
                int k=0 ;

                while(ce.hasNext()){

                    Cell value = ce.next();

                    if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
                        column= k ;
                    }
                    k++;
                }

                while(rows.hasNext()){

                    Row r = rows.next();

                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Product")){
                    Iterator<Cell> cv = r.cellIterator();
                    while (cv.hasNext()){
                        System.out.println(cv.next().getStringCellValue());
                    }

                    }
                }


            }

        }

    }
}
