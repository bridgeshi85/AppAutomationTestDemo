package com.demo.runner;

import com.demo.base.AppiumDriverFactory;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Properties;

@CucumberOptions(features = "src/test/resources/features",
        glue = "com.demo.stepDefs",
        plugin = { "pretty" },
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static final HashMap<String,String> capabilitiesMap = new HashMap<String, String>();
    private static String platform;

    @BeforeSuite
    public void loadProperties(ITestContext testNGContext) throws IOException {

        //读取配置文件到map
        platform = testNGContext.getCurrentXmlTest().getParameter("platform");
        FileInputStream fis = new FileInputStream("src/test/resources/configs/"+ platform +".properties");
        Properties properties = new Properties();
        properties.load(fis);
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            capabilitiesMap.put(key, value);
        }
    }

    @BeforeSuite(dependsOnMethods = "loadProperties")
    public void initDriver() throws MalformedURLException {
        //传入map启动app
        AppiumDriverFactory.initDriver(capabilitiesMap,platform);
    }

}
