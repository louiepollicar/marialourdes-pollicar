import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class IncomeExpensePage extends Action {
    HomePage homePage = new HomePage(driver);

    public IncomeExpensePage(){
        //super();
    }

    public IncomeExpensePage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    public AndroidElement btnChooseCategory;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardDot")
    public AndroidElement keyDot;

    public void selectIncomeCategory(Category category){
        click(btnChooseCategory);
        click(driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.RelativeLayout//android.widget.GridView/android.widget.FrameLayout["+category.getValue()+"]")));
    }

    public void selectExpenseCategory(Category category){
        click(btnChooseCategory);
        click(driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.RelativeLayout//android.widget.GridView/android.widget.FrameLayout["+category.getValue()+"]/android.widget.LinearLayout")));
    }

    public void addExpense(double amount, Category category){
        waitForElementToBeVisible(homePage.txtBalance,10);
        try{
            click(homePage.btnExpense);
        } catch(Exception e){
            click(homePage.btnSettings);
            waitForElementToBeVisible(homePage.txtBalance,10);
            waitFor(20);
            click(homePage.btnExpense);
        }
        inputAmount(amount);
        selectExpenseCategory(category);
        waitForElementToBeVisible(homePage.txtBalance,10);
    }

    public void addIncome(double amount, Category category){
        waitForElementToBeVisible(homePage.txtBalance,10);
        click(homePage.btnIncome);
        inputAmount(amount);
        selectIncomeCategory(category);
        waitForElementToBeVisible(homePage.txtBalance,10);
    }
}
