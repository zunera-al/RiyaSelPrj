/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.SeleniumProject2;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Zunera Ali
 */
public class TestCase01 {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = DriverUtils.getChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testRiya() throws Exception {
        driver.get("https://www.riya.travel/");
        driver.findElement(By.xpath("//img[@alt='offer']")).click();
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div[1]/div/ul/li[1]/a")).click();
        driver.findElement(By.name("UserName")).sendKeys("milup709@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("Miloni1711@");

        driver.findElement(By.xpath("/html/body/section/div/div/div[1]/form/div[8]/div[2]/button")).click();
        Thread.sleep(5000);

        String s1 = driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div[1]/a/span")).getText();
        System.out.println(" Text is " + s1);
        String substr = s1.substring(0, 12);
        try {
            Assert.assertEquals("Hey milup709", substr);
        } catch (Error e) {
            System.out.println(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
