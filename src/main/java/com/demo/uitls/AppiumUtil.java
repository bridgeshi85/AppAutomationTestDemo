package com.demo.uitls;

import com.demo.base.AppiumDriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

public class AppiumUtil {

    public static MobileElement waitForElementClickAble(MobileElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(AppiumDriverFactory.driver, timeOutInSeconds);
        return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisible(MobileElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(AppiumDriverFactory.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
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
