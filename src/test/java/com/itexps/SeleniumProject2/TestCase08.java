/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.SeleniumProject2;

import java.util.ArrayList;
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

/**
 *
 * @author Zunera Ali
 */
public class TestCase08 {

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
        System.out.println("USA");
        Thread.sleep(8000);

        driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[6]/a")).click();
        System.out.println("locate");
        Thread.sleep(8000);

        driver.findElement(By.xpath("//*[@id=\"tab2\"]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"usaOfficeCnt\"]/div[7]/div/div/a")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        String s1 = driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[8]/div/div[1]/span[3]/span[3]")).getText();
        System.out.println(" Address is " + s1);
        String substr = s1.substring(0, 35);
        try {
            Assert.assertEquals("717 E Golf Rd, Schaumburg, IL 60173", substr);
        } catch (Error e) {
            System.out.println(e.toString());
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
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
