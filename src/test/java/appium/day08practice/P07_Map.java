package appium.day08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import appium.basetest.MapBaseTest;

import java.time.Duration;

public class P07_Map extends MapBaseTest {
    @Test
    public void testMap() throws InterruptedException {
        // 1. Pencerenin ve butonun gelmesini esnek olarak bekle
        // Maksimum 15 saniye bekleyecek
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement devamEtBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Enregistrer\")")
        ));

// 2. Butona tıkla ve pencereyi kapat
        devamEtBtn.click();

        System.out.println("İlk açılış penceresi 'Continuer' butonuyla geçildi.");
        System.out.println("Satelit seçimi için koordinat tabanlı tıklanıyor...");
        clickGestureCoordinate(driver, 576, 420);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
        WebElement satelite = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/layers_menu_satellite_layer"));
        satelite.click();
        WebElement buttonX = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
        buttonX.click();
        WebElement searchBox = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Rechercher\")"));
        clickGesture(driver,searchBox);
        searchBox.sendKeys("Taj Mahal");
        //KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        //driver.pressKey(enter);
        //Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(14)")).click();
        System.out.println("Haritanın Taj Mahal'e odaklanması bekleniyor...");
        Thread.sleep(7000);

        System.out.println("--- ZOOM IN (Yakınlaşma) Başlıyor ---");

        pinchOpenGestureCoordinate(driver,335, 432, 400, 400, 1.0, 1000);

        Thread.sleep(3000); // Yakınlaşmayı izleyebilmek icin sure

        System.out.println("--- ZOOM OUT (Uzaklaşma) Başlıyor ---");
// Aynı merkez noktasına doğru parmakları kapatarak uzaklaşıyoruz
        pinchCloseGestureCoordinate(driver, 335, 432, 400, 400, 1.0, 1000);

// Testin bittiğini görmek için
        Thread.sleep(5000);

    }
}
