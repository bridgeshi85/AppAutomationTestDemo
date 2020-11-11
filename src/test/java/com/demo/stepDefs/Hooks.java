package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    //@Before
    public void init() throws MalformedURLException {

        AppiumDriverFactory.initDriver();
    }

    @After
    public void resetApp(){
        AppiumDriverFactory.driver.resetApp();
    }
}
