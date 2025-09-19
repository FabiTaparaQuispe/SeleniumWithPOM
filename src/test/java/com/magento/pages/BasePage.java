package com.magento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    int timeOutSec = 10;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));
    }
    public void setTimeOutSec(int timeOutSec) {
        this.timeOutSec = timeOutSec;
    }
    public void visit(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutSec));
        driver.get(url);
    }

}
