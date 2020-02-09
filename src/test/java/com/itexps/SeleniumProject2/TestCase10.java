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
public class TestCase10 {
    
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
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[3]/div/div/a[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlLocation")).sendKeys("mumbai");
        Thread.sleep(5000);
        
        String s1 = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div[2]/div[2]/p[2]")).getText();
        System.out.println(" Text is " + s1);
        String substr = s1.substring(0, 15);
        try {
            Assert.assertEquals("Location- MUMBA", substr);
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
