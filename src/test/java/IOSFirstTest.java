import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.HashMap;

public class IOSFirstTest extends DesiredCap {

    public static void main(String[] args) throws InterruptedException {
        //IOSDriver driver = DesiredCap.capabilities();
        IOSDriver<IOSElement> driver = capabilities();
//
//        driver.findElementByAccessibilityId("Alert Views").click();
//        driver.findElementByXPath("//*[@value='Text Entry']").click();
//        driver.findElementByClassName("XCUIElementTypeOther").click();
//        driver.findElementByClassName("XCUIElementTypeOther").sendKeys("hello");
//        driver.hideKeyboard();
//        driver.findElementByName("OK").click();
//        Thread.sleep(2000);
//        driver.navigate().back();
//        Thread.sleep(2000);


//        scoll down till search bar click on it and come back

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String elementID = driver.findElementByAccessibilityId("Search Bars").getId();
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("element", elementID);
//        scrollObject.put("toVisible", "not an empty string");
//        js.executeScript("mobile:scroll", scrollObject);
//        driver.findElementByAccessibilityId("Search Bars").click();
//        driver.navigate().back();

//      scroll down till stepper and increase default count to 2 and get count for assertion
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        String stepperElementID = driver.findElementByAccessibilityId("Steppers").getId();
        HashMap<String, String> scrollableObject = new HashMap<String, String>();
        scrollableObject.put("element", stepperElementID );
        scrollableObject.put("toVisible", "not an empty string");
        jsc.executeScript("mobile:scroll", scrollableObject);
        driver.findElementByAccessibilityId("Steppers").click();
        Thread.sleep(1000);
        driver.zoom
        for(int i=0;i<2;i++) {
            driver.findElementByName("Increment").click();
        }
        int count= Integer.parseInt(driver.findElement(By.className("XCUIElementTypeStaticText")).getText());
        Assert.assertEquals(count,2);

    }
}
