package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

public class MySteps {
    @Given("debug step")
    public void debugStep() {
        AppiumDriverFactory.driver.findElement(By.id("com.philips.cdp.ohc.tuscany:id/uid_dialog_positive_button")).click();
    }
}
