package PracticeSection;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Scroll_AppiumGestures extends BaseTest {


   @Test
    public void Scroll() {
       androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
       boolean canScrollMore ;
       do {
           //noinspection DataFlowIssue
           canScrollMore=  (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                   "left", 100, "top", 100, "width", 200, "height", 200,
                   "direction", "down",
                   "percent", 3.0
           ));
       }while (canScrollMore);

   }


}
