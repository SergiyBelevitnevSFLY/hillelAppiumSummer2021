import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstAndroidTest {


    @Test
    public void androidTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", System.getProperty("user.dir") + "/SauceLabsTestApp.apk");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("deviceName", "Pixel XL API 29");
        desiredCapabilities.setCapability("appActivity", ".SplashActivity");
        desiredCapabilities.setCapability("appPackage", "com.swaglabsmobileapp");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("test-Username");
        el1.sendKeys("standard_user");
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("test-Password");
        el2.sendKeys("secret_sauce");
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");
        el3.click();


        driver.quit();
    }
}
