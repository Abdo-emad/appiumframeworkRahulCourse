package Utils;

import com.sun.org.apache.xpath.internal.operations.And;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Actions {
    AndroidDriver driver;
    public Actions(AndroidDriver driver){
        this.driver=driver;
    }
    public void ScrollToElement(String element){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains('"+element+"').instance(0))")).click();

    }
}
