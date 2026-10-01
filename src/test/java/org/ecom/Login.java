package org.ecom;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends BaseTest
{
   LoginPageLocators login=new LoginPageLocators(driver);

   @Test
    public void loginFlow() throws InterruptedException {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.findElement(By.cssSelector("i[class=\"fa fa-lock\"]")).click();
       driver.findElement(login.home).click();
      driver.findElement(login.addToCart).click();
      driver.findElement(login.continueShoppingButton).click();
      driver.findElement(login.cart).click();
      driver.findElement(login.checkout).click();
       driver.findElement(login.checkout).click();
       driver.findElement(login.cardName).sendKeys("");
      driver.findElement(login.cardNumber).sendKeys("");
      driver.findElement(login.cvc).sendKeys("");
      driver.findElement(login.addToCart).sendKeys("");
      driver.findElement(login.expiryMonth).sendKeys("");
      driver.findElement(login.expiryYear).sendKeys("");
      driver.findElement(login.submitBtn).click();
       Thread.sleep(1000);
   }

   public void generateData(){
       Faker faker=new Faker();
       faker.number().digits(12);

   }
}
