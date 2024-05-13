package framework.UITests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OverviewTabTests extends BaseTestClass{

    String user = "andrejs-ps";

    @BeforeEach
    void overviewTabSetup(){

        driver.get(BASE_URL+user);

    }

    @Test
    void userNameisCorrectOnOverviewTab(){

        String actualName = driver.findElement(By.className("p-nickname")).getText();

        Assertions.assertEquals(user,actualName);
        //driver.close();
        System.out.println("EXECUTION SUCCESSFULL");
    }

    @Test
    void repoLinkGoesToCorrectRepo() throws InterruptedException {

        String expectedlink= "automated-tests-in-java-with-fluent-interface-using-webdriver-selenium";

        driver.findElement(By.linkText(expectedlink)).click();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@itemprop='name']/a")));

        String actualCurrentURL = driver.getCurrentUrl();
        Assertions.assertTrue(actualCurrentURL.contains(expectedlink));
        System.out.println("actualCurrentURL" +actualCurrentURL +" Matches with expectedlink "+expectedlink);
    }

}
