package org.ecom;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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
}
