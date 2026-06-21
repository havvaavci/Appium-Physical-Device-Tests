package appium.day11;

import appium.basetest.DeviceBaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class C24_LockDevice extends DeviceBaseTest {
    @Test
    public void testLockDevice() {
        driver.lockDevice(Duration.ofSeconds(5));
        duration(3);
    }
    @Test
    public void testUnLockDevice() {
        driver.lockDevice();
        duration(3);
        driver.unlockDevice();
        duration(3);
    }

    @Test
    public void testIsDeviceLocked() {
        System.out.println(driver.isDeviceLocked());
        driver.lockDevice();
        duration(3);
        System.out.println(driver.isDeviceLocked());
        driver.unlockDevice();
        duration(2);
        System.out.println(driver.isDeviceLocked());
    }

}
