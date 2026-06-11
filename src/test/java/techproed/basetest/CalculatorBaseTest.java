package techproed.basetest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorBaseTest {
protected AndroidDriver driver;
@BeforeClass
    public void setup() throws MalformedURLException {
        // Hesap makinesi uygulamasını başlatmak için gerekli kodları buraya ekleyin
        // Samsung Hesap Makinesi için UiAutomator2Options oluştur
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("R9WT3072EFX");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity("com.sec.android.app.popupcalculator.Calculator");
        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);
    }

    @AfterClass
    public void afterClass() {
        // Testler tamamlandıktan sonra sürücüyü kapatın
        if (driver != null) {
            driver.quit();
        }
    }
}
