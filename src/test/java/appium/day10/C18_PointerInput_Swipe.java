package appium.day10;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import appium.basetest.ApiDemosBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C18_PointerInput_Swipe extends ApiDemosBaseTest {
    @Test
    public void testSwipe() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence sequence = new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),560,330))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),120,330))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
}
