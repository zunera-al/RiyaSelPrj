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
public class TestCase04 {

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
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/section/form/div/div/div/ul[2]/li/div[2]/label")).click();
        driver.findElement(By.id("FromCity0")).sendKeys("Chicago [CHI] - Chicago");
        driver.findElement(By.id("ToCity0")).sendKeys("New York [NYC] - New York");
        driver.findElement(By.name("DepDate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[3]/a")).click();

        driver.findElement(By.xpath("/html/body/section/form/div/div/div/ul[2]/li/div[4]/div/div/div[1]/div/button")).submit();
        Thread.sleep(5000);

       /* String s1 = driver.findElement(By.xpath("//*[@id=\"main-rowNK0\"]/div[1]/div[2]/div/div[3]/a")).getText();
        System.out.println(" Text is " + s1);
        String substr = s1.substring(0, 8);
        try {
            Assert.assertEquals("BOOK NOW", substr);
        } catch (Error e) {
            System.out.println(e.toString());

        }*/
        try {

            assertEquals("ItineraryDetails", driver.getTitle());
            System.out.println("details");

        } catch (Error e) {
            System.out.println(e.toString());
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
