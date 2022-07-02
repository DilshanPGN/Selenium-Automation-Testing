import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practical1 {

    public static void main(String[] args) {

        //driver
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open webpage
        driver.get("https://www.ebay.com/");

        //get the title
        String title = driver.getTitle();
        int length = title.length();

        //printing received data
        System.out.println("Page title is : " + title);
        System.out.println("Page title length : "+ length);

        //checking url is the corect one or not
        if (driver.getCurrentUrl().equals("https://www.ebay.com/c")){
            System.out.println("Correct page loaded!");
        }else {
            System.out.println("Incorrect page!");
        }

        //getting page source
        String source = driver.getPageSource();
        System.out.println("page source length : " + source.length());

        //close browser
        driver.close();



    }
}
