import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class ShoppingCart {

    WebDriver driver;


    @BeforeClass
    public void instantiateDriver(){
        driver = Driver.driver;
    }

    @Test(priority = 0)
    public void nameAndPriceVerification(){
        //14. Verify selected details in Shopping Cart page [Name, Price]
        String newItemName = driver.findElement(By.xpath("//span[@class='a-truncate-full a-offscreen']")).getAttribute("innerHTML");

        String newItemPrice = driver.findElement(By.xpath("//div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']/p/span")).getText();
        System.out.println("New Item Name = " + newItemName);
        System.out.println("New Item price = " + newItemPrice);

        //assertion
        if ((AddingCart.itemName.equals(newItemName))){
            System.out.println("Item Name Matching");
        }else{
            System.out.println("Item name Not matching");
        }

        if (((AddingCart.itemPrice).equals(newItemPrice))){
            System.out.println("Price Name Matching");
        }else{
            System.out.println("Price name Not matching");
        }
    }

    @Test(priority = 1)
    public void quantityVerification(){
        //15. Assert the ‘quantity of the Item (should not be empty) and print in console
        String quantity = driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']/span[2]")).getText();
        int intQuantity = Integer.parseInt(quantity);

        boolean isQuntityEmpty = true;
        if (intQuantity<=0){
            isQuntityEmpty = true;
        }else {
            isQuntityEmpty = false;
        }

        Assert.assertFalse(isQuntityEmpty , "Quantity is empty");
        System.out.println("Quantity = "+quantity);
    }

    @Test(priority = 2)
    public void subtotalVerification(){
        //16. Assert the Shopping Cart Subtotal (should be equal) with Proceed to checkout Subtotal

        String shoppingCartSubtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span")).getText();
        String checkoutSubtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span")).getText();

        System.out.println("shoppingCartSubtotal = " + shoppingCartSubtotal);
        System.out.println("checkoutSubtotal = " + checkoutSubtotal);

        //Assert the Shopping Cart Subtotal (should be equal) with Proceed to checkout Subtotal
        Assert.assertEquals(shoppingCartSubtotal,checkoutSubtotal,"Subtotals does not equal");
    }

    @Test(priority = 3)
    public void checkout(){
        //17. Click on ‘Proceed to Checkout’ button
        WebElement btn = driver.findElement(By.xpath("//input[@data-feature-id=\"proceed-to-checkout-action\"]"));
        //id = proceedToRetailCheckout

        btn.click();
    }


    @AfterClass
    public void windowFocus(){

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);

    }
}
