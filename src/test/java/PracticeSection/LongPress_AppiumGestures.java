package PracticeSection;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LongPress_AppiumGestures extends BaseTest {


   @Test
    public void longPressOnElement()  {
androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
       WebElement element = androidDriver.findElement(By.xpath("(//android.widget.TextView)[0]"));
       longPress(element);
   }


}
