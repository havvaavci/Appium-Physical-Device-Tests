package techproed.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C03_Locators {
    @Test
    public void testLocators() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos.apk";
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)

                ;

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
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
