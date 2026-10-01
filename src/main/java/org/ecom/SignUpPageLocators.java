package org.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPageLocators {
    private WebDriver driver;

    public  final By signupButton= By.cssSelector("i[class=\"fa fa-lock\"]");
    public  final By email= By.cssSelector("input[data-qa=\"signup-email\"]");
    public  final By username= By.cssSelector("input[name=\"name\"]");
    public  final By submit= By.cssSelector("button[data-qa=\"signup-button\"]");
    public  final By password= By.cssSelector("input[data-qa=\"password\"]");
    public  final By day= By.id("days");
    public  final By month= By.id("months");
    public  final By year= By.id("years");
    public  final By firstName= By.id("first_name");
    public  final By lastName= By.id("last_name");
    public  final By address= By.id("address1");
    public  final By state= By.id("state");
    public  final By city= By.id("city");
    public  final By zip= By.id("zipcode");
    public  final By mobile= By.id("mobile_number");
    public  final By create= By.cssSelector("button[data-qa=\"create-account\"]");
    public  final By alert=By.cssSelector("div[class=continue-prompt-text]");
    public  final By popupFrame=By.cssSelector("iframe[id=aswift_3]");

    public SignUpPageLocators(WebDriver driver) {
        this.driver=driver;
    }
}
