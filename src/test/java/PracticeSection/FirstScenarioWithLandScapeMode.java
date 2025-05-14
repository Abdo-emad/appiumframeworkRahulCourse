package PracticeSection;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScenarioWithLandScapeMode extends BaseTest {

/* solving the issue of new session created
1-add adb path in path variables (ENV variables)
2-add android_Home in (ENV variables)
//  C:\Users\aabdelghafar\AppData\Local\Android\Sdk
*
* */

   @Test
    public void WifiSettingNameByLandScapeMode()  {
       DeviceRotation landScape = new DeviceRotation(0,0,90);
       androidDriver.rotate(landScape);
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        androidDriver.findElement(By.id("android:id/checkbox")).click();
        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String text= androidDriver.findElement(By.id("android:id/alertTitle")).getText();
       Assert.assertEquals(text,"WiFi settings");
        androidDriver.findElement(By.id("android:id/edit")).sendKeys("Abdelrahman WIFI");
        androidDriver.findElement(By.id("android:id/button1")).click();

        //Key Events
       androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
       androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
   }


}
