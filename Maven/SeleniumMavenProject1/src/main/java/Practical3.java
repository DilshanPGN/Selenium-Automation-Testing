import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practical3 {

    public static void main(String[] args) {

        //driver
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open webpage
        driver.get("https://demoqa.com/automation-practice-form/");

        //Input text fields First name, Last name and Email
        driver.findElement(By.id("firstName")).sendKeys("nipun");
        driver.findElement(By.id("lastName")).sendKeys("dilshan");
        driver.findElement(By.id("userEmail")).sendKeys("nipun@gmail.com");

        //Select date from Datepicker
        driver.findElement(By.id("dateOfBirthInput")).click();
        //react-datepicker__year-select
        Select select1 = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        select1.selectByValue("1998");
        Select select2 = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        select2.selectByVisibleText("October");
        driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--023")).click();

        driver.close();
    }
}
