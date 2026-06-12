package techproed.day04practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class P01_ApiDemos extends ApiDemosBaseTest {
    @Test
    public void testApiDemos() {
        By preferences = AppiumBy.accessibilityId("Preference");
        By dependencies = AppiumBy.accessibilityId("3. Preference dependencies");
        By checkBox = By.id("android:id/checkbox");
        By wifiSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By title = By.id("android:id/alertTitle");
        By textBox = AppiumBy.className("android.widget.EditText");
        By okButton= By.id("android:id/button1");

        driver.findElement(preferences).click();
        driver.findElement(dependencies).click();
        driver.findElement(checkBox).click();
        driver.findElement(wifiSettings).click();
        Assert.assertEquals(driver.findElement(title).getText(),"WiFi settings");
        driver.findElement(textBox).sendKeys("Havva");
        driver.findElement(okButton).click();
    }
}
