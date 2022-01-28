package tests.homeworks_questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class Q6 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void windowsTest() {

        //  ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
       String actualText=driver.findElement(By.tagName("h3")).getText();
       String expectedText="Opening a new window";
       SoftAssert softAssert=new SoftAssert();
       softAssert.assertEquals(actualText,expectedText, "Actual and Expected text is doesnt match");

        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Title doesnt exist The Internet");

        //  ● Click Here butonuna basın.
        String firstHandleNumber=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Click Here']"));

        //  ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> handleList=driver.getWindowHandles();
        String newWindowHandleNumber="";
        for (String each:handleList ) {
            if (!(each.equals(firstHandleNumber))) {
                newWindowHandleNumber = each; }
        }

        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        driver.switchTo().window(newWindowHandleNumber);
        softAssert.assertEquals( driver.findElement(By.tagName("h3")).getText(),"New Window","Text test doesnt match");

        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstHandleNumber);
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Last Title test FAİLED");


    }

}
