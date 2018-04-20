package D2;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import D1.GooglePage;

public class GoogleTest {

    private WebDriver driver;
    private GooglePage google;

    @Before
    public void setUp() throws MalformedURLException {
    	System.out.println("entering before test");
    	DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dc.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dc.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		//dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		//dcp.setCapability("name", "SeleniumDocker");
		dc.setCapability("idleTimeout", 150);
        driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/grid/console"), dc);
        google = new GooglePage(driver);
        System.out.println("in before Google Test");
    }

    @Test
    public void googleTest() throws InterruptedException {
        google.goTo();
        System.out.println("in Test goto");
        google.searchFor("automation");
        System.out.println("in Test search for");
        Assert.assertTrue(google.getResults().size() >= 10);
    }
    
    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        System.out.println("in After Google Test");
    }    

}