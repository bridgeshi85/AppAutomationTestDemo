package com.demo.stepDefs;

import io.cucumber.java.en.Given;

public class MySteps {
    @Given("debug step")
    public void debugStep() {

        System.out.println("debug");
    }
}
