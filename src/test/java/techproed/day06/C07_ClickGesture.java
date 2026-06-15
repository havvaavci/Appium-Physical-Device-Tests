package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C07_ClickGesture extends ApiDemosBaseTest {
    @Test
    public void testClickGesture() throws InterruptedException {
        System.out.println("Telefon cozunurluk = " + driver.manage().window().getSize());
        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));
        // Java
        //driver.executeScript("mobile: clickGesture", ImmutableMap.of(
         //       "elementId", ((RemoteWebElement) os).getId()
        //));
        clickGesture(driver,os);

    }

    @Test
    public void testClickGestureCoordinate() {
        //driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                //"x", 261,
                //"y",970
        //));
        clickGestureCoordinate(driver,350,500);
    }


}
