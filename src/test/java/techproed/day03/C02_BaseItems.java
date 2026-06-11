package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import java.net.MalformedURLException;


public class C02_BaseItems extends ApiDemosBaseTest {
    @Test
    public void testBaseItems() throws MalformedURLException, InterruptedException {

        By appBy = AppiumBy.accessibilityId("App");
        By activityBy = AppiumBy.accessibilityId("Activity");
        //Custom Title elementini bulup tiklayin
        By customTitleBy = AppiumBy.accessibilityId("Custom Title");
        By leftTextBy = AppiumBy.id("io.appium.android.apis:id/left_text_edit");
        By rightTextBy = AppiumBy.id("io.appium.android.apis:id/right_text_edit");
        By changeLeftBy = AppiumBy.accessibilityId("Change Left");
        By changeRightBy = AppiumBy.accessibilityId("Change Right");
        driver.findElement(appBy).click();
        driver.findElement(activityBy).click();
        driver.findElement(customTitleBy).click();

        driver.findElement(leftTextBy).clear();
        driver.findElement(leftTextBy).sendKeys("Havva");
        driver.findElement(changeLeftBy).click();

        driver.findElement(rightTextBy).clear();
        driver.findElement(rightTextBy).sendKeys("Havva");
        //driver.setClipboardText("Rana Bebegim");
        //setclipboardtext yerine ayni gorevi yapacak baska bir method yazalim
        //Thread.sleep(2000);
        //driver.findElement(rightTextBy).sendKeys(driver.getClipboardText());
        //Thread.sleep(2000);
        driver.findElement(changeRightBy).click();
        //driver.quit();

        KeyEvent backKey = new KeyEvent().withKey(AndroidKey.BACK);
        driver.pressKey(backKey);
        Thread.sleep(2000);
        KeyEvent homeKey = new KeyEvent().withKey(AndroidKey.HOME);
        driver.pressKey(homeKey);

    }
}
