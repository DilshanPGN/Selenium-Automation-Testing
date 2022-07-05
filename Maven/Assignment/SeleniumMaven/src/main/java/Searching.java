import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Searching {
    private static WebDriver driver;


    @BeforeClass
    public void openWebSite(){
        String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    @Parameters({"sExpectedUrl"})
    public void verification(String expectedUrl) {
        String pageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,pageUrl,"Invalid page loaded!");
    }



    @Test(priority = 1)
    @Parameters({"sSearchText"})
    public void search(String searchText){

        driver.findElement(By.id("searchDropdownBox")).click();

        Select selectCategory = new Select(driver.findElement(By.id("searchDropdownBox")));
        selectCategory.selectByValue("search-alias=computers-intl-ship");


        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.findElement(By.id("nav-search-submit-button")).click();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//li[@id='p_89/HP']/span/a/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@data-cel-widget='MAIN-SEARCH_RESULTS-1']/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
       }

    @AfterClass
    public void closePage(){
       //driver.close();
    }

}
