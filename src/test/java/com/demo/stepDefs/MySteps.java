package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class MySteps {

    @Given("I accepted the agreement")
    public void accepted_agreement() {
        //点击确定接受协议
        AppiumDriverFactory.driver.findElement(By.id("com.philips.cdp.ohc.tuscany:id/uid_dialog_positive_button")).click();
    }


    @When("I click the start button")
    public void iClickTheStartButton() throws InterruptedException{
        //点击开始
        AppiumDriverFactory.driver.findElementById("com.philips.cdp.ohc.tuscany:id/getStartedButton").click();
        Thread.sleep(2000);
    }

    @And("I start connect to toothbrush")
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
}
