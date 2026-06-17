package appium.day05;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import appium.basetest.GeneralStoreBaseTest;

public class P03_GeneralStore_Negative extends GeneralStoreBaseTest {
    @Test
    public void testGeneralStoreNegative() {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}
