package techproed.day02;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import java.net.MalformedURLException;


public class C04_Traville_Locator extends ApiDemosBaseTest {
    @Test
    public void testLocator() throws MalformedURLException {

        WebElement accessibilityElement = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("accessibilityElement = " + accessibilityElement);

        WebElement contentElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Content\")"));
        System.out.println("contentElement = " + contentElement);

        //android.widget.TextView bu elementin locateini className locator'ı ile yapalım
        WebElement textViewElement = driver.findElements(AppiumBy.className("android.widget.TextView")).get(6);
        System.out.println("textViewElement = " + textViewElement);

        //new UiSelector().text("NFC") bu elementin locateini androidUIAutomator locator'ı ile yapalım
        WebElement nfcElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"NFC\")"));
        System.out.println("nfcElement = " + nfcElement);
        ////android.widget.TextView[@content-desc="OS"] bu elementin locateini xpath locator'ı ile yapalım
        WebElement osElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"OS\"]"));
        System.out.println("osElement = " + osElement);
        driver.quit();

    }
}
