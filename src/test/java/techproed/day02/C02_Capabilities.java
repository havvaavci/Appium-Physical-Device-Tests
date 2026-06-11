package techproed.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_Capabilities {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos.apk";
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl)//calistiracagimiz uygulamanin yolu
   //             .setUdid("R9WT3072EFX")// hangi cihazda testi calistiracaksak onun udid'sini yaziyoruz. Birden fazla cihaz varsa bu zorunlu olur
                //.setAppPackage("io.appium.android.apis")//calistiracagimiz uygulamanin appPackage bilgisi
      //          .setAppActivity("io.appium.android.apis.ApiDemos")//claistiracagimiz uygulamanin appActivity bilgisi
                .setAvd("Pixel_7_Pro")//kapali emulatoru acmak icin kullanilir. Emulator acik ise bu satiri yazmaya gerek yoktur
                //bende launch time koymadan da test gecti ama gecmezse launch time ekleyebilirsin
                //.setAvdLaunchTimeout(Duration.ofSeconds(60))
                ;

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);
        driver.quit();
    }
}
