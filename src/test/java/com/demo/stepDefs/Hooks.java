package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.java.After;
import org.testng.annotations.AfterTest;

public class Hooks {

    @After
    public void resetApp(){
        System.out.println("after");
        AppiumDriverFactory.driver.resetApp();
    }
}
