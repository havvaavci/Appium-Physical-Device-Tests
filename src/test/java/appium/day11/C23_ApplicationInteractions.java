package appium.day11;

import appium.basetest.ApiDemosBaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class C23_ApplicationInteractions extends ApiDemosBaseTest {
    @Test
    public void testTerminateApp() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        duration(2);
       driver.terminateApp("io.appium.android.apis");
       duration(2);
    }

    @Test
    public void testActivateUp() {
        //iki app arasinda islemler icin
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        duration(2);
        driver.activateApp("com.sec.android.app.popupcalculator");
        duration(3);
        driver.activateApp("io.appium.android.apis");

    }

    @Test
    public void testRunAppInBackground() {
        //arka planda tekrar app i calistirma
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        duration(2);
        driver.runAppInBackground(Duration.ofSeconds(5));
        duration(2);

    }

    @Test
    public void testInstallApp() {
        //uygulama yukleme
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "mda-2.2.0-25.apk";
        driver.installApp(appUrl);
        duration(5);
    }

    @Test
    public void testIsAppInstall() {
        //uygulamanin yuklu olup olmadigi bilgisini boolean doner
        System.out.println( driver.isAppInstalled("com.saucelabs.mydemoapp.android"));
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "mda-2.2.0-25.apk";
        driver.installApp(appUrl);
        duration(5);
        System.out.println( driver.isAppInstalled("com.saucelabs.mydemoapp.android"));


    }

    @Test
    public void testQueryAppState() {
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        duration(3);
        driver.terminateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        duration(3);
        driver.activateApp("io.appium.android.apis");
        driver.activateApp("com.sec.android.app.popupcalculator");
        System.out.println(driver.queryAppState("io.appium.android.apis"));


    }
}
