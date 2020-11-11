package com.demo.stepDefs;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void init(){
        System.out.println("before");
        //AppiumDriverFactory.initDriver();
    }
}
