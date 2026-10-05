package org.ecom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest{
    WebDriver driver;
    public GenericMethods genericMethods;
    public LoginPageLocators login;
    private static final Logger log =
            LogManager.getLogger(BaseTest.class);
   @BeforeTest
    public void initializeDriver() {
       log.info("initializeDriver");
        driver=new ChromeDriver();
        genericMethods=new GenericMethods(driver);
     //   login=new LoginPageLocators(driver);
        driver.get("https://www.automationexercise.com/");
       Assert.assertEquals(driver.getTitle(),"Automation Exercise");
       driver.manage().window().maximize();

   }
    @AfterTest
    public void closeBrowser(){
       driver.quit();
    }
}
