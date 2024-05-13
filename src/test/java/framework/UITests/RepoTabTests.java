package framework.UITests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RepoTabTests extends BaseTestClass{

    @Test
    void validateRepositoryCount(){

        driver.get(BASE_URL+"andrejs-ps?tab=repositories");

        List<WebElement> repoElements = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        Assertions.assertEquals(21, repoElements.size());

        System.out.println("Validated the count");
    }

}
