import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practical2 {

    public static void main(String[] args) {

        //driver
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open webpage
        driver.get("https://demo.guru99.com/test/newtours/");


        //Input Username and Password and Login
        driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("nipun");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("123");

        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();

        //when you click flight then new window will open
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        //In Flight Details select the option One way
        driver.findElement(By.xpath("//input[@value=\"oneway\"]")).click();

        //Select the number of Passengers
        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"passCount\"]")));
        select.selectByValue("3");

        //Select Departing Airport
        Select select1 = new Select(driver.findElement(By.xpath("//select[@name=\"fromPort\"]")));
        select1.selectByValue("New York");

        //selecting business radio button
        driver.findElement(By.xpath("//input[@value=\"Business\"]")).click();

    }
}
