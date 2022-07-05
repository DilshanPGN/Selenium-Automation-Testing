package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practical1 {

    WebDriver driver;

    @BeforeMethod
    public void  beforeMethod(){

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours");
        driver.manage().window().maximize();
    }

    @Test
    public void login(){

        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("nipun");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("nipun123");
    }

    @AfterTest
    public void afterMethod(){
        driver.close();
    }




}
