package com.demo.pages;

import com.demo.base.AppiumDriverFactory;
import com.demo.base.BasePage;
import com.demo.uitls.AppiumUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class ConnectToothBrushPage extends BasePage {

    @AndroidFindBy(id="com.philips.cdp.ohc.tuscany:id/titleTextView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement txtConnectToothBrush;

    @AndroidFindBy(id="android:id/button1")
    public MobileElement btnAndroidAlwaysAllowed;

    @AndroidFindBy(id="com.philips.cdp.ohc.tuscany:id/location_permission_switch")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement locationPermissionSwitch;


    @AndroidFindBy(id = "com.philips.cdp.ohc.tuscany:id/imageView")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement alertImg;

    @AndroidFindBy(id = "com.philips.cdp.ohc.tuscany:id/heading")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement resultHeading;

    public ConnectToothBrushPage() {
        super();
    }

    public void startConnectToToothBrush(){
        AppiumUtil.waitForElementClickAble(txtConnectToothBrush,10).click();
        if(AppiumDriverFactory.isAndroid()){
            locationPermissionSwitch.click();
            btnAndroidAlwaysAllowed.click();
        }else if(AppiumDriverFactory.isIOS()){
            System.out.println("ios");

            //IOS开启位置操作
        }
    }

    public String getConnectResult() throws InterruptedException{
        Thread.sleep(30000);
        AppiumUtil.waitForElementVisible(alertImg,60);

        return resultHeading.getText();
    }
}
