package com.magento.utils;

import com.magento.pages.RegisterPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected RegisterPage registerPage;


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();//instanciando el objeto driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1200, 740));
        driver.get(Variables.BASE_URL);

        //pasando la instancia de driver creada en la linea 19 al POM
        registerPage = new RegisterPage(driver);


    }
    @AfterMethod
    public void tearDown() throws Exception {
        if(driver != null) {
            //driver.quit();
        }
    }

}
