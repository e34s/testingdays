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
    public void webtest() throws MalformedURLException, InterruptedException {
        driver.get("https://www.bmw.de/de/topics/mein-bmw.html");
        driver.findElement(By.id("loginId")).sendKeys("me@myself.com");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("pa$$w0rd");
        Thread.sleep(2000);
        Assert.assertEquals("https://www.bmw.de/de/topics/mein-bmw.html", driver.getCurrentUrl());
        driver.quit();
    }
}
