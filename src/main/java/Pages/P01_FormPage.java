package Pages;

import Utils.Actions;
import com.sun.org.apache.xpath.internal.operations.And;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P01_FormPage extends Actions {
    public AndroidDriver driver;
    public P01_FormPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
    }
    private By nameField = By.id("com.androidsample.generalstore:id/nameField");
    private By btnLetsShop = By.id("com.androidsample.generalstore:id/btnLetsShop");


    public void SetName(String name){
        driver.findElement(nameField).sendKeys(name);
        driver.hideKeyboard();
    }
    public void DDLSelection(String country){
        ScrollToElement(country);
    }
    public void ClickOnButton(){
        driver.findElement(btnLetsShop).click();
    }

}
