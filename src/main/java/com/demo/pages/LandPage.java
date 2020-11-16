package com.demo.pages;

import com.demo.base.AppiumDriverFactory;
import com.demo.base.BasePage;
import com.demo.uitls.AppiumUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;


public class LandPage extends BasePage {

    @AndroidFindBy(id="com.philips.cdp.ohc.tuscany:id/uid_dialog_positive_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement btnPositive;

    @AndroidFindBy(id="com.philips.cdp.ohc.tuscany:id/uid_dialog_negative_button")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement btnNegative;

    @AndroidFindBy(id="com.philips.cdp.ohc.tuscany:id/getStartedButton")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement getStartedButton;

    @AndroidFindBy(id="com.philips.cdp.ohc.tuscany:id/uid_alert_message")
    @iOSXCUITFindBy(accessibility = "")
    public MobileElement cancelAlertTxtView;

    public LandPage() {
        super();
    }

    public void accept(){
        //点击ok
        btnPositive.click();
    }

    public void clickCancel(){
        //点击cancel
        btnNegative.click();
    }

    public ConnectToothBrushPage getStarted(){
        AppiumUtil.waitForElementClickAble(getStartedButton,10).click();
        return new ConnectToothBrushPage();
    }

    public void clickTerms(){
        AppiumUtil.waitForElementVisible(cancelAlertTxtView,10);

        Point point = cancelAlertTxtView.getLocation();
        int x = point.x + 30;
        int y = point.y + cancelAlertTxtView.getSize().getHeight() - 40;

        new TouchAction<>(AppiumDriverFactory.driver).tap(PointOption.point(x,y)).perform();
    }

    public void clickPrivacyPolicy(){
        AppiumUtil.waitForElementVisible(cancelAlertTxtView,10);

        Point point = cancelAlertTxtView.getLocation();
        int x = point.x + cancelAlertTxtView.getSize().getWidth() - 80;
        int y = point.y + cancelAlertTxtView.getSize().getHeight() - 40;

        new TouchAction<>(AppiumDriverFactory.driver).tap(PointOption.point(x,y)).perform();
    }
}
