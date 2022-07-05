import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CreateAccount {
    WebDriver driver;

    @BeforeClass
    public void instantiateDriver(){
        driver = Driver.driver;
    }

    @Test
    @Parameters({"sUserName","sEmail","sPassword"})
    public void fillDetails(String userName, String email, String password){

        driver.findElement(By.id("ap_customer_name")).sendKeys(userName);
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("ap_password_check")).sendKeys(password);


    }


    @AfterClass

    public void windowFocus(){
        //20. Close the Browser
        driver.close();
    }
}
