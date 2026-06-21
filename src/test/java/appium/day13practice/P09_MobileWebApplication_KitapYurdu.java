package appium.day13practice;

import appium.basetest.ChromeBrowserKitapYurduBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class P09_MobileWebApplication_KitapYurdu extends ChromeBrowserKitapYurduBaseTest {
    @Test
    public void testRegister() {
        //URL
        driver.get("https://www.kitapyurdu.com/");
        driver.findElement(By.xpath("//a[@href=\"index.php?route=account/account\"]")).click();
        driver.findElement(By.partialLinkText("Ücretsiz Üye Ol")).click();
        //name
        driver.findElement(By.id("firstname")).sendKeys("Eva");
        //last name
        driver.findElement(By.id("lastname")).sendKeys("Eva");
        //eposta
        driver.findElement(By.id("email")).sendKeys("tester@outlook.com");
        //sifre
        driver.findElement(By.id("password")).sendKeys("12345678");
        //sifre dogrulama
        driver.findElement(By.id("confirm")).sendKeys("12345678");
        //control
        driver.findElement(By.id("form-check-input")).click();
        //uye ol butonu
        driver.findElement(By.id("register-button")).click();

        //assert
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Hesabınız Olusturuldu!'")).getText(),"Hesabınız Olusturuldu!");
        duration(3);

    }
}
