package techproed.day03;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import java.net.MalformedURLException;


public class C01_NativeElements extends ApiDemosBaseTest {
    @Test
    public void testNativeElementsAppiumBy() throws MalformedURLException {

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

        By appBy = AppiumBy.accessibilityId("App");
        By alarmBy = AppiumBy.accessibilityId("Alarm");
        By alarmControllerBy = AppiumBy.accessibilityId("Alarm Controller");
        driver.findElement(appBy).click();
        driver.findElement(alarmBy).click();
        driver.findElement(alarmControllerBy).click();
        driver.quit();
    }
}
