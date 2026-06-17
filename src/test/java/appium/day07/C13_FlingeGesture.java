package appium.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import appium.basetest.ApiDemosBaseTest;

public class C13_FlingeGesture extends ApiDemosBaseTest {
    @Test
    public void testFlingGestureElement() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "speed",100000
        ));

    }

    @Test
    public void testflingGestureCoordinate() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();


        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", 102, "top", 302, "width", 0, "height", 1000,
                "direction", "down", // sola doğru swipe et
                "speed",2000
        ));

    }
}
