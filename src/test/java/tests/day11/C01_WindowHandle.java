package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {


    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String firstHandle= driver.getWindowHandle();
        System.out.println("ilk sayfanın handle degeri " + driver.getWindowHandle());


        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere açılır.

        driver.get("https://www.bestbuy.com");
        String secondHandle= driver.getWindowHandle();
        System.out.println(" 2.Sayfanın Handle degeri: " + driver.getWindowHandle());


        Set<String>handleDegerler =driver.getWindowHandles();
        System.out.println(handleDegerler);
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB); // ikinci bir tab açtım, bir pencere daha açtım.
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);

        driver.switchTo().window(firstHandle);
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(3000);


        driver.switchTo().window(secondHandle);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));


        // facebookun açık oldugu sayfaya geçin ve URL'in https://www.facebook.com oldugunu test edin.

        handleDegerler=driver.getWindowHandles();

        String handleDeger3="";

        for ( String each:handleDegerler ) {
            if ( !(each.equals(firstHandle) || each.equals(secondHandle)) ) {
                handleDeger3=each;  }
        }


        System.out.println("handleDeger3 = " + handleDeger3);
        System.out.println(handleDegerler);


        driver.switchTo().window(handleDeger3);
        Assert.assertEquals(driver.getCurrentUrl() , "https://www.facebook.com" );

        


        Thread.sleep(3000);
    }


    @AfterClass
    public void tearDown() {

        driver.quit();

    }








}
