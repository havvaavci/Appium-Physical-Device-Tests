package appium.day08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import appium.basetest.KitapYurduBaseTest;

import java.time.Duration;
import java.util.List;

public class P06_KitapYurdu_ScrollSwipeGesture extends KitapYurduBaseTest {

    @Test
    public void testKitapYurdu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Pop-up Kontrolü (Senin yapın)
        try {
            WebElement laterBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.mobisoft.kitapyurdu:id/btnLaterOn")));
            laterBtn.click();
        } catch (Exception e) {
            System.out.println("Pop-up geçildi.");
        }

        // Senin locator'ın: recyclerViewList görünene kadar bekliyoruz
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/recyclerViewList\").instance(0)")
        ));

        // Senin koordinatlı swipe metodun
        swipeGestureCoordinate(driver, 100, 950, 880, 100, "left", 0.6, 1100);

        // CHANCE HERE: Kaydırma efektini gözünle görebilmek için ekranı 3 saniye donduruyoruz
        Thread.sleep(3000);

        // Senin locator'ın: Kaydırma sonrası 3. kitaba tıklama
        WebElement hedefKitap = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/imageViewProduct\").instance(2)")
        ));
        hedefKitap.click();
        System.out.println("Senin koordinatlarınla yatay kaydırma başlıyor...");


        System.out.println("Kaydırma tamamlandı!");
        // CHANGE HERE: Detay sayfasındaki scroll alanının gerçek ID'sini yazdık
        WebElement scrolElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView")
        ));

        scrollGestureElement(driver, scrolElement, "down", 2.3, 1000);

        List<WebElement> kitapBilgileri = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                AppiumBy.xpath("//android.widget.ScrollView[@resource-id='com.mobisoft.kitapyurdu:id/productDetailScrollView']//android.widget.TextView")
        ));

// 2. Listenin indekslerini kullanarak konsola yazdırıyoruz
        System.out.println("================ KITAP BILGILERI ================");
        System.out.println("Kitap Adı: " + kitapBilgileri.get(0).getText());
        System.out.println("Yazar Adı: " + kitapBilgileri.get(1).getText());
        System.out.println("Yayınevi Adı: " + kitapBilgileri.get(2).getText());
        System.out.println("=================================================");

    }
    @Test
    public void testKitapYurdu2() throws InterruptedException {
        // 1. Maksimum 15 saniye bekleyecek esnek wait nesnesini bir kez tanımlıyoruz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 2. Pop-up'ın tıklanabilir olmasını ESNEK olarak bekle ve varsa tıkla
        try {
            WebElement laterBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.mobisoft.kitapyurdu:id/btnLaterOn")
            ));
            laterBtn.click();
            System.out.println("Pop-up görüldü ve başarıyla kapatıldı.");
        } catch (Exception e) {
            System.out.println("Pop-up ekranda bulunamadı veya zaten geçilmişti. Teste devam ediliyor...");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 3. Kaydırılacak ana listenin ekranda görünür (visible) olmasını ESNEK olarak bekle
        WebElement swipeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.mobisoft.kitapyurdu:id/recyclerViewList\").instance(0)")
        ));
       swipeGestureElement(driver, swipeElement, "left", 1.0, 1000);

        // 2. Beşinci kitaba xpath kullanarak odaklan ve tıkla
        WebElement besinciKitap = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/imageViewProduct\"])[5]"));
        clickGesture(driver, besinciKitap);

        // 3. Ürün detay sayfasındaki Kitap Bilgilerini (Ad, Yazar, Yayınevi) çek ve konsola yazdır
        List<WebElement> kitapBilgileri = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView[@resource-id=\"com.mobisoft.kitapyurdu:id/productDetailScrollView\"]//android.widget.TextView"));
        System.out.println("Kitap Adı: " + kitapBilgileri.get(0).getText());
        System.out.println("Yazar Adı: " + kitapBilgileri.get(1).getText());
        System.out.println("Yayınevi Adı: " + kitapBilgileri.get(2).getText());

        // 4. Ürün detay sayfasında aşağıya doğru scroll (kaydırma) yap
        WebElement scrollElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView"));
        scrollGestureElement(driver, scrollElement, "down", 2.3, 1000);

        // 5. Sonucu gözlemlemek için bekleme
        Thread.sleep(5000);
    }
}