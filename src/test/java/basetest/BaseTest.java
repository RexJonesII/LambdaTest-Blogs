package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
  public static WebDriver driver;
  private String username = "Rex.Jones";
  private String accessKey = "";
  private String hub = "@hub.lambdatest.com/wd/hub";
  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

  @BeforeMethod
  public void setUp() {
    desiredCapabilities.setCapability("build", "34.1");
    desiredCapabilities.setCapability("name", "Stale Element Reference Exception Blog");
    desiredCapabilities.setCapability("platform", "Windows 10");
    desiredCapabilities.setCapability("browserName", "Chrome");
    desiredCapabilities.setCapability("version", "103.0.5060.114");

    desiredCapabilities.setCapability("tunnel", false);
    desiredCapabilities.setCapability("network", true);
    desiredCapabilities.setCapability("console", true);
    desiredCapabilities.setCapability("visual", true);

    try {
      driver = new RemoteWebDriver(new URL("https://" + username + ":" +
              accessKey + hub), desiredCapabilities);
    } catch(MalformedURLException exc) {
        exc.printStackTrace();
    }
    driver.get("https://www.lambdatest.com/selenium-playground/");
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
