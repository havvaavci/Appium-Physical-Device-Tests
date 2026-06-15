package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import techproed.basetest.CalculatorBaseTest;
import techproed.utilities.ReusableMethods;

public class C08_DoubleClickGesture extends CalculatorBaseTest {
    @Test
    public void testDoubleClickGesture() {

        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("6")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        WebElement element = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        // Java
        //driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
           //     "elementId", ((RemoteWebElement) element).getId()
        //));
        doubleClickGesture(driver,element);
    }
    @Test
    public void testDoubleClickGestureCoordinate() {

        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("6")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        // Java
       // driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
             //   "x",845,
              //  "y",298
        //));
        doubleClickGestureCoordinate(driver,845,298);
    }
}
