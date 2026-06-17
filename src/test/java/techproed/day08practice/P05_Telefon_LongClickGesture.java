package techproed.day08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import techproed.basetest.PhoneBaseTest;

public class P05_Telefon_LongClickGesture extends PhoneBaseTest {
    @Test
    public void testPhoneCall() throws InterruptedException {

        // 1. Klavyeyi (Keypad) aç
        WebElement keypad = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"com.google.android.dialer:id/navigation_bar_item_icon_view\").instance(1)"
        ));
        keypad.click();

        // 2. Kullanılacak rakam butonlarını BİRER KEZ tanımlıyoruz
        WebElement btn0 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"0\")"));
        WebElement btn2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"2\")"));
        WebElement btn4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"4\")"));
        WebElement btn5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"5\")"));
        WebElement btn6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"6\")"));
        WebElement btn8 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"8\")"));
        WebElement btn9 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"9\")"));

        WebElement btnDial = driver.findElement(AppiumBy.accessibilityId("dial"));

        // 3. Sıfır butonuna uzun basarak "+" karakterini çıkartıyoruz
        longClickGestureElement(driver, btn0, 2000);

        // 4. Tanımladığımız objeleri sırayla tıklatıyoruz (+905456528888)
        btn9.click();
        btn0.click();
        btn5.click(); // İlk 5
        btn4.click();
        btn5.click(); // İkinci 5 (Aynı objeyi tekrar kullandık)
        btn6.click();
        btn5.click(); // Üçüncü 5
        btn2.click();
        btn8.click(); // İlk 8
        btn8.click(); // İkinci 8
        btn8.click();
        btn8.click(); // Üçüncü 8

        // 5. Arama butonuna bas
        btnDial.click();

        // 6. Bekleme süresi
        Thread.sleep(5000);

        /*
        // Element Tanımlamaları by ile
By keypadButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.dialer:id/navigation_bar_item_icon_view\").instance(1)");
By zeroButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"0\")"); // + için buna uzun basacağız
By num9 = AppiumBy.androidUIAutomator("new UiSelector().text(\"9\")");
By num5 = AppiumBy.androidUIAutomator("new UiSelector().text(\"5\")");
By num4 = AppiumBy.androidUIAutomator("new UiSelector().text(\"4\")");
By num6 = AppiumBy.androidUIAutomator("new UiSelector().text(\"5\")");
By num6Actual = AppiumBy.androidUIAutomator("new UiSelector().text(\"6\")");
By num9Alt = AppiumBy.androidUIAutomator("new UiSelector().text(\"9\")");
By num8 = AppiumBy.androidUIAutomator("new UiSelector().text(\"8\")");
By num2 = AppiumBy.androidUIAutomator("new UiSelector().text(\"2\")");
By dialButton = AppiumBy.accessibilityId("dial");
         */
    }
}
