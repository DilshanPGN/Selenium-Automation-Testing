import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class1 {



    @Test
    public void firstMethod(){



        DriverClass.driver.findElement(By.id("searchDropdownBox")).click();

        Select selectCategory = new Select(DriverClass.driver.findElement(By.id("searchDropdownBox")));
        selectCategory.selectByValue("search-alias=computers-intl-ship");


        DriverClass.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");

    }
}
