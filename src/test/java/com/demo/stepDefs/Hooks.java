package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.java.After;


public class Hooks {

    @After
    public void resetApp(){
        System.out.println("after scenario");
        AppiumDriverFactory.driver.resetApp();
    }
}
