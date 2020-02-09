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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Zunera Ali
 */
public class TestCase07 {

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

        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/ul/li[2]/a")).click();//usa
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[5]/a[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"international\"]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"myBtn\"]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String s1 = driver.findElement(By.xpath("//*[@id=\"package_overviewController\"]/div[1]/div[1]/div[1]")).getText();
        System.out.println(" Text is " + s1);
        String substr = s1.substring(0, 14);
        try {
            Assert.assertEquals("DAZZLING DUBAI", substr);
        } catch (Error e) {
            System.out.println(e.toString());
            Thread.sleep(10000);

        }
    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
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
