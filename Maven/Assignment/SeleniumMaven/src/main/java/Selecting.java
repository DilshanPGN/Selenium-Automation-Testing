import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Selecting {

    private static WebDriver driver;
    private static String itemName;
    private static String itemPrice;


    @BeforeClass
    public void openWebSite(){
        String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/HP-Pavilion-Touchscreen-Laptop-HubxcelAccessory/dp/B09YWDYGVZ/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void verification() {

        itemName = driver.findElement(By.id("productTitle")).getText();
        System.out.println("Title of the web page = " + itemName );
        System.out.println("Length of the title = " + itemName.length());

        //select add to cart
        driver.findElement(By.id("add-to-cart-button")).click();

        //wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //get price
        itemPrice = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']/span[2]")).getText();
        System.out.println("Item Price = " + itemPrice);

        //click add to cart
        driver.findElement(By.xpath("//input[@class='a-button-input'][@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();

    }

    @Test(priority = 1)
    public void cartMethod(){
        //window handle
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);

        String newItemName = driver.findElement(By.xpath("//span[@class='a-truncate-full a-offscreen']")).getText();

        String newItemPrice = driver.findElement(By.xpath("//div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']/p/span")).getText();
        System.out.println("Item Name = " + newItemName);
        System.out.println("Item price = " + newItemPrice);


        //assertion
        if ((itemName.equals(newItemName))){
            System.out.println("Item Name Matching");
        }else{
            System.out.println("Item name Not matching");
        }

        if ((itemPrice.equals(itemPrice))){
            System.out.println("Price Name Matching");
        }else{
            System.out.println("Price name Not matching");
        }

        //quantity of the item
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


        // Assert the Shopping Cart Subtotal (should be equal) with Proceed to checkout Subtotal
        String shoppingCartSubtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span")).getText();
        String checkoutSubtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span")).getText();

        System.out.println("shoppingCartSubtotal = " + shoppingCartSubtotal);
        System.out.println("checkoutSubtotal = " + checkoutSubtotal);

        //Assert the Shopping Cart Subtotal (should be equal) with Proceed to checkout Subtotal
        Assert.assertEquals(shoppingCartSubtotal,checkoutSubtotal,"Subtotals does not equal");

        // Click on ‘Proceed to Checkout’ button

        WebElement btn = driver.findElement(By.xpath("//input[@data-feature-id=\"proceed-to-checkout-action\"]"));
        btn.click();


    }



    @Test(priority = 2)
    public void createAccount(){
        //window handle
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);

        driver.findElement(By.id("createAccountSubmit")).click();


    }
    @Test(priority = 3)
    @Parameters({"sUserName","sEmail","sPassword"})
    public void fillDetails(String userName, String email, String password){
        //window handle
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String childWindow = iterator.next();
        System.out.println(windowHandles);
        driver.switchTo().window(childWindow);

        driver.findElement(By.id("ap_customer_name")).sendKeys(userName);
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("ap_password_check")).sendKeys(password);


    }




    @AfterClass
    public void closePage(){
        //driver.close();
    }
}
