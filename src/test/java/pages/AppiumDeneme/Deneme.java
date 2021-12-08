package pages.AppiumDeneme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Deneme {


    @Test
    public void test () throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //desiredCapabilities.setCapability("platformName","Android");

        //MobileCapabilityType -> CapabilityType OR "platformName" can be used.

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\90534\\OneDrive\\Masaüstü\\MulakatSorular\\mobileTesting\\src\\test\\java\\pages\\App\\Gesture Tool_v1.3_apkpure.com.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,"true");
        //By using this line, we skip the manuel continue part. Application do not set up every time.

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver <WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);

        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        //-> This is another way that you do not have to set the URL separately
        //-> Application won't be installed again.

        Thread.sleep(3000);

        //id
        driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton"));
        driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        //xpath
        driver.findElementByXPath("//*[@text='Add gesture']");
        //xpath index
        driver.findElementByXPath("(//android.widget.Button)[1]");
        //xpath attribute
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();
    }
}
