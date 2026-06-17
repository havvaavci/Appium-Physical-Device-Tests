package appium.day05;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import appium.basetest.MyDemoBaseTest;

public class P04_MyDemoApp_ColorTest extends MyDemoBaseTest {
    /*
    MyDemoApp uygulamasına gir
    Menüyü aç
    Login ol (bob@example.com, 10203040)
    Login butonuna tıkla
    İlk ürünü seç
    Renk olarak mavi seç
    Add To Cart butonuna tıkla
    Renk olarak kırmızı seç
    Add To Cart butonuna tıkla
    Sepete git
    Listede iki ürün olduğunu doğrula
    Listedeki ürünlerin mavi ve kırmızı olduğunu doğrula
     */

    @Test
    public void testColor() throws InterruptedException {
    WebElement menu =driver.findElement(AppiumBy.accessibilityId("View menu"));
    menu.click();
    WebElement login = driver.findElement(AppiumBy.accessibilityId("Login Menu Item"));
    login.click();
    WebElement nameBox = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET"));
    driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/username1TV")).click();
    //driver.hideKeyboard();//input girdikten sonra klavye hala aciksa ve login ebasamiyorsak klavyeyi kapatmak icin
    WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Tap to login with given credentials"));
    loginButton.click();
    WebElement firstProduct = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)"));
    firstProduct.click();
    //WebElement blue = driver.findElement(AppiumBy.accessibilityId("Blue color"));
    By blue =AppiumBy.accessibilityId("Blue color");
    driver.findElement(blue).click();
    //WebElement addToCart= driver.findElement(AppiumBy.accessibilityId("Tap to add product to cart"));
    By addToCart = AppiumBy.accessibilityId("Tap to add product to cart");
    driver.findElement(addToCart).click();
    Thread.sleep(2000);
    //WebElement greenColor = driver.findElement(AppiumBy.accessibilityId("Green color"));
    By green = AppiumBy.accessibilityId("Green color");
    driver.findElement(blue).click();
    Thread.sleep(2000);
    driver.findElement(addToCart).click();
    Thread.sleep(2000);
    WebElement carteBadge = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV"));
    carteBadge.click();

        // Alt kısımdaki "2 Items" yazan elementi bul
        WebElement totalItemsText = driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/itemsTV"));

        String actualText = totalItemsText.getText(); // "2 Items" sonucunu döner

// Doğrulama: Metnin "2 Items" içerdiğini kontrol et
        Assert.assertEquals(actualText, "2 Items", "Sepetteki toplam ürün yazısı hatalı!");
// Veya sadece sayıya odaklanmak istersen:
        Assert.assertTrue(actualText.contains("2"));


    }
}
