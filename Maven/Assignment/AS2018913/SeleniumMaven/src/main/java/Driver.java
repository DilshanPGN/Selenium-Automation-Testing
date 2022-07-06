import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Driver{

    public static WebDriver driver;


    @Test
    public void instantiateDriver(){
        String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();

    }



}
