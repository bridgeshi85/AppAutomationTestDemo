package com.demo.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AppiumDriverFactory {

    public static AppiumDriver<MobileElement> driver;

    public static void initDriver(HashMap<String,String> map,String platform) throws MalformedURLException {
        String apkPath = "src/test/resources/app_packages/Philips_Sonicare_36_9.1.0-releasecandidate-9.1.0-fcb822d3a3-148_playstore.apk";

        if(platform.toLowerCase().equals("ios")){
            apkPath = "src/test/resources/app_packages/Philips_Sonicare-8-29102020_125607-releasecandidate-9.1.2-f69f0dbc84-912008_InHouse_Production.ipa";//ios的包
        }
        File app = new File(apkPath);
        //capabilities.setCapability(MobileCapabilityType.APP,encode(platformJson.get("app").toString()));

        DesiredCapabilities capabilities = new DesiredCapabilities(map);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        if(platform.toLowerCase().equals("android")){
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub/"), capabilities);
        }else{
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub/"), capabilities);
        }
    }
}
