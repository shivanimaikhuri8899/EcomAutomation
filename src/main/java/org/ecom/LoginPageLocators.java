package org.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageLocators {
    private WebDriver driver;

    public  final By addToCart= By.cssSelector("a[class=btn btn-default add-to-cartn]");
    public  final By continueShoppingButton= By.cssSelector("a[class=\"btn btn-success close-modal btn-block\"]");
    public  final By cart= By.cssSelector("a[class=\"fa fa-shopping-cart\"]");
    public  final By checkout= By.cssSelector("a[class=\"btn btn-default check_out\"]");
    public  final By cardName= By.cssSelector("input[data-qa=name-on-card]");
    public  final By cardNumber= By.cssSelector("input[data-qa=card-number]");
    public  final By cvc= By.cssSelector("input[data-qa=cvc]");
    public  final By expiryMonth= By.cssSelector("input[data-qa=expiry-month]");
    public  final By expiryYear= By.cssSelector("input[data-qa=expiry-year]");
    public  final By submitBtn=By.id("submit");
    public  final By alert=By.cssSelector("div[class=continue-prompt-text]");
    public  final By popupFrame=By.cssSelector("iframe[id=aswift_3]");
    public  final By home= By.cssSelector("i[class=\"fa fa-home\"]");

    public LoginPageLocators(WebDriver driver) {
        this.driver=driver;
    }
}
