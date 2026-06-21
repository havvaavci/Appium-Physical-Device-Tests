package appium.day13practice;

import appium.basetest.GeneralStoreBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class P08_HibritApplication_GeneralStore extends GeneralStoreBaseTest {
    @Test
    public void testHybridApplication() throws InterruptedException {
            //Menu
            WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
            menu.click();

        //ulke secimi
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"))"));

            WebElement france =driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"France\"]"));
            france.click();
            //isim
            WebElement nameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
            nameBox.sendKeys("Havva");
            //cinsiyet
            WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
            female.click();
            //button
            WebElement button =driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
            button.click();

        //urun secimi
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(1)")).click();
        duration(3);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))"));
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\").instance(0)")).click();
        duration(3);
        //sepete gitme
            WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
            cart.click();
            duration(3);

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
            //checkbox
            WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
            checkBox.click();
            //visit
            WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
            visitButton.click();

            duration(3);

        driver.context("WEBVIEW_com.androidsample.generalstore");
        duration(3);
        try {
            // Paket isimleri olmadan, doğrudan By.id kullanıyoruz
            WebElement refuseButton = driver.findElement(By.id("W0wltc"));

            // JavascriptExecutor cast işlemini de kısalttık
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", refuseButton);
            Thread.sleep(1000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refuseButton);
            System.out.println("Çerezler başarıyla reddedildi.");

        } catch (Exception e) {
            System.out.println("Çerez butonuna tıklanamadı: " + e.getMessage());
        }

// 2. Google Arama Kutusu
        duration(2);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Temel Reis");
        searchBox.sendKeys(Keys.ENTER); // Paket ismi olmadan doğrudan Keys.ENTER

        //native app e gecis
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        String title = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(title,"General Store");
        duration(5);


    }
    }

