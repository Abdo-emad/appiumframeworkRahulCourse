package PracticeSection;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPackageNameAndActivityName extends BaseTest {

/* solving the issue of new session created
1-add adb path in path variables (ENV variables)
2-add android_Home in (ENV variables)
//  C:\Users\aabdelghafar\AppData\Local\Android\Sdk
*
* */

   @Test
    public void GetPackageNameAndActivityName()  {
       //Write this in cmd: using app package and activity let you navigate to specific activity (page) directly
       //write>> adb devices
       //write>> adb shell dumpsys window | find "mCurrentFocus"
       // will get this answer: mCurrentFocus=Window{c1965b1 u0 io.appium.android.apis/io.appium.android.apis.app.AlertDialogSamples}
       //PackageName = io.appium.android.apis
       //ActivityName = io.appium.android.apis.app.AlertDialogSamples
       Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.app.AlertDialogSamples");
       ((JavascriptExecutor) androidDriver).executeScript("mobile: startActivity",
               ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.app.AlertDialogSamples"));
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
