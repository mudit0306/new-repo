package framework.UITests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestClass {

    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll
    static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(Browser.CHROME.browserName());

        driver = new RemoteWebDriver(new URL("http://localhost:8080/"),cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterAll
    static void clear(){
        driver.close();
    }


}
