import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class BaseTest extends Action{

   // protected HomePageActions homePage;


    public static AndroidDriver<AndroidElement> getCapabilities() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", readXml("platformName"));
        capabilities.setCapability("platformVersion", readXml("platformVersion"));
        capabilities.setCapability("deviceName", readXml("deviceName"));
        capabilities.setCapability("appPackage", readXml("appPackage"));
        capabilities.setCapability("appActivity", readXml("appActivity"));
        capabilities.setCapability("app", readXml("app"));
        driver = new AndroidDriver<>(new URL(readXml("URL")), capabilities);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), capabilities);
        return driver;
    }

    @BeforeClass
    public static void setup() throws Exception{
        getCapabilities();

    }



}
