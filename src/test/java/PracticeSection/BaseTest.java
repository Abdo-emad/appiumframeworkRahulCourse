package PracticeSection;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AndroidDriver androidDriver;
    @BeforeMethod
    public void SetUp() throws MalformedURLException {
        String appPath = System.getProperty("user.dir")+"/src/main/resources/ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Medium Phone API 35");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setApp(appPath);
        androidDriver =new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
    }
    public void longPress(WebElement element){
        ((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ),"duration",2000);
    }

    @AfterMethod
    public void Quit(){
        //androidDriver.quit();
    }
}
