package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.VodQABaseTest;

public class C14_PinchOpenAndCloseGesture extends VodQABaseTest {
    @Test
    public void testPinchOpenGesture() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LOG IN\")")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)"));

        // Java
         driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75,
                 "speed",500
        ));

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75,
                "speed",500
        ));
    }
    @Test
    public void testPinchOpenGestureCoordinate() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LOG IN\")")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)"));

        // Java
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 140, "top", 900, "width", 700, "height", 500,
                "percent", 0.75,
                "speed",500
        ));
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 140, "top", 900, "width", 700, "height", 500,
                "percent", 0.75,
                "speed",500
        ));
    }
}
