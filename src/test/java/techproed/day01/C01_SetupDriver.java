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
        options.setPlatformName("Android");//zorunlu
        options.setAutomationName("UiAutomator2");//zorunlu
        options.setUdid("R9WT3072EFX");//duruma gore degisir birden fazla cihaz varsa zorunlu
        options.setApp("C:\\Users\\havva\\IdeaProjects\\Appium_Project\\src\\test\\resources\\ApiDemos.apk");//zorunlu
        // Timeout'u 60 saniyeye çıkar
        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        driver.quit();
    }

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:\\Users\\havva\\IdeaProjects\\Appium_Project\\src\\test\\resources\\ApiDemos.apk")
                .setUdid("R9WT3072EFX")
                ;

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        driver.quit();
    }

    @Test
    public void testSamsungHesapMakinesi() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("R9WT3072EFX");
        // Samsung Hesap Makinesi bilgileri
        options.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        // CMD ekranında eğik çizgiden sonra ne yazıyorsa aynen buraya yapıştır:
        options.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        driver.quit();

    }
    @Test
    public void testCalculator() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("R9WT3072EFX");
        options.setAppPackage("com.samsung.android.calculator");   // kendi package'ını yaz
        options.setAppActivity("com.samsung.android.calculator.Calculator"); // kendi activity'ni yaz

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);

        Thread.sleep(2000); // uygulama açılsın
        System.out.println("Hesap makinesi açıldı!");
        driver.quit();
    }



}