package techproed.day03;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.CalculatorBaseTest;

public class C04_CalculatorTest extends CalculatorBaseTest {

    // ==========================================
    // 1. LOCATORS (ELEMENT TANIMLAMALARI)
    // ==========================================
    private static final By DIGIT_0 = AppiumBy.accessibilityId("0");
    private static final By DIGIT_1 = AppiumBy.accessibilityId("1");
    private static final By DIGIT_2 = AppiumBy.accessibilityId("2");
    private static final By DIGIT_3 = AppiumBy.accessibilityId("3");
    private static final By DIGIT_4 = AppiumBy.accessibilityId("4");
    private static final By DIGIT_5 = AppiumBy.accessibilityId("5");
    private static final By DIGIT_6 = AppiumBy.accessibilityId("6");
    private static final By DIGIT_7 = AppiumBy.accessibilityId("7");
    private static final By DIGIT_8 = AppiumBy.accessibilityId("8");
    private static final By DIGIT_9 = AppiumBy.accessibilityId("9");

    private static final By PLUS_BUTTON = AppiumBy.accessibilityId("Plus");
    private static final By MINUS_BUTTON = AppiumBy.accessibilityId("Moins");
    private static final By MULTIPLY_BUTTON = AppiumBy.accessibilityId("Multiplier");
    private static final By DIVIDE_BUTTON = AppiumBy.accessibilityId("Diviser");
    private static final By EGAL_BUTTON = AppiumBy.accessibilityId("Égal");
    private static final By EFFACE_BUTTON = AppiumBy.accessibilityId("Effacer");
    private static final By PARENTHESES_BUTTON = AppiumBy.accessibilityId("Parenthèses");

    private static final By RESULT_FIELD = By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula");

    // ==========================================
    // 2. YARDIMCI METOTLAR
    // ==========================================
    private String samsungHesapMakinesiSonucAyıkla(String rawText) {
        if (rawText == null || rawText.trim().isEmpty()) return "";
        String[] kelimeler = rawText.trim().split("\\s+");
        if (kelimeler[0].equalsIgnoreCase("Moins")) {
            return "-" + kelimeler[1];
        }
        return kelimeler[0].replaceAll("[^0-9]", "");
    }

    // ==========================================
    // 3. TEST METOTLARI
    // ==========================================
    @Test
    public void testAddition() throws InterruptedException {
        driver.findElement(EFFACE_BUTTON).click(); // Güvenlik temizliği

        // 1- Pozitif senaryo: 7 + 3 = 10
        driver.findElement(DIGIT_7).click();
        driver.findElement(PLUS_BUTTON).click();
        driver.findElement(DIGIT_3).click();
        driver.findElement(EGAL_BUTTON).click();

        String raw = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(raw), "10");

        // 2- Negatif senaryo: 4 + (-2) = 2
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(DIGIT_4).click();
        driver.findElement(PLUS_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_2).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();
        Thread.sleep(2000);

        String rawNegative = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNegative), "2");

        // 3- İki negatif sayıyı toplama: (-5) + (-3) = -8
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_5).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(PLUS_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_3).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();
        Thread.sleep(2000);

        String rawNegNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNegNeg), "-8");
    }

    @Test
    public void testDistraction() {
        driver.findElement(EFFACE_BUTTON).click(); // Güvenlik temizliği

        // 1- Pozitif senaryo: 9 - 4 = 5
        driver.findElement(DIGIT_9).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_4).click();
        driver.findElement(EGAL_BUTTON).click();

        String raw = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(raw), "5");

        // 2- Negatif senaryo: 5 - 8 = -3
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(DIGIT_5).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_8).click();
        driver.findElement(EGAL_BUTTON).click();

        String rawNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNeg), "-3");

        // 3- İki negatif sayıyı çıkartma: (-9) - (-4) = -5
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_9).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_4).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();

        String rawNegNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNegNeg), "-5");
    }

    @Test
    public void testMultiplication() {
        // Çözüm 1: Metodun en başına temizleme komutu eklendi ve her testin başında temizleme yapıldı
        driver.findElement(EFFACE_BUTTON).click();

        // 1- Pozitif x Pozitif: 6 x 8 = 48
        driver.findElement(DIGIT_6).click();
        driver.findElement(MULTIPLY_BUTTON).click();
        driver.findElement(DIGIT_8).click();
        driver.findElement(EGAL_BUTTON).click();

        String raw = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(raw), "48");

        // 2- Pozitif x Negatif: 6 x (-2) = -12
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(DIGIT_6).click();
        driver.findElement(MULTIPLY_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_2).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();

        String rawPosNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawPosNeg), "-12");

        // 3- Negatif x Negatif: (-3) x (-4) = 12
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_3).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MULTIPLY_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_4).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();

        String rawNegNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNegNeg), "12");
    }

    @Test
    public void testDivision() {
        driver.findElement(EFFACE_BUTTON).click();

        // 1- Pozitif bölme: 8 / 4 = 2
        driver.findElement(DIGIT_8).click();
        driver.findElement(DIVIDE_BUTTON).click();
        driver.findElement(DIGIT_4).click();
        driver.findElement(EGAL_BUTTON).click();

        String raw = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(raw), "2");

        // 2- Pozitif / Negatif: 9 / (-3) = -3
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(DIGIT_9).click();
        driver.findElement(DIVIDE_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_3).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();

        String rawNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNeg), "-3");

        // 3- Negatif / Negatif: (-12) / (-4) = 3
        driver.findElement(EFFACE_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_1).click();
        driver.findElement(DIGIT_2).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(DIVIDE_BUTTON).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(MINUS_BUTTON).click();
        driver.findElement(DIGIT_4).click();
        driver.findElement(PARENTHESES_BUTTON).click();
        driver.findElement(EGAL_BUTTON).click();

        String rawNegNeg = driver.findElement(RESULT_FIELD).getText();
        Assert.assertEquals(samsungHesapMakinesiSonucAyıkla(rawNegNeg), "3");


    }
}