import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Testing {

    public static WebDriver driver;


    @Test(priority = 0)
    public void instantiateDriver(){
        String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/HP-14-Laptop-Dual-Core-Processor/dp/B09VZR2BGN/ref=sr_1_1?crid=1EYLR93KXYLZI&keywords=laptop&qid=1657035384&refinements=p_89%3AHP&rnid=2528832011&s=computers-intl-ship&sprefix=la%2Ccomputers-intl-ship%2C312&sr=1-1");
        driver.findElement(By.id("add-to-cart-button"));

        //String itemPrice = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']/span[1]")).getText();


        String itemPrice = driver.findElement(By.id("base-product-price")).getAttribute("data-base-product-price");

        //System.out.println("price = " + itemPrice);

        driver.findElement(By.id("add-to-cart-button")).click();

        windowFocus();

        if (!driver.findElements(By.xpath("//input[@class='a-button-input'][@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).isEmpty()){
            driver.findElement(By.xpath("//input[@class='a-button-input'][@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
        }else if (!driver.findElements(By.xpath("//span[@id='sw-gtc']/span/a")).isEmpty()){
            driver.findElement(By.xpath("//span[@id='sw-gtc']/span/a")).click();
        }else{
            System.out.println("Cart noot found");
        }
        windowFocus();
    }










    @AfterClass
    public void windowFocus(){

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);
        driver.close();
        driver.quit();



    }
}
