package techproed.day02;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import java.net.MalformedURLException;


public class C03_Locators extends ApiDemosBaseTest {
    @Test
    public void testLocators() throws MalformedURLException {

        //1 - Accessibility ID locator'ını kullanarak "Accessibility" elementini bulun ve yazdırın
        WebElement element= driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID: " + element.getText());
        //2 -id locator'ını kullanarak "Animation" elementini bulun ve yazdırın

        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("ID " + element.getText());

        //3 - className locator'ını kullanarak "Accessibility" elementini bulun ve yazdırın
        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("Class Name: " + element.getText());

        //4 androidUIAutomator locator'ını kullanarak "App" elementini bulun ve yazdırın
        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("Android UI Automator: " + element.getText());

        //5 xpath locator'ını kullanarak "Content" elementini bulun ve yazdırın
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("XPath: " + element.getText());
        driver.quit();
    }
}
