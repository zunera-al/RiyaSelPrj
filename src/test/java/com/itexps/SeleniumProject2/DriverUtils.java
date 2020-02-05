/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.SeleniumProject2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author Zunera Ali
 */
public class DriverUtils {

    public static WebDriver getChromeDriver() {//web driver is interface
        //setup chrome
        System.setProperty("webdriver.chrome.driver", "C:\\QA\\Driver\\chromedriver.exe");//(type,value)
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        return new ChromeDriver(capabilities);//chrome driver implements webdriver

    }

    public static void main(String[] args) {
        getChromeDriver();

    }

}
