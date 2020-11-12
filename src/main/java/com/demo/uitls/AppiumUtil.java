package com.demo.uitls;

import com.demo.base.AppiumDriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumUtil {

    public static MobileElement waitForElementPresent(By elementLocator, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(AppiumDriverFactory.driver, timeOutInSeconds);
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public static boolean verifyElementExist(By elementLocator){
        if (AppiumDriverFactory.driver.findElements(elementLocator).size() > 0) {
            System.out.println("element: " + elementLocator.toString()+" found");
            return true;
        }
        else {
            System.out.println("element: " + elementLocator.toString() +" was not found on current page");
            return false;
        }
    }
}
