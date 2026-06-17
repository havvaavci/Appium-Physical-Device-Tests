package appium.basetest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import appium.utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class MapBaseTest extends ReusableMethods {
    protected AndroidDriver driver;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.google.android.apps.maps")
                .setAppActivity("com.google.android.maps.MapsActivity")
                ;

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
