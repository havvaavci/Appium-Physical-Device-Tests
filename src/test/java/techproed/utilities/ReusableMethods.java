package techproed.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class ReusableMethods {
    public void clickGesture(AndroidDriver driver, WebElement element) {
        // Java
        // Java
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    @Test
    public void clickGestureCoordinate(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void doubleClickGesture(AndroidDriver driver, WebElement element) {
        // Java
        // Java
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    @Test
    public void doubleClickGestureCoordinate(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void longClickGestureElement(AndroidDriver driver, WebElement element, int milisecond) {

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000 // 1 saniye basılı tut
        ));
    }

    public void longClickGestureElementCoordinate(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));

    }

    @Test
    public void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY) {


        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 665,  // Bırakılacak X koordinatı
                "endY", 576// Bırakılacak Y koordinatı

        ));

    }

    public void dragGestureCoordinate(AndroidDriver driver, int startX, int startY, int endX, int endY) {

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", 220,
                "startY", 587,
                "endX", 665,  // Bırakılacak X koordinatı
                "endY", 576// Bırakılacak Y koordinatı

        ));

    }

    public void scrollGestureElement(AndroidDriver driver, WebElement element, String direction, double percent) {

        // Java
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent
                //scrollun yavasligini kontrol ediyoruz yani yavas yavas yapiliyor gorebilmek icin yaptik
        ));

    }
    public void swipeGestureElement(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction, // "right", "left", "up", "down" değerlerini alabilir
                "percent", percent,     // 0.0 ile 1.0 arasında bir oran
                "speed", speed          // Kaydırma hızı
        ));

    }
    public void pinchOpenGestureElement(AndroidDriver driver, WebElement element, double percent) {

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", percent // Örn: 0.75
        ));

    }
    public void pinchOpenGestureCoordinate(AndroidDriver driver, int left, int top, int width, int height, double percent, int speed) {

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", left,
                "top", top,
                "width", width,
                "height", height,
                "percent", percent,
                "speed", speed
        ));

    }
    public void pinchCloseGestureElement(AndroidDriver driver, WebElement element, double percent) {

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", percent // Örn: 0.75
        ));

    }
    public void pinchCloseGestureCoordinate(AndroidDriver driver, int left, int top, int width, int height, double percent, int speed) {

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", left,
                "top", top,
                "width", width,
                "height", height,
                "percent", percent,
                "speed", speed // Parmakların kapanma hızı
        ));

    }


}
