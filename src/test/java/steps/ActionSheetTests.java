package steps;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.DesiredCap;

import java.util.List;

public class ActionSheetTests extends DesiredCap {

    static IOSDriver<IOSElement> driver;

    @BeforeTest
    public void driverInstance() {
        driver = DesiredCap.capabilities();
    }

    @Test
    public void verifyOpenUICatalogApp() {
//        List<IOSElement> appTitle = driver.findElements(By.name("UICatalog"));
//        int titleCount = appTitle.size();
        String homePageText= driver.findElement(By.xpath("//XCUIElementTypeOther[@name='UICatalog']")).getText();
        Assert.assertTrue(homePageText.equals("UICatalog"));

    }

    @Test
    public void testActionSheet() {
        driver.findElementByAccessibilityId("Action Sheets").click();
        driver.findElement(By.name("Okay / Cancel")).click();
        driver.findElementByAccessibilityId("OK");
        driver.findElement(By.id("UICatalog")).click();
        verifyOpenUICatalogApp();

    }

    @Test
    public void testActivityIndicator() {
        driver.findElementByAccessibilityId("Activity Indicators").click();
        driver.findElement(By.id("UICatalog")).click();
        verifyOpenUICatalogApp();
    }

    @Test
    public void testAlertViews() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Simple");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("UICatalog")).click();
        verifyOpenUICatalogApp();
    }

    @Test
    public void testButtons() {
        driver.findElementByAccessibilityId("Buttons").click();
        driver.findElementByName("Button").click();
        driver.findElement(By.id("UICatalog")).click();
        verifyOpenUICatalogApp();
    }

    @Test
    public void testDatePicker() {
        String day="Sat";
        String month="Apr";
        String date="4";
        String hours= "8";
        String minutes="14";
        String meridiem= "AM";
        driver.findElementByAccessibilityId("Date Picker").click();
        List<IOSElement> datePicker = driver.findElements(By.xpath("//*[@type='XCUIElementTypePickerWheel']"));
        datePicker.get(0).sendKeys(day+" "+month+" "+date);
        datePicker.get(1).sendKeys(hours);
        datePicker.get(2).sendKeys(minutes);
        datePicker.get(3).sendKeys(meridiem);
        String expectedTime= month+" "+date+" "+"2020 at"+" "+ hours+":"+minutes+" "+meridiem;
        String dateAndTime= driver.findElement(By.className("XCUIElementTypeStaticText")).getText();
        Assert.assertTrue(expectedTime.equals(dateAndTime));
        driver.findElement(By.id("UICatalog")).click();
        verifyOpenUICatalogApp();

    }

    @Test
    public void testImageView() {
        driver.findElementByAccessibilityId("Image View").click();
    }

    @Test
    public void testPageControl() {
        driver.findElementByAccessibilityId("Page Control").click();
    }

    @Test
    public void testPickerView() {
        driver.findElementByAccessibilityId("Picker View").click();
    }

    @Test
    public void testProgressView() {
        driver.findElementByAccessibilityId("Progress Views").click();
    }

    @Test
    public void TestSegmentedControls() {
        driver.findElementByAccessibilityId("Segmented Controls").click();
    }

    @Test
    public void testSlider() {
        driver.findElementByAccessibilityId("Sliders").click();
    }

    @Test
    public void testSteppers() {
        driver.findElementByAccessibilityId("Steppers").click();
    }

    @Test
    public void testSwitches() {
        driver.findElementByAccessibilityId("Switches").click();
    }

    @Test
    public void testTextField() {
        driver.findElementByAccessibilityId("").click();
    }

    @Test
    public void testWebView() {
        driver.findElementByAccessibilityId("").click();
    }

    @Test
    public void testSearchBars() {
        driver.findElementByAccessibilityId("").click();
    }

    @Test
    public void testToolBars() {
        driver.findElementByAccessibilityId("").click();
    }
}
