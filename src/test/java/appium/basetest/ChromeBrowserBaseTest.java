package appium.basetest;

import appium.utilities.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeBrowserBaseTest extends ReusableMethods {
protected AndroidDriver driver;
@BeforeClass
    public void setup() throws MalformedURLException {
        // Hesap makinesi uygulamasını başlatmak için gerekli kodları buraya ekleyin
        // Samsung Hesap Makinesi için UiAutomator2Options oluştur
        UiAutomator2Options options = new UiAutomator2Options()
                .withBrowserName("chrome");

       // options.setUdid("R9WT3072EFX");



        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void afterClass() {
        // Testler tamamlandıktan sonra sürücüyü kapatın
        if (driver != null) {
            driver.quit();
        }
    }
}
