package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_NativeElements {
    @Test
    public void testNativeElementsAppiumBy() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos.apk";
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)

                ;

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        WebElement appElement = driver.findElement(AppiumBy.accessibilityId("App"));
        appElement.click();
        WebElement alarmElement = driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarmElement.click();
        WebElement alarmControllerElement = driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));
        alarmControllerElement.click();
        driver.quit();
    }
    @Test
    public void testNativeElementsBy() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos.apk";
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)

                ;

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        By appBy = AppiumBy.accessibilityId("App");
        By alarmBy = AppiumBy.accessibilityId("Alarm");
        By alarmControllerBy = AppiumBy.accessibilityId("Alarm Controller");
        driver.findElement(appBy).click();
        driver.findElement(alarmBy).click();
        driver.findElement(alarmControllerBy).click();
        driver.quit();
    }
}
