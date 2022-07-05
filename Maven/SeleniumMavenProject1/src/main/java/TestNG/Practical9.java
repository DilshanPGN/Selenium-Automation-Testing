package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practical9 {
    private static WebDriver driver;
    @Test
    public void Assertion() {
        String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        //Launch the browser
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Here driver will try to find out submit button on the application
        WebElement btnSubmit = driver.findElement(By.name("submit"));

        //Test will only continue, if the below statement is true
        //This is to check whether the submit button is displayed or not
        Assert.assertTrue(btnSubmit.isDisplayed());
        //Submit button will be clicked only if the above condition is true
       // btnSubmit.click();
        //Close the browser
        driver.close();
    }

}
