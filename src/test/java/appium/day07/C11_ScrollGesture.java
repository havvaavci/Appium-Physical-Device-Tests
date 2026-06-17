package appium.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import appium.basetest.ApiDemosBaseTest;

public class C11_ScrollGesture extends ApiDemosBaseTest {

    @Test
    public void testScrollElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //sayfada istedigimiz elemente kadar kaydirmak icin kullanilan method
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spinner\"))"));
        Thread.sleep(5000);
    }

    @Test
    public void testScrollGestureElement() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        // Java
         driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                 "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 2.0,
                 "speed",500 //scrollun yavasligini kontrol ediyoruz yani yavas yavas yapiliyor gorebilmek icin yaptik
        ));

         /*
         Asagiya dogru scroll yapmak icin
         driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                 "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 2.0,
                 "speed",500
        ));
          */
    }
    @Test

    public void testScrollGestureElementCoordinate() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // Java
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 220, "width", 900, "height", 900,
                "direction", "down",
                "percent", 1.0,
                "speed",500
        ));


    }
    @Test
    public void testScrollGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100,
                    "top", 300,
                    "width", 0,
                    "height", 1000,
                    "direction", "down",
                    "percent", 1.0,
                    "speed", 500
            ));
        }
    }

}
