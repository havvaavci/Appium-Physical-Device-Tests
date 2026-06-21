package appium.basetest;

import appium.utilities.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DeviceBaseTest extends ReusableMethods {
   protected AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {


        UiAutomator2Options options = new UiAutomator2Options()
                .setUnlockType("pin")//telefon kilidinde sifreyi otomatik acmak icin
                //.setUnlockType("pattern") eger patternli yapiyorsak bunu kullaniyoruz
                .setUnlockKey("5689")
                ;

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void afterClass() {
          driver.quit();
    }
}
