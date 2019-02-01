import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SapTest {

    private static WindowsDriver sapSession = null;
    private static WebElement calculatorResult = null;

    @BeforeClass
    public static void setup() throws MalformedURLException {

        // Launch Crystal Reports
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("app", "C:\\Program Files (x86)\\SAP BusinessObjects\\SAP BusinessObjects Enterprise XI 4.0\\win32_x86\\crw32.exe");
        sapSession = new WindowsDriver(new URL("http://192.168.1.223:4723"), appCapabilities);
        sapSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }


    @Test
    public void crystalReports() throws InterruptedException {

        Thread.sleep(3000);
        sapSession.findElementByName("OK").click();
        Thread.sleep(1000);
        sapSession.findElementByName("File").click();
        Thread.sleep(1000);
        sapSession.findElementByName("New").click();
        Thread.sleep(1000);
        sapSession.findElementByName("Blank report").click();
        Thread.sleep(1000);
        sapSession.findElementByName("OK").click();
        Thread.sleep(1000);
        sapSession.findElementByName("Save").click();
        Thread.sleep(1000);

        sapSession.findElementByName("Save").click();
        Thread.sleep(1000);

    }



    @AfterTest
    public static void TearDown()
    {
        calculatorResult = null;
        if (sapSession != null) {
            sapSession.quit();
        }
        sapSession = null;
    }



}
