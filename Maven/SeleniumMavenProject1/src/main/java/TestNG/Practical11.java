package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practical11 {
    private static WebDriver driver;

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{"testuser_1", "Test@123"}, {"testuser_2", "Test@456"}};
    }

    // Here we are calling the Data Provider object with its Name
    @Test(dataProvider = "Authentication")
    public void test(String sUsername, String sPassword) {

        String exePath = System.getProperty("user.dir") +"\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch the browser
        driver.get("http://demo.guru99.com/test/newtours/");
        // Maximize the window
        driver.manage().window().maximize();


        driver.findElement(By.name("userName")).sendKeys(sUsername);
        driver.findElement(By.name("password")).sendKeys(sPassword);
        driver.findElement(By.name("submit")).click();
        //Close the browser
        driver.quit();
    }

}
