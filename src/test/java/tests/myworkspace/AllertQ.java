package tests.myworkspace;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AllertQ {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       softAssert=new SoftAssert();
    }


    @Test
    public void test01() {
       driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
       driver.switchTo().alert().accept();
       String actualResult=driver.findElement(By.id("result")).getText();
       String expectedResult="You successfully clicked an alert";
       softAssert.assertEquals(actualResult,expectedResult);
    }


    @Test
    public void test02() {

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="successfuly";

        softAssert.assertFalse(actualResult.contains(expectedResult), "successfuly test FAİLED");

    }



    @Test
    public void test03() {

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Merdan");
        driver.switchTo().alert().accept();
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="Merdan";

        softAssert.assertTrue(actualResult.contains(expectedResult), "Merdan test FAİLED");

    }




    @AfterClass
    public void tearDown() {

        softAssert.assertAll();

        // driver.close();
    }



}
