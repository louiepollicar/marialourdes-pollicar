
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends Action{

    WebDriverWait wait = new WebDriverWait(driver,25);

    //private AndroidDriver<AndroidElement> driver;

    public HomePage(){
        //super();
    }

    public HomePage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button_title")
    public AndroidElement btnIncome;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button_title")
    public AndroidElement btnExpense;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation\"]")
    public AndroidElement btnOpenNavigation;

    @AndroidFindBy(id = "com.monefy.app.lite:id/menu_search")
    public AndroidElement btnSearch;

    @AndroidFindBy(id = "com.monefy.app.lite:id/transfer_menu_item")
    public AndroidElement btnTransfer;

    @AndroidFindBy(id = "com.monefy.app.lite:id/overflow")
    public AndroidElement btnSettings;

    @AndroidFindBy(id = "com.monefy.app.lite:id/leftLinesImageView")
    public AndroidElement imgBalanceLeftLine;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_amount_text")
    public AndroidElement txtIncome;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_amount_text")
    public AndroidElement txtExpense;

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount")
    public AndroidElement txtBalance;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close navigation\"]")
    public AndroidElement btnBack;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textViewCategoryName\"]")
    public AndroidElement txtCategories;

    @AndroidFindBy(id = "com.monefy.app.lite:id/account_spinner")
    public AndroidElement btnAccountSpinner;

    @AndroidFindBy(xpath = "/android.widget.ListView/android.widget.LinearLayout[3]")
    public AndroidElement btnPaymentCard;

    @AndroidFindBy(xpath = "/android.widget.ListView/android.widget.LinearLayout[2]")
    public AndroidElement btnCash;

    @AndroidFindBy(xpath = "/android.widget.ListView/android.widget.LinearLayout[1]")
    public AndroidElement btnAllAccounts;

    public double getIncome(){
        wait.until(ExpectedConditions.visibilityOf(txtIncome));
        String incomeText = txtIncome.getText().replaceAll("[^0-9 .]","");
        double incomeBalance = Double.parseDouble(incomeText);
        return incomeBalance;
    }

    public double getExpense(){
        String expenseText = txtExpense.getText().replaceAll("[^0-9 .]","");
        double expenseBalance = Double.parseDouble(expenseText);
        return expenseBalance;
    }

    public double getBalance(){
        String balanceText = txtBalance.getText().replaceAll("[^0-9 .]","");
        double balance = Double.parseDouble(balanceText);
        return balance;
    }

    public void viewBalanceDetails(){
        click(imgBalanceLeftLine);
        waitFor(5);
    }

    public String[] getCategories(){
        List<AndroidElement> allCategories = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textViewCategoryName\"]"));
        int size = allCategories.size();
        String[] txtCategories = new String[size];
        for (int count = 0; count < size; count++){
            txtCategories[count]=allCategories.get(count).getText();
        }
        return txtCategories;
    }

    public boolean isCategoryDisplayed(Category category){
        int size = getCategories().length;
        String[] categories = getCategories();
        boolean isCategoryDisplayed = false;
        for(int count = 0; count < size; count++){
            System.out.print("count "+categories[count]);
            System.out.print(category.getText());
            if (categories[count].contains(category.getText())) {
                isCategoryDisplayed = true;
                break;
            }
            else {
                isCategoryDisplayed = false;
            }
        }
        return isCategoryDisplayed;
    }

    public void switchAccount(AccountType accountType){
        click(btnOpenNavigation);
        click(btnAccountSpinner);
        click(driver.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout["+accountType.getValue()+"]")));
    }



}
