import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class CartConfirmation {
    WebDriver driver;


    @BeforeClass
    public void instantiateDriver(){
        driver = Driver.driver;
    }


    @Test(priority = 0)
    public void printPrice(){
        //12. Print Item Price in console
        System.out.println("Item Price = " + AddingCart.itemPrice);

    }

    @Test(priority = 1)
    public void goToCart(){
        //13. Click on Cart

        if (!driver.findElements(By.xpath("//input[@class='a-button-input'][@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).isEmpty()){
            driver.findElement(By.xpath("//input[@class='a-button-input'][@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
        }else if (!driver.findElements(By.xpath("//span[@id='sw-gtc']/span/a")).isEmpty()){
            driver.findElement(By.xpath("//span[@id='sw-gtc']/span/a")).click();
        }else{
            System.out.println("Cart noot found");
        }





    }


    @AfterClass
    public void windowFocus(){

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);

    }



    public void refreshPage(){
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);
    }




}
