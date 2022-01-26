package tests.myworkspace;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage01 {
    // 1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contains only three Arrivals
    //7) Now click the image in the Arrivals
    //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
    //10) Click on the Add To Basket button which adds that book to your basket
    //11) User can view that Book in the Menu item with price.
    //12) Now click on Item link which navigates to proceed to check out page.
    //13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page

    SoftAssert softAssert;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        softAssert=new SoftAssert();
    }


    @Test
    public void homePage() {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
        //3) Click on Shop Menu
        driver.findElement(By.id("menu-item-40")).click();
        //4) Now click on Home menu button
        driver.findElement(By.id("//a[text()='Home']")).click();
        //5) Test whether the Home page has Three Arrivals only

        //6) The Home page must contains only three Arrivals
        //7) Now click the image in the Arrivals
        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        //10) Click on the Add To Basket button which adds that book to your basket
        //11) User can view that Book in the Menu item with price.
        //12) Now click on Item link which navigates to proceed to check out page.
        //13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page




    }






    @AfterClass
    public void tearDown() {

        // driver.close();

    }





}
