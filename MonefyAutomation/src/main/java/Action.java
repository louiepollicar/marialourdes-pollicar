import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Action {

    public static AndroidDriver<AndroidElement> driver;


    public void inputAmount(double amount){
        String input = Double.toString(amount);
        int length = input.length();
        for (int count =0; count< length; count++) {
            char key = input.charAt(count);
            if(key=='.'){
                click("com.monefy.app.lite:id/buttonKeyboardDot");
            }
            else {
                click(driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard" + key)));
            }
        }
        System.out.println("Amount Added: " +amount);
    }

    public void inputOperator(Operation operator){
        System.out.println(operator);
        click(driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard" + operator.getValue())));
    }

    public static String readXml(String key) throws IOException {
        String value = null;
        try {
            File file = new File("config.xml");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();
            @SuppressWarnings("rawtypes")
            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                if (((String) enuKeys.nextElement()).contains(key)) {
                    value = properties.getProperty(key);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void click(String element) {
        driver.findElement(By.id(element)).click();
    }

    public void click(AndroidElement element){
        element.click();
        waitFor(5);
    }

    public void waitFor(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void waitForElementToBeVisible(AndroidElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible(AndroidElement element){
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.visibilityOf(element));
    }




}
