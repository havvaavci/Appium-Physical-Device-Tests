package appium.day09;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import appium.basetest.CalculatorBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C16_PointerInput_DoubleTap extends CalculatorBaseTest {
    @Test
    public void testDoubleTap() {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("6")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        //   "x",845,
        //  "y",298

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence = new Sequence(finger,1)
                //ilk tiklama adimi
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),780,298))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                //ikinci tiklama adimi
                .addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(),775,295))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));




    }
}
