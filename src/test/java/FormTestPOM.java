import Pages.P01_FormPage;
import org.testng.annotations.Test;

public class FormTestPOM extends TestBase{
    P01_FormPage p01FormPage ;
    @Test
    public void FillForm(){
        p01FormPage= new P01_FormPage(driver);
        p01FormPage.SetName("T1");
        p01FormPage.DDLSelection("Egypt");
        p01FormPage.ClickOnButton();
    }
}
