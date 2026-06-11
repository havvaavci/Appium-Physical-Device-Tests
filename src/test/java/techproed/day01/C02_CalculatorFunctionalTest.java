package techproed.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_CalculatorFunctionalTest {

    @Test
    public void testCalculatorAddition() throws MalformedURLException {
        // Samsung Hesap Makinesi için UiAutomator2Options oluştur
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("988a1642334c524b5030");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity("com.sec.android.app.popupcalculator.Calculator");
        options.setCapability("uiautomator2ServerInstallTimeout", 60000);

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);

        // WebDriverWait oluştur (Explicit Wait) - 15 saniye esnek wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Samsung Hesap Makinesi açıldıktan sonra ilk buton (2) bekle ve görünür olmasını kontrol et
        WebElement button2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("2")));

        // 25 işlemini yap: 2 butonuna tıkla
        WebElement button2_for_25 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("2")));
        button2_for_25.click();

        // 5 butonuna tıkla
        WebElement button5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("5")));
        button5.click();

        // + butonuna tıkla
        WebElement buttonPlus = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("+")));
        buttonPlus.click();

        // 15 işlemini yap: 1 butonuna tıkla
        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("1")));
        button1.click();

        // 5 butonuna tıkla
        WebElement button5_for_15 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("5")));
        button5_for_15.click();

        // = butonuna tıkla
        WebElement buttonEqual = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("=")));
        buttonEqual.click();

        // Sonuç ekranındaki text değerini al
        // Sonuç alanı genellikle "0" accessibilityId'sine sahip veya xpath ile bulunabilir
        WebElement resultDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.TextView[contains(@resource-id, 'result')]")));
        String actualResult = resultDisplay.getText();

        // Sonucun "40" olduğunu doğrula
        Assert.assertEquals(actualResult, "40", "Hesap makinesi sonucu yanlış. Beklenen: 40, Elde edilen: " + actualResult);

        // Oturumu kapat
        driver.quit();
    }
}

