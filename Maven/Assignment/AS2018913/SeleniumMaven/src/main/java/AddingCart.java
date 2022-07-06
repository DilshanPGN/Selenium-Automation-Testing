import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AddingCart {
    WebDriver driver;
    public static  String itemName;
    public static String itemPrice;

    @BeforeClass
    public void instantiateDriver(){
        driver = Driver.driver;
    }


    @Test(priority = 0)
    public void printDetails(){
        itemName = driver.findElement(By.id("productTitle")).getText();

        //9. Print the Item Title (Name) in console
        System.out.println("Item Name = " + itemName );

       // 10. Get the Title Length and print in console
        System.out.println("Length of the title = " + itemName.length());

        //get the price
        itemPrice = driver.findElement(By.id("base-product-price")).getAttribute("data-base-product-price");


    }

    @Test(priority = 1)
    public void addToCart(){
        //11. Select “Add To Cart”
        driver.findElement(By.id("add-to-cart-button")).click();

    }

    @AfterClass
    public void windowFocus(){

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

    }




}
