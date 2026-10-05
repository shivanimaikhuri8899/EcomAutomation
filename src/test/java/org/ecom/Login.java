package org.ecom;

import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Login extends BaseTest
{
   LoginPageLocators login=new LoginPageLocators(driver);
    GenericMethods generic=new GenericMethods(driver);
   @Test
    public void loginFlow() throws InterruptedException {

       Faker faker=new Faker();;
       String cardNumber=faker.number().digits(12);
       String cardName=faker.name().fullName();
       String cvc=faker.number().digits(3);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.findElement(By.cssSelector("i[class=\"fa fa-lock\"]")).click();
       driver.findElement(login.home).click();
       if(isAlertPresent(login.popupFrame)){
           WebElement iframe=driver.findElement(login.popupFrame);
           driver.switchTo().frame(iframe);
           driver.findElement(login.alert).click();
           driver.switchTo().defaultContent();
       }
       driver.findElement(login.loginBtn).click();
       driver.findElement(login.email).sendKeys("jeffery.boyer@gmail.com");
       driver.findElement(login.password).sendKeys("x0423330whpwj1t3");
       driver.findElement(login.submit).click();
       List<WebElement> image=driver.findElements(login.image);
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0,200)");
       Actions actions=new Actions(driver);
       actions.moveToElement(image.get(0)).perform();
       List<WebElement> addToCart=driver.findElements(login.addToCart);
       addToCart.get(1).click();
       Thread.sleep(1000);
       driver.findElement(login.continueShoppingButton).click();
      driver.findElement(login.cart).click();
      driver.findElement(login.checkout).click();
       driver.findElement(login.checkout).click();
       driver.findElement(login.cardName).sendKeys(cardName);
      driver.findElement(login.cardNumber).sendKeys(cardNumber);
      driver.findElement(login.cvc).sendKeys(cvc);
      driver.findElement(login.expiryMonth).sendKeys("09");
      driver.findElement(login.expiryYear).sendKeys("2029");
      driver.findElement(login.submitBtn).click();
       Thread.sleep(1000);
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
