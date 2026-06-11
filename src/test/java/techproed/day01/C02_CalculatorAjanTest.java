package techproed.day01;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class C02_CalculatorAjanTest {

    private static final String DEVICE_UDID = "988a1642334c524b5030";
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/";
    private static final int SERVER_TIMEOUT_MS = 60000;
    private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(15);

    private static final String PRIMARY_PACKAGE = "com.sec.android.app.popupcalculator";
    private static final String PRIMARY_ACTIVITY = "com.sec.android.app.popupcalculator.Calculator";
    private static final String FALLBACK_PACKAGE = "com.samsung.android.calculator";
    private static final String FALLBACK_ACTIVITY = "com.samsung.android.calculator.Calculator";

    private static AndroidDriver driver;
    private static WebDriverWait wait;
    private static String activePackage;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        try {
            driver = createDriver(PRIMARY_PACKAGE, PRIMARY_ACTIVITY);
            wait = new WebDriverWait(driver, EXPLICIT_WAIT);
            activePackage = waitForCalculatorPackage();
        } catch (WebDriverException primaryFailure) {
            safelyQuitDriver();
            driver = createDriver(FALLBACK_PACKAGE, FALLBACK_ACTIVITY);
            wait = new WebDriverWait(driver, EXPLICIT_WAIT);
            activePackage = waitForCalculatorPackage();
        }
    }

    @AfterClass
    public static void tearDown() {
        safelyQuitDriver();
    }

    @Test
    public void testSamsungCalculatorOpen() {
        String currentPackage = driver.getCurrentPackage();
        Set<String> allowedPackages = Set.of(PRIMARY_PACKAGE, FALLBACK_PACKAGE);

        Assert.assertTrue(
                allowedPackages.contains(currentPackage),
                "Samsung Calculator did not open. Actual package: " + currentPackage
        );

        WebElement calculatorRoot = wait.until(
                ExpectedConditions.visibilityOfElementLocated(getDigitLocator(0))
        );

        Assert.assertTrue(calculatorRoot.isDisplayed(), "Calculator keypad should be visible on launch.");
        System.out.println("Samsung Calculator opened successfully. Active package: " + currentPackage);
    }

    @Test
    public void testFunctionalOperations() {
        waitForCalculatorVisible();

        tapDigit(5);
        tapAdd();
        tapDigit(3);
        tapEquals();

        String resultText = waitForResultContaining("8");

        Assert.assertTrue(
                normalizeNumericText(resultText).contains("8"),
                "Expected calculator result to contain 8 but was: " + resultText
        );

        System.out.println("Functional validation passed: 5 + 3 = 8 (display shows: " + resultText + ")");
    }

    private static AndroidDriver createDriver(String appPackage, String appActivity) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid(DEVICE_UDID);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setCapability("uiautomator2ServerInstallTimeout", SERVER_TIMEOUT_MS);

        URL serverUrl = new URL(APPIUM_SERVER_URL);
        return new AndroidDriver(serverUrl, options);
    }

    private static String waitForCalculatorPackage() {
        return wait.until(webDriver -> {
            AndroidDriver androidDriver = (AndroidDriver) webDriver;
            String currentPackage = androidDriver.getCurrentPackage();
            if (PRIMARY_PACKAGE.equals(currentPackage) || FALLBACK_PACKAGE.equals(currentPackage)) {
                return currentPackage;
            }
            return null;
        });
    }

    private static void waitForCalculatorVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDigitLocator(0)));
    }

    private static By getDigitLocator(int digit) {
        if (PRIMARY_PACKAGE.equals(activePackage)) {
            return AppiumBy.id(PRIMARY_PACKAGE + ":id/calc_keypad_btn_" + digit);
        }
        return AppiumBy.id(FALLBACK_PACKAGE + ":id/digit_" + digit);
    }

    private static By getAddLocator() {
        if (PRIMARY_PACKAGE.equals(activePackage)) {
            return AppiumBy.id(PRIMARY_PACKAGE + ":id/calc_keypad_btn_add");
        }
        return AppiumBy.id(FALLBACK_PACKAGE + ":id/op_add");
    }

    private static By getEqualsLocator() {
        if (PRIMARY_PACKAGE.equals(activePackage)) {
            return AppiumBy.id(PRIMARY_PACKAGE + ":id/calc_keypad_btn_equal");
        }
        return AppiumBy.id(FALLBACK_PACKAGE + ":id/eq");
    }

    private static By getPrimaryDisplayLocator() {
        if (PRIMARY_PACKAGE.equals(activePackage)) {
            return AppiumBy.id(PRIMARY_PACKAGE + ":id/calc_edt_formula");
        }
        return AppiumBy.id(FALLBACK_PACKAGE + ":id/result_preview");
    }

    private static By getSecondaryDisplayLocator() {
        if (PRIMARY_PACKAGE.equals(activePackage)) {
            return AppiumBy.id(PRIMARY_PACKAGE + ":id/calc_edt_input");
        }
        return AppiumBy.id(FALLBACK_PACKAGE + ":id/formula");
    }

    private static void tapDigit(int digit) {
        WebElement digitKey = wait.until(ExpectedConditions.elementToBeClickable(getDigitLocator(digit)));
        digitKey.click();
    }

    private static void tapAdd() {
        WebElement addKey = wait.until(ExpectedConditions.elementToBeClickable(getAddLocator()));
        addKey.click();
    }

    private static void tapEquals() {
        WebElement equalsKey = wait.until(ExpectedConditions.elementToBeClickable(getEqualsLocator()));
        equalsKey.click();
    }

    private static String waitForResultContaining(String expectedValue) {
        return wait.until(driver -> {
            String primaryText = readElementTextSafely(getPrimaryDisplayLocator());
            if (normalizeNumericText(primaryText).contains(expectedValue)) {
                return primaryText;
            }

            String secondaryText = readElementTextSafely(getSecondaryDisplayLocator());
            if (normalizeNumericText(secondaryText).contains(expectedValue)) {
                return secondaryText;
            }

            return null;
        });
    }

    private static String readElementTextSafely(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            String text = element.getText();
            return text == null ? "" : text;
        } catch (WebDriverException exception) {
            return "";
        }
    }

    private static String normalizeNumericText(String rawText) {
        return rawText.replaceAll("[^0-9.,-]", "");
    }

    private static void safelyQuitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
