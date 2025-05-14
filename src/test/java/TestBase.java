import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    AndroidDriver driver;
    @BeforeMethod
    public void SetUp() throws MalformedURLException {
        String apkPath = System.getProperty("user.dir")+"/src/main/resources/General-Store.apk";
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Medium Phone API 35");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setApp(apkPath);
      driver= new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void TearDown(){

    }
}
