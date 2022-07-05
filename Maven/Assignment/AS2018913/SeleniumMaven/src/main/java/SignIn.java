import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SignIn {
    WebDriver driver;

    @BeforeClass
    public void instantiateDriver(){
        driver = Driver.driver;
    }

    @Test
    // Click on ‘Create your Amazon Account’ button
    public void createAmazonAccount(){
        driver.findElement(By.id("createAccountSubmit")).click();
    }


    @AfterClass
    public void windowFocus(){

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);

    }
}
