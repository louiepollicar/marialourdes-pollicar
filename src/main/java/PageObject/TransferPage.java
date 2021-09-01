import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage extends Action{

    WebDriverWait wait = new WebDriverWait(driver,25);
    HomePage homePage = new HomePage(driver);

    public TransferPage(){
    }

    public TransferPage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy (id = "com.monefy.app.lite:id/keyboard_action_button")
    public AndroidElement btnAddTransfer;


    @AndroidFindBy (id = "com.monefy.app.lite:id/amount_text")
    public AndroidElement txtTransferTextAmount;

    @AndroidFindBy (xpath = "//android.view.ViewGroup/android.widget.TextView")
    public AndroidElement txtNewTransfer;

    public void createNewTransfer(Double amount){
        click(homePage.btnTransfer);
        click(txtTransferTextAmount);
        inputAmount(amount);
        click(btnAddTransfer);
    }
}