package PracticeSection;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Swipe_AppiumGestures extends BaseTest {


   @Test
    public void Swipe() {
       androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
       androidDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
       androidDriver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
       ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
               "left", 100, "top", 100, "width", 200, "height", 200,
               "direction", "left",
               "percent", 0.75
       ));

   }


}
