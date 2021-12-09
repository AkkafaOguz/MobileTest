package pages.Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Class01 {


    @Test
    public void test () throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //https://appium.io/docs/en/writing-running-appium/caps/ -> You can check the link about desired capabilities

        //We can type setCapability() method in different ways:

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //desiredCapabilities.setCapability("platformName","Android");

        //MobileCapabilityType -> CapabilityType OR "platformName" can be used.

        //MobileCapabilityType (interface) is the child of CapabilityType (interface).

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\90534\\OneDrive\\Masaüstü\\MulakatSorular\\mobileTesting\\src\\test\\java\\pages\\App\\Gesture Tool_v1.3_apkpure.com.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,"true");
        //By using this line, we skip the manuel continue part. Application do not set up every time.
        //-> Application won't be installed again.

        //We send these desired capabilities' information to the device through Appium Server
        //In order to do that, we should set the URL and create a driver:

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //"http://localhost:4723/wd/hub" -> can be used as well.

        AndroidDriver <MobileElement> driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
//      AndroidDriver <AndroidElement> driver = new AndroidDriver<AndroidElement>(url, desiredCapabilities);
//      AndroidDriver <WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);

        //AndroidElement class is the child of MobileElement class.
        //MobileElement class is the child of DefaultGenericMobileElement class.
        //DefaultGenericMobileElement class is the child of WebElement interface.
        //AndroidElement (class) -> MobileElement (class) -> DefaultGenericMobileElement (class) -> WebElement (interface)


        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        //-> This is another way that you do not have to set the URL separately


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


//        Desired Capabilities are keys and values encoded in a JSON object, sent by Appium clients to the server when a new automation session is requested.
//        They tell the Appium drivers all kinds of important things about how you want your test to work.
//        Each Appium client builds capabilities in a way specific to the client's language, but at the end of the day, they are sent over to Appium as JSON objects.

//        Some important capabilities are demonstrated in the following example:

//        {
//            "platformName": "iOS",
//            "platformVersion": "11.0",
//            "deviceName": "iPhone 7",
//            "automationName": "XCUITest",
//            "app": "/path/to/my.app"
//        }




    }
}
