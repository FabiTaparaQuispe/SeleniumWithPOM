package com.magento.tests;

import com.magento.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class RegisterTest extends BaseTest {
    @Test
    public void registerNewAccountWithRequiresInformation() {
        String expected_message = "Account Information";
        //go to register page
        driver.findElement(By.linkText("Create Account")).click();
        //fill the form
        driver.findElement(By.id("firstname")).sendKeys("Angel");
        driver.findElement(By.id("lastname")).sendKeys("Hincho");
        driver.findElement(By.id("email_address")).sendKeys("ahincho@unsa.edu.pe");
        driver.findElement(By.id("password")).sendKeys("Sup3rP@ssword");
        driver.findElement(By.id("password_confirmation")).sendKeys("Sup3rP@ssword");

        //driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")); //se debe evitar el xpath absoluto
        driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")).submit();//relativ

        //asertion //despues de haber enviado la informacion se registro de forma correcta o no se registro
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html")));

        Assert.assertEquals(msg.getText(), expected_message);


    }
}
