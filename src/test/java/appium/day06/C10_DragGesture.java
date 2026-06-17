package appium.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import appium.basetest.ApiDemosBaseTest;

public class C10_DragGesture extends ApiDemosBaseTest {
    @Test
    public void testDragGesture() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //driver.executeScript("mobile: dragGesture", ImmutableMap.of(
         //       "elementId", ((RemoteWebElement) element).getId(),
          //      "endX", 665,  // Bırakılacak X koordinatı
          //      "endY", 576,// Bırakılacak Y koordinatı
          //      "speed",500
       // ));
    dragGesture(driver,element,665,576);
    }
    @Test
    public void testDragGestureCoordinate() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", 220,
                "startY", 587,
                "endX", 665,  // Bırakılacak X koordinatı
                "endY", 576,// Bırakılacak Y koordinatı
                "speed",500
        ));
        dragGestureCoordinate(driver,220,587,665,576);

    }
}
