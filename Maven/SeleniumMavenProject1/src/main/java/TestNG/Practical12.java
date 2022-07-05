package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practical12 {
    private static WebDriver driver;
    @Test
    @Parameters({"sUsername", "sPassword"})
    public void test(String sUsername, String sPassword) {
        String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        //Launch the browser
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Maximize the window
        driver.manage().window().maximize();
        driver.findElement(By.name("userName")).sendKeys(sUsername);
        driver.findElement(By.name("password")).sendKeys(sPassword);
        driver.findElement(By.name("submit")).click();
        //Close the browser
        driver.quit();
    }

}
