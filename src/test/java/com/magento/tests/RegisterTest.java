package com.magento.tests;

import com.magento.utils.BaseTest;
import com.magento.utils.Variables;
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
        registerPage.goToRegisterLink();
        //fill the form
        //registerPage.fillOutForm();
        //fills the form with fake data
        registerPage.fillOutFormWithFakeData("Pedro", "Hincho", "", "Sup3rP@ssword");

        //submit the form
        registerPage.submitData();
        //driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")); //se debe evitar el xpath absoluto
        driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")).submit();//relativ

        //asertion //despues de haber enviado la informacion se registro de forma correcta o no se registro
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html")));

        Assert.assertEquals(msg.getText(), expected_message);


    }
}
