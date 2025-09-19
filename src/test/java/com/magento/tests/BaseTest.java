package com.magento.tests;

import com.magento.pages.HomePage;
import com.magento.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected RegisterPage registerPage;


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();//instanciando el objeto driver
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);


    }
    @AfterMethod
    public void tearDown() throws Exception {
        if(driver != null) {
            driver.quit();
        }
    }

}
