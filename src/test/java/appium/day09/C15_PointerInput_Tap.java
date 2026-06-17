package appium.day09;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import appium.basetest.ApiDemosBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C15_PointerInput_Tap extends ApiDemosBaseTest {
    @Test
    public void testTap() {
        // 1. "finger" adında, dokunmatik ekran (TOUCH) özelliğine sahip bir sanal parmak tanımlıyoruz.
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // 2. Bu parmağın sırayla yapacağı hareketleri (Sequence) tutacak bir liste oluşturuyoruz.
        // Sondaki '1', bu hareket zincirinin ilk adımı (index) olduğunu belirtir.
        Sequence sequence = new Sequence(finger, 1)

                // 3. Parmağı hiç beklemeden (0 milisaniye), ekranın belirtilen (X: 400, Y: 1392) koordinatlarına götürüyoruz.
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 400, 1392))

                // 4. Parmağı ekrana bastırıyoruz (Dokunma işlemi başlıyor).
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))

                // 5. Ekran algılayabilsin ve tıklama tam gerçekleşsin diye parmağı ekranda 300 milisaniye (0.3 saniye) basılı tutuyoruz.
                .addAction(new Pause(finger, Duration.ofMillis(300)))

                // 6. Parmağı ekrandan kaldırıyoruz (Dokunma işlemi bitiyor).
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // 7. Hazırladığımız bu hareket zincirini (sequence) sürücüye (driver) göndererek ekranda gerçekten uygulanmasını sağlıyoruz.
        driver.perform(Collections.singletonList(sequence));
    }
}
