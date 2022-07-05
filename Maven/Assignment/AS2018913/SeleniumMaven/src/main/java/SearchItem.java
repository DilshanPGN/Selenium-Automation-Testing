import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SearchItem {

    WebDriver driver;

    @BeforeClass
    public void instantiateDriver(){
        driver = Driver.driver;
    }


    @Test(priority = 0)
    @Parameters({"sUrl"})
    public void LaunchApp(String url){
        //1. Launch a Chrome Browser
        //2. Navigate to URL https://www.amazon.com/
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    @Parameters({"sUrl"})
    public void UrlVerification(String url){
        String pageUrl = driver.getCurrentUrl();
        // Get the page URL and verify if it is the correct page that is opened
        Assert.assertEquals(url,pageUrl,"Invalid page loaded!");
    }


    @Test(priority = 2)
    @Parameters({"sKeyword"})
    public void searchItem(String keyword){

        //4. Select “Computers” from main drop-down box
        driver.findElement(By.id("searchDropdownBox")).click();
        Select selectCategory = new Select(driver.findElement(By.id("searchDropdownBox")));
        selectCategory.selectByValue("search-alias=computers-intl-ship");

        //5. Type “Laptop” on search bar
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);

        //6. Click on Search button icon [ Left hand side]
        driver.findElement(By.id("nav-search-submit-button")).click();

    }

    @Test(priority = 3)
    public void sortAndSelectFirstItem(){

        //7. In the Featured Brands Category select first brand [checkbox]
        driver.findElement(By.xpath("//li[@id='p_89/HP']/span/a/span")).click();



        try {



            System.out.println(Driver.driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//div[@class ='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//span[@class='a-size-medium a-color-base a-text-normal']")).getText());
            Driver.driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//div[@class ='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//span[@class='a-size-medium a-color-base a-text-normal']")).click();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ////div[@data-cel-widget='MAIN-SEARCH_RESULTS-1']/div/div/div/div[2]/div/div/div[1]/h2/a/span
        ////*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//div[@class ='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//span

    }

    @AfterClass
    public void closePage(){
        //driver.close();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);
    }



}
