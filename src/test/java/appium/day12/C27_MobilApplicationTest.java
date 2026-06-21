package appium.day12;

import appium.basetest.ChromeBrowserBaseTest;
import org.testng.annotations.Test;

public class C27_MobilApplicationTest extends ChromeBrowserBaseTest {
    @Test
    public void testBrowser() {
        //withBrowserName("chrome") methodu ile normal webde calisir gibi testler yapabiliyoruz
        driver.get("https://www.google.com");
        duration(3);
    }
}
