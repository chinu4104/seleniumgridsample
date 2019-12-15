package SeleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class seleniumGridClass {
    private WebDriver driver;

    @Test
    public void gridConcept() throws MalformedURLException {
        DesiredCapabilities descap = new DesiredCapabilities();
        descap.setBrowserName("chrome");
        descap.setPlatform(Platform.LINUX);

        ChromeOptions chromeopt = new ChromeOptions();
        chromeopt.merge(descap);

        // change the url based on the selenium chrome service name
        String hubUrl = "http://seleniumstandalonechrome:4444/wd/hub/";
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl),chromeopt);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google",driver.getTitle());
        driver.quit();
    }

}
