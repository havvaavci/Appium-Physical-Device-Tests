package appium.day12;

import appium.basetest.ApiDemosBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class C26_HybridApplicationTest extends ApiDemosBaseTest {

    @Test
    public void testHybrid() {
        /**
         * 💡 APPIUM SERVER BAŞLATMA NOTU (HİBRİT UYGULAMALAR İÇİN BEST PRACTICE)
         *
         * Android cihazlardaki Hybrid (WebView) yapıları test ederken, cihazın Chrome/WebView sürümü ile
         * bilgisayardaki Chromedriver sürümünün birebir eşleşmesi gerekir. Sürümler uyuşmadığında test çöker.
         *
         * Appium'un uygun Chromedriver sürümünü internetten otomatik olarak bulup indirmesini sağlamak için
         * terminalden Appium sunucusunu sadece 'appium' diyerek değil, aşağıdaki özel izin komutuyla başlatmalıyız:
         *
         * CMD / Terminal Komutu:
         * -----------------------------------------------------------------------------------------
         * appium --allow-insecure=uiautomator2:chromedriver_autodownload
         * -----------------------------------------------------------------------------------------
         *
         * NOT:
         * - Bilgisayardaki mevcut Chromedriver ile telefondaki Chrome sürümü tesadüfen eşleştiğinde
         *   bu komut olmadan da testler geçebilir. Ancak cihaz/tarayıcı güncellendiğinde testlerin
         *   aniden patlamasını önlemek için bu komut en güvenli sigortadır (Best Practice).
         * - Bu komut hem standart (Native) hem de Hibrit testleri aynı anda destekler;
         *   her test tipi için sunucuyu kapatıp açmaya gerek yoktur.
         */


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        duration(3);
        Set<String> contextHandles = driver.getContextHandles();
        for (String contextName : contextHandles) {
            System.out.println("contextName = " + contextName);
        }


        //web uygulamaya gecis yapiyoruz contexti degistiriyoruz
        driver.context("WEBVIEW_io.appium.android.apis");

        System.out.println("URL/ " + driver.getCurrentUrl());
        //web uygulamada yani hybridde oldugumuz icin seleniumdaki locateleri kullanabiliyoruz
        System.out.println("Baslik : " + driver.findElement(By.tagName("h1")).getText());
        //native uygulamaya gecmek icin back tusuna basiyoruz
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //tekrar native uygulamaya gecis context i degistiriyoruz
        driver.context("NATIVE_APP");
        driver.findElement(AppiumBy.accessibilityId("Visibility")).click();
        duration(2);


    }

    @Test
    public void testHybridInformation() {
        /**
         * 🔄 HİBRİT UYGULAMALARDA BAĞLAM (CONTEXT) DEĞİŞTİRME MANTIĞI
         * * 1. Neden List değil de Set?
         * Appium'un getContextHandles() metodu benzersiz (unique) bağlam adları döndürür.
         * Java'da tekrarlayan verileri engellemek ve benzersiz elemanları tutmak için Set kullanılır.
         * * 2. For Döngüsü Ne Yapıyor?
         * Uygulama açıldığında Appium hem 'NATIVE_APP' (mobil çeper) hem de 'WEBVIEW_...' (web alanı)
         * bağlamlarını yakalar ve Set içine koyar. For döngüsü ile bu bağlamlar arasında dönerek
         * hedefimiz olan WEBVIEW alanını bulup driver'ı o dünyaya geçiş yaptırırız (Switching).
         */

// 1. Mevcut tüm aktif bağlamları (Context) bir Set içerisine topluyorum
        Set<String> tumContextler = driver.getContextHandles();

// 2. For-each döngüsü ile yakalanan tüm bağlamları tek tek kontrol ediyorum
        for (String contextIsmi : tumContextler) {
            // Yakalanan bağlam adını konsola yazdırarak doğrulamak iyi bir pratik (Best Practice)
            System.out.println("Bulunan Bağlam: " + contextIsmi);

            // Eğer bağlam ismi 'WEBVIEW' içeriyorsa, artık web elementlerine erişebilirim demektir
            if (contextIsmi.contains("WEBVIEW")) {
                // Driver'ı mobil dünyadan çıkarıp, web dünyasına (WebView) geçiriyorum
                driver.context(contextIsmi);
                System.out.println("🎯 Başarıyla WEBVIEW dünyasına geçiş yapıldı!");
                break; // Hedef bağlamı bulduğumuz için döngüden çıkabiliriz
            }
        }
    }
}
