import io.appium.java_client.windows.WindowsDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WinAppDriverTest {

    private static WindowsDriver calculatorSession = null;
    private static WebElement calculatorResult = null;

    @BeforeClass
    public static void setup() throws MalformedURLException {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            calculatorSession = new WindowsDriver(new URL("http://192.168.1.223:4723"), capabilities);
            calculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            calculatorResult = calculatorSession.findElementByAccessibilityId("CalculatorResults");
            Assert.assertNotNull(calculatorResult);
    }


    @BeforeMethod
    public void clear()
    {
        calculatorSession.findElementByName("Clear").click();
        Assert.assertEquals("0", getCalculatorResultText());
    }

    @Test
    public void Addition()
    {
        calculatorSession.findElementByName("One").click();
        calculatorSession.findElementByName("Plus").click();
        calculatorSession.findElementByName("Seven").click();
        calculatorSession.findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResultText());
    }


    @Test
    public void Combination()
    {
        calculatorSession.findElementByName("Seven").click();
        calculatorSession.findElementByName("Multiply by").click();
        calculatorSession.findElementByName("Nine").click();
        calculatorSession.findElementByName("Plus").click();
        calculatorSession.findElementByName("One").click();
        calculatorSession.findElementByName("Equals").click();
        calculatorSession.findElementByName("Divide by").click();
        calculatorSession.findElementByName("Eight").click();
        calculatorSession.findElementByName("Equals").click();
        org.junit.Assert.assertEquals("8", getCalculatorResultText());
    }

    @Test
    public void Division()
    {
        calculatorSession.findElementByName("Eight").click();
        calculatorSession.findElementByName("Eight").click();
        calculatorSession.findElementByName("Divide by").click();
        calculatorSession.findElementByName("One").click();
        calculatorSession.findElementByName("One").click();
        calculatorSession.findElementByName("Equals").click();
        org.junit.Assert.assertEquals("8", getCalculatorResultText());
    }

    @Test
    public void Multiplication()
    {
        calculatorSession.findElementByName("Nine").click();
        calculatorSession.findElementByName("Multiply by").click();
        calculatorSession.findElementByName("Nine").click();
        calculatorSession.findElementByName("Equals").click();
        org.junit.Assert.assertEquals("81", getCalculatorResultText());
    }

    @Test
    public void Subtraction()
    {
        calculatorSession.findElementByName("Nine").click();
        calculatorSession.findElementByName("Minus").click();
        calculatorSession.findElementByName("One").click();
        calculatorSession.findElementByName("Equals").click();
        org.junit.Assert.assertEquals("8", getCalculatorResultText());
    }


    protected String getCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return calculatorResult.getText().replace("Display is", "").trim();
    }

    @AfterTest
    public static void TearDown()
    {
        calculatorResult = null;
        if (calculatorSession != null) {
            calculatorSession.quit();
        }
        calculatorSession = null;
    }



}
