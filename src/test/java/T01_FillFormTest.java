import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T01_FillFormTest extends TestBase{

    @Test
    public void FillForm(){
        System.out.println("App opening Successfully");
       driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test1");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Egypt\").instance(0))")).click();
        //driver.findElement(By.id("android:id/text1")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
      //  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\");"));
    /*    WebElement elementId=driver.findElement(By.xpath("//android.widget.TextView[@text='Egypt']"));
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
              "elementId",((RemoteWebElement) elementId).getId(),
                "direction", "down",
                "percent", 3.0
        ));*/
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
    @Test
    public void ValidateToastMessage(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Egypt\").instance(0))")).click();
        //driver.findElement(By.id("android:id/text1")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        //  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\");"));
    /*    WebElement elementId=driver.findElement(By.xpath("//android.widget.TextView[@text='Egypt']"));
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
              "elementId",((RemoteWebElement) elementId).getId(),
                "direction", "down",
                "percent", 3.0
        ));*/
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //Assert an toast message appear while leaving name field empty
        String text=  driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(text,"Please enter your name");
    }

    @Test
    public void AddSpecificElementToCart() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("First6");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Egypt\").instance(0))")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"PG 3\"))"));

        int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        String productName = null;
        for (int i = 0; i < size; i++) {
            productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("PG 3")) ;

            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
      driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).isDisplayed();
        Assert.assertEquals(productName, "Jordan 6 Rings");
        //Using subString(1) to remove the dollar sign
      int productPrice= Integer.parseInt(driver.findElement(By.id("com.androidsample.generalstore:id/productPrice")).getText().substring(1));
      int CartPrice= Integer.parseInt(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
      Assert.assertEquals(productPrice,CartPrice);
    }

    public static void main(String[] args) {
        String input = "$abc123xyz456";
        String onlyNumbers = input.replaceAll("\\D", "");
        System.out.println(onlyNumbers); // Output: 123456
    }

}
