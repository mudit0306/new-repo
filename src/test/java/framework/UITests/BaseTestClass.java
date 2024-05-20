package framework.UITests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {

    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

    @BeforeAll
    static void setup() throws MalformedURLException {


//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chrome/chromedriver.exe");

        System.out.println("Browser Setup completed");
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterAll
    static void clear(){
        System.out.println("Clearing the Browser");
        driver.close();
    }


}
