package org.ecom;

import com.opencsv.exceptions.CsvException;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SignUp extends BaseTest
{
    private static final Logger log = LoggerFactory.getLogger(SignUp.class);
    GenericMethods generic=new GenericMethods(driver);
    SignUpPageLocators signup=new SignUpPageLocators(driver);
    @DataProvider(name="signUpCredentials")
    public Iterator<String[]> userNamePassword() throws IOException, CsvException {
        return generic.readFromCSV("src/main/java/org/sauceDemo/SignUpData.csv").iterator() ;
    }
   @Test(dataProvider = "signUpCredentials")
    public void signUpFlow(String firstName, String lastName, String address, String city, String state,
                          String zip) throws InterruptedException
   {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       Faker faker=new Faker();
       String username=faker.name().fullName();
       String email=faker.internet().emailAddress();
       String mobile=faker.phoneNumber().cellPhone();
       String password=faker.credentials().password();
       driver.findElement(signup.signupButton).click();
       driver.findElement(signup.username).sendKeys(username);
       driver.findElement(signup.email).sendKeys(email);
       driver.findElement(signup.submit).click();
       driver.findElement(signup.password).sendKeys(password);
       driver.findElement(signup.firstName).sendKeys(firstName);
       driver.findElement(signup.lastName).sendKeys(lastName);
       driver.findElement(signup.address).sendKeys(address);
       driver.findElement(signup.city).sendKeys(city);
       driver.findElement(signup.state).sendKeys(state);
       driver.findElement(signup.zip).sendKeys(zip);
       driver.findElement(signup.mobile).sendKeys(mobile);
       WebElement day=driver.findElement(signup.day);
       generic.dropDown(day,"3");
       WebElement month=driver.findElement(signup.month);
       generic.dropDown(month,"6");
       WebElement year=driver.findElement(signup.year);
       generic.dropDown(year,"2001");
       if(isAlertPresent(signup.popupFrame)){
           WebElement iframe=driver.findElement(signup.popupFrame);
           driver.switchTo().frame(iframe);
           driver.findElement(signup.alert).click();
       }
       driver.findElement(signup.create).click();
       log.info("createButton is clicked");
       Thread.sleep(1000);
   }

    @Test
    public void testReadingDataFromCSV() throws IOException, CsvException {
        List<String[]> data = generic.readFromCSV("src/main/java/org/sauceDemo/SignUpData.csv");
        for(String[] row:data){
            System.out.println(Arrays.toString(row));
        }
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
