package techproed.day03;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import java.net.MalformedURLException;


public class C03_AttireValueElements extends ApiDemosBaseTest {

    @Test
    public void testAttireValue() throws MalformedURLException {

        By accessibilityBy = AppiumBy.accessibilityId("Accessibility");
        System.out.println("Get Text = " + driver.findElement(accessibilityBy).getText());
        System.out.println("get attribute = " + driver.findElement(accessibilityBy).getAttribute("package"));
        System.out.println("get attribute = " + driver.findElement(accessibilityBy).getAttribute("checkable"));

        System.out.println("is Selected = " + driver.findElement(accessibilityBy).isSelected());
        System.out.println("is enabled = " + driver.findElement(accessibilityBy).isEnabled());
        System.out.println("is displayed = " + driver.findElement(accessibilityBy).isDisplayed());

        System.out.println("Get Size = " + driver.findElement(accessibilityBy).getSize());
        System.out.println("Get Location = " + driver.findElement(accessibilityBy).getLocation());

    }
}
