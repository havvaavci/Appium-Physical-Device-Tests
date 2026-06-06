package techproed.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {

    @Test
    public void testDesiredCapabilities() throws MalformedURLException {
        // DesiredCapabilities yerine UiAutomator2Options kullan
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("988a1642334c524b5030");
        // Bilgisayar adın ne olursa olsun projenin içindeki resources klasörünü otomatik bulur:
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/ApiDemos.apk");
        //Timeout 
        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
    }

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("988a1642334c524b5030")
                .setApp(System.getProperty("user.dir") + "/src/test/resources/ApiDemos.apk");

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
    }
    //@Test
    public void testSamsungHesapMakinesi() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("988a1642334c524b5030");
        // Samsung Hesap Makinesi bilgileri
        options.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        // CMD ekranında eğik çizgiden sonra ne yazıyorsa aynen buraya yapıştır:
        options.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        driver.quit();

    }
   // @Test
    public void testCalculator() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("988a1642334c524b5030");
        options.setAppPackage("com.samsung.android.calculator");   // kendi package'ını yaz
        options.setAppActivity("com.samsung.android.calculator.Calculator"); // kendi activity'ni yaz

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);

        Thread.sleep(2000); // uygulama açılsın
        System.out.println("Hesap makinesi açıldı!");
        driver.quit();
    }



}