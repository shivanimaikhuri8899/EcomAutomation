package org.ecom;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericMethods {

    private WebDriver driver;
    public GenericMethods(WebDriver driver){
        this.driver=driver;
    }

    public  List<String[]> readFromCSV(String fileName) throws IOException, CsvException {
        CSVReader reader=new CSVReader(new FileReader(fileName));
        List<String[]> data= reader.readAll();
        return data;
    }
    public  void dropDown(WebElement element, String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }

    public boolean isAlertPresent(By popup){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
            return true;
        }
        catch(TimeoutException | NoSuchElementException r){
            return false;
        }
    }
}
