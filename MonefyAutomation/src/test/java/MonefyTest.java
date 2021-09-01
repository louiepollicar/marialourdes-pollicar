import org.testng.Assert;
import org.testng.annotations.Test;


import java.text.DecimalFormat;

public class MonefyTest extends BaseTest{

    private static DecimalFormat dFormat = new DecimalFormat("#.##");
    double income1 = 3500.75d;
    double income2 = 1257.82d;
    double income3 = 74268.41d;
    double incomesum = income1 + income2 + income3;
    double expense1 = 250.98;
    double expense2 = 1350.00;
    double expensesum = expense1 + expense2;
    double transfer = 1200.00;

    @Test (priority = 0)
        public void AddMultipleIncomeVerifyIncomeAndBalance(){

        HomePage homePage = new HomePage(driver);
        IncomeExpensePage incomeExpensePage = new IncomeExpensePage(driver);

        incomeExpensePage.addIncome(income1, Category.SALARY);
        incomeExpensePage.addIncome(income2, Category.DEPOSITS);
        incomeExpensePage.addIncome(income3, Category.SAVINGS);
        Assert.assertEquals(homePage.getIncome(),Double.parseDouble(dFormat.format(incomesum)),0.001);
        Assert.assertEquals(homePage.getBalance(),Double.parseDouble(dFormat.format(incomesum)),0.001);

    }
    @Test (priority = 1)
        public void AddMultipleExpenseVerifyIncomeAndBalance() {

        HomePage homePage = new HomePage(driver);
        IncomeExpensePage incomeExpensePage = new IncomeExpensePage(driver);

        incomeExpensePage.addExpense(expense1, Category.COMMUNICATIONS);
        click(homePage.btnSettings);
        incomeExpensePage.addExpense(expense2, Category.EATINGOUT);
        double balance = incomesum - expensesum;
        Assert.assertEquals(homePage.getExpense(),Double.parseDouble(dFormat.format(expensesum)), 0.001);
        Assert.assertEquals(homePage.getBalance(),Double.parseDouble(dFormat.format(balance)), 0.001);
      }

      @Test (priority = 2)
        public void VerifyBalanceDetails(){
        HomePage homePage = new HomePage(driver);
        homePage.viewBalanceDetails();
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.SALARY));
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.DEPOSITS));
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.SAVINGS));
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.COMMUNICATIONS));
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.EATINGOUT));
      }

      @Test (priority = 3)
        public void TransferAccounts(){
        HomePage homePage = new HomePage(driver);
        TransferPage transferPage = new TransferPage(driver);
        transferPage.createNewTransfer(transfer);
        homePage.switchAccount(AccountType.CASH);
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.CARD));
        homePage.switchAccount(AccountType.CARD);
        Assert.assertTrue(homePage.isCategoryDisplayed(Category.CASH));
      }

  }
