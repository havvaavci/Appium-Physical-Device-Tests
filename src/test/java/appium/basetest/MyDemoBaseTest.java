package appium.basetest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import appium.utilities.ReusableMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyDemoBaseTest extends ReusableMethods {
   protected AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "mda-2.2.0-25.apk";
//C:\Users\havva\IdeaProjects\Appium_Project\src\test\resources\mda-2.2.0-25.apk
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)
                .setUdid("R9WT3072EFX")
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
