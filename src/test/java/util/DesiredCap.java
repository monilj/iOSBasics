package util;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DesiredCap {
    static String userAppPath = "/Users/monilj/Library/Developer/Xcode/DerivedData/UICatalog-bhjjxbaoppoobmaekyppkyeztfro/Build/Products/Debug-iphonesimulator/UICatalog.app";
    static String prefix = "appium:";
    static IOSDriver<IOSElement> driver;

    public static IOSDriver<IOSElement> capabilities() {
        System.out.println("hello");
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
        capabilities.setCapability(prefix + MobileCapabilityType.PLATFORM_VERSION,"11.2");
        capabilities.setCapability(prefix + MobileCapabilityType.DEVICE_NAME,"iphone 7");
        capabilities.setCapability(prefix + MobileCapabilityType.UDID,"CE110E78-6E4E-4041-9ABB-F2756326435E");
        capabilities.setCapability(prefix + MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("connectHardwareKeyboard", false);


        capabilities.setCapability(MobileCapabilityType.APP,userAppPath);
        try {
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
return driver;
    }
}
