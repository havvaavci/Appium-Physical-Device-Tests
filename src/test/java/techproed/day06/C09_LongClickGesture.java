package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C09_LongClickGesture extends ApiDemosBaseTest {
    @Test
    public void testLongClickGestureElement() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
       WebElement element= driver.findElement(AppiumBy.accessibilityId("Long press me"));

        //driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
             //   "elementId", ((RemoteWebElement) element).getId(),
               // "duration", 1000 // 1 saniye basılı tut
        //));
        longClickGestureElement(driver,element,2000);
    }
    @Test
    public void testLongClickGestureElementCoordinate() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();


        //driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
           //     "x", 531,
             //   "y",437
        //));
        longClickGestureElementCoordinate(driver,531,467);

        //uzun basinca cikan menuden secim yapma
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Menu A\")")).click();
    }
}
