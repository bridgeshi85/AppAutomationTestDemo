package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import com.demo.uitls.AppiumUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.util.Set;

public class MySteps {

    @Given("I accepted the privacy agreement")
    public void accepted_agreement() {
        //点击确定接受协议
        AppiumDriverFactory.driver.findElement(By.id("com.philips.cdp.ohc.tuscany:id/uid_dialog_positive_button")).click();
    }


    @When("click the start button")
    public void click_start_button() throws InterruptedException{
        //点击开始
        AppiumDriverFactory.driver.findElementById("com.philips.cdp.ohc.tuscany:id/getStartedButton").click();
        Thread.sleep(2000);
    }

    @And("start connect to toothbrush")
    public void iStartConnectToToothbrush() throws InterruptedException{
        //点击连接牙刷
        AppiumDriverFactory.driver.findElementById("com.philips.cdp.ohc.tuscany:id/titleTextView").click();
        Thread.sleep(2000);

        //开启允许访问我的位置
        AppiumDriverFactory.driver.findElementById("com.philips.cdp.ohc.tuscany:id/location_permission_switch").click();
        Thread.sleep(2000);
        //点击始终允许

        AppiumDriverFactory.driver.findElementById("android:id/button1").click();
    }

    @Then("should get failed page")
    public void failed_alert(){
        AppiumUtil.waitForElementPresent(By.id("com.philips.cdp.ohc.tuscany:id/imageView"),40);

        Assert.assertEquals(AppiumDriverFactory.driver.findElementById("com.philips.cdp.ohc.tuscany:id/heading").getText(),
                "We couldn't find your toothbrush.");
    }


    @Given("cancel the privacy agreement")
    public void cancelThePrivacyAgreement() {
        AppiumDriverFactory.driver.findElement(
                By.id("com.philips.cdp.ohc.tuscany:id/uid_dialog_negative_button")
        ).click();

    }

    @When("click the terms and condition link")
    public void clickTheTermsAndConditionLink() {

        MobileElement element = AppiumUtil.waitForElementPresent(
                By.id("com.philips.cdp.ohc.tuscany:id/uid_alert_message"),5
        );

        Point point = element.getLocation();

        int x = point.x + 30;
        int y = point.y + element.getSize().getHeight() - 40;

        new TouchAction<>(AppiumDriverFactory.driver).tap(PointOption.point(x,y)).perform();
    }

    @Then("should open browser")
    public void shouldOpenBrowser() throws InterruptedException {
        Thread.sleep(2000);

        Set<String> allContext = AppiumDriverFactory.driver.getContextHandles();
        Assert.assertTrue(allContext.contains("WEBVIEW_com.android.browser"));
    }

    @When("click the privacy policy link")
    public void clickThePrivacyPolicyLink() {
        MobileElement element = AppiumUtil.waitForElementPresent(
                By.id("com.philips.cdp.ohc.tuscany:id/uid_alert_message"),5
        );

        Point point = element.getLocation();

        int x = point.x + element.getSize().getWidth() - 80;
        int y = point.y + element.getSize().getHeight() - 40;

        new TouchAction<>(AppiumDriverFactory.driver).tap(PointOption.point(x,y)).perform();
    }
}
