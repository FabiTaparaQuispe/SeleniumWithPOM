package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;
    /*
    * Web Elements
    * */

    By linkAccount = By.linkText("Create Account");
    By name = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.id("password_confirmation");
    By registerButton = By.xpath("//*[@id='form-validate']/div/div[1]/button/span");


    /*
     * Constructor
     * */

    public RegisterPage(WebDriver driver) { //driver sera pasado desde la clase BaseTest en el metodo setUp()
        this.driver = driver;
    }

    /*
     * Methods, functions
     * */

    public void goToRegisterLink() {
        driver.findElement(linkAccount).click();
    }

    public void fillOutForm() {
        driver.findElement(name).sendKeys("Eduardo");
        driver.findElement(lastName).sendKeys("Hincho");
        driver.findElement(email).sendKeys("ahincho@unsa.edu.pe");
        driver.findElement(password).sendKeys("Sup3rP@ssword");
        driver.findElement(confirmPassword).sendKeys("Sup3rP@ssword");
    }

    public void fillOutFormWithFakeData(String sfname, String slastName, String semail, String spassword) {
        driver.findElement(name).sendKeys(sfname);
        driver.findElement(lastName).sendKeys(slastName);
        driver.findElement(email).sendKeys(semail);
        driver.findElement(password).sendKeys(spassword);
        driver.findElement(confirmPassword).sendKeys(spassword);
    }

    public void submitData() {
        driver.findElement(registerButton).submit();
    }

}
