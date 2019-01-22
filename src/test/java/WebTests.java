import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebTests {

    public RemoteWebDriver driver = null;
    public WebDriverWait wait = null;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("e34:token", "30e75a42-817d-4c"); //mpalotas
        capabilities.setCapability("e34:video", true);
        driver = new RemoteWebDriver(new URL("http://vm-106.element34.net/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 5000);

    }

    @Test
    public void webtest() throws MalformedURLException {
        driver.get("https://www.bmw.de/de/index.html");
        driver.findElement(By.linkText("Alle BMW Modelle")).click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ds2-model-page > div.row > div > h1"))));
        Assert.assertEquals("Alle BMW Modelle: Übersicht | BMW.de", driver.getTitle());
        driver.quit();
    }
}
