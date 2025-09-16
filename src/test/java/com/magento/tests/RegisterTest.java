package com.magento.tests;

import com.github.javafaker.Faker;
import com.magento.utils.BaseTest;
import com.magento.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;


public class RegisterTest extends BaseTest {

    Faker faker = new Faker(new Locale("en-US"));



    @Test
    public void registerNewAccountWithRequiresInformation() {
        String expected_message = "Account Information";

        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8,10,true,true,true);

        //go to register page
        registerPage.goToRegisterLink();
        //fill the form
        //registerPage.fillOutForm();
        //fills the form with fake data
        registerPage.fillOutFormWithFakeData(faker.name().firstName(), faker.name().lastName(), email, faker.internet().password());

        //submit the form
        registerPage.submitData();


        //driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")); //se debe evitar el xpath absoluto
        driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")).submit();//relativ

        //asertion //despues de haber enviado la informacion se registro de forma correcta o no se registro
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html")));

        System.out.println("Email is: " + email + "Password is: " + password);
        Assert.assertEquals(msg.getText(), expected_message);


    }
}
