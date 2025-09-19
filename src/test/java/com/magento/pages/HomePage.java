package com.magento.pages;

import com.magento.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;
    /*
     * Web Elements
     * */
    By linkSignIn = By.linkText("Sign In");
    By linkAccount = By.linkText("Create Account");
    /*
     * Constructor
     * */
    public HomePage(WebDriver driver) {
        super(driver);
        visit(Variables.BASE_URL);
    }
    /*
     * Methods
     * */
    public void goToRegisterLink() {
        clone(linkAccount);

    }
    public void goToSignInLink() {
        click(linkSignIn);
    }
    public String verifyTitle() {
        return null;
    }
}
