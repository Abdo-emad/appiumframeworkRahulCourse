package PracticeSection;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScenario extends BaseTest {

/* solving the issue of new session created
1-add adb path in path variables (ENV variables)
2-add android_Home in (ENV variables)
//  C:\Users\aabdelghafar\AppData\Local\Android\Sdk
*
* */

   @Test
    public void WifiSettingName()  {
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        androidDriver.findElement(By.id("android:id/checkbox")).click();
        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String text= androidDriver.findElement(By.id("android:id/alertTitle")).getText();
       Assert.assertEquals(text,"WiFi settings");
        androidDriver.findElement(By.id("android:id/edit")).sendKeys("Abdelrahman WIFI");
        androidDriver.findElement(By.id("android:id/button1")).click();
   }


}
