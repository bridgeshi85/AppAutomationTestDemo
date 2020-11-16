package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import com.demo.pages.ConnectToothBrushPage;
import com.demo.pages.LandPage;
import com.demo.uitls.AppiumUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
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

    private final LandPage landPage = new LandPage();
    private ConnectToothBrushPage connectToothBrushPage;

    @Given("I accepted the privacy agreement")
    public void accepted_agreement() {
        //点击确定接受协议
        landPage.accept();
    }


    @When("click the start button")
    public void click_start_button() throws InterruptedException{
        //点击开始
        connectToothBrushPage = landPage.getStarted();
    }

    @And("start connect to toothbrush")
    public void iStartConnectToToothbrush(){
        connectToothBrushPage.startConnectToToothBrush();
    }

    @Then("should get failed page")
    public void should_failed() throws InterruptedException {
        Assert.assertEquals("We couldn't find your toothbrush.",connectToothBrushPage.getConnectResult());
    }


    @Given("cancel the privacy agreement")
    public void cancelThePrivacyAgreement() {
        landPage.clickCancel();
    }

    @When("click the terms and condition link")
    public void clickTheTermsAndConditionLink() {
        landPage.clickTerms();
    }

    @Then("should open browser")
    public void shouldOpenBrowser() throws InterruptedException {
        Thread.sleep(2000);

        Set<String> allContext = AppiumDriverFactory.driver.getContextHandles();

        //IOS和安卓的context不同
        Assert.assertTrue(allContext.contains("WEBVIEW_com.android.browser"));
    }

    @When("click the privacy policy link")
    public void clickThePrivacyPolicyLink() {
        landPage.clickPrivacyPolicy();
    }
}
