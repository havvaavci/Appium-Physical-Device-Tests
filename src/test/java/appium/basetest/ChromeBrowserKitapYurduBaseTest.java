package appium.basetest;

import appium.utilities.ReusableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChromeBrowserKitapYurduBaseTest extends ReusableMethods {
protected AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .withBrowserName("chrome");

        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setDeviceName("sdk_gphone64_x86_64");
        options.setUdid("emulator-5554");
        options.setCapability("appium:adbExecTimeout", 60000);
        options.setNoReset(true);
        options.setFullReset(false);

        Map<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("args", List.of(
                "--disable-blink-features=AutomationControlled",
                "--user-agent=Mozilla/5.0 (Linux; Android 13; sdk_gphone64_x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36"
        ));
        chromeOptions.put("excludeSwitches", List.of("enable-automation"));
        options.setCapability("goog:chromeOptions", chromeOptions);

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Önce domain'e git (cookie inject için gerekli)
        driver.get("https://www.kitapyurdu.com");

        // 2. cf_clearance cookie'sini inject et
        org.openqa.selenium.Cookie cfCookie = new org.openqa.selenium.Cookie.Builder(
                "cf_clearance", "verification"
        )
                .domain(".kitapyurdu.com")
                .path("/")
                .isSecure(true)
                .build();

        driver.manage().addCookie(cfCookie);

        // 3. navigator.webdriver gizle
        ((JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
        );

        // 4. Sayfayı cookie ile yenile
        driver.navigate().refresh();
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
