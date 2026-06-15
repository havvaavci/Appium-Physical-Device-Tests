package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C12_SwipeGesture extends ApiDemosBaseTest {
    @Test
    public void testSwipeGestureElement() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left", // Sağa doğru swipe et
                "percent", 0.75,
                "speed",700
        ));

    }

    @Test
    public void testSwipeGestureCoordinate() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();


        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 102, "top", 302, "width", 900, "height", 200,
                "direction", "left", // sola doğru swipe et
                "percent", 0.75,
                "speed",700
        ));

    }
}
