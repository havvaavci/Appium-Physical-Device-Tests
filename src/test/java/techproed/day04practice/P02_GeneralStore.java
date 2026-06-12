package techproed.day04practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStoreBaseTest;
import java.util.List;

public class P02_GeneralStore extends GeneralStoreBaseTest {
    /*
        Uygulama: GeneralStore
            GeneralStore uygulamasına gir
            Menüden Angola seçeneğini seç
            Your Name kutusuna Safinaz yaz
            Gender bölümünden Female seçeneğini seç
            Let's Shop butonuna tıkla
            Ürün listesindeki ilk iki ürünü sepete ekle
            Sepete gir
            Sepette iki ürün olduğunu doğrula
            Ürün fiyatlarını topla
            Total Purchase Amount bölümündeki tutarın doğru olduğunu doğrula
            Send me e-mails.. kutusunu seç
            Visit to the website.. butonuna tıkla
     */

    @Test
    public void testGeneralStore() throws InterruptedException {
       WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
       menu.click();
       WebElement angola =driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Angola\"]"));
       angola.click();

       WebElement nameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
       nameBox.sendKeys("Havva");

       WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
       female.click();

       WebElement button =driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
       button.click();

       WebElement firstElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)"));
       firstElement.click();
       WebElement secondElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(1)"));
        secondElement.click();
        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();

        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        Assert.assertEquals(products.size(),2);

        double total=0;
        for (int i = 0; i < products.size(); i++) {
           String priceText = products.get(i).getText();
           double price = Double.parseDouble(priceText.substring(1));
           total +=price;
        }
        double totalAmount = Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(total,totalAmount);

        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();

        Thread.sleep(3000);


    }
}
