package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    WebDriver driver;
    /*
    * Web Elements
    * */
    By name = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.id("password_confirmation");
    By registerButton = By.xpath("//*[@id='form-validate']/div/div[1]/button/span");


    /*
     * Constructor
     * */

    public RegisterPage(WebDriver driver) {
        super(driver); //driver sera pasado desde la clase BaseTest en el metodo setUp()
        this.driver = driver;
    }

    /*
     * Methods, functions
     * */
    public void fillOutForm() {
        type(name, "Grissel");
        type(lastName, "Tapara");
        type(email, "gtapara@unsa.edu.pe");
        type(password, "Sup3rP@ssword");
        type(confirmPassword, "Sup3rP@ssword");
    }

    public void fillOutFormWithFakeData(String sfname, String slastName, String semail, String spassword) {
        type(name,sfname);
        type(lastName, slastName);
        type(email, semail);
        type(password, spassword);
        type(confirmPassword, spassword);
    }

    public void submitData() {
        click(registerButton);
    }

}
