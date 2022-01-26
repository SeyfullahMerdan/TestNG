package tests.myworkspace;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HepsiBuradaTest {
    //    1. “https://www.hepsiburada.com/” Adresine gidin
    //    2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //    3. search kutusuna araba yazip arattirin
    //    4. bulunan sonuc sayisini yazdirin
    //    5. sonuc yazisinin "araba" icerdigini dogrulayin
    //    6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void homePage(){
        //    1. “https://www.hepsiburada.com/” Adresine gidin

        driver.get("https://www.hepsiburada.com/");

        //    2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin

        String actualTitle=driver.getTitle();
        String expectedTitle="Turkiye’nin En Buyuk Alisveris Sitesi";

        softAssert=new SoftAssert();

        softAssert.assertEquals(actualTitle,expectedTitle, "Title dogrulaması yanlıştır.");


    }


    @Test (dependsOnMethods="homePage")
    public void car(){

        //    3. search kutusuna araba yazip arattirin

        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba" + Keys.ENTER);

        //    4. bulunan sonuc sayisini yazdirin

        System.out.println( "Bulunan sonuç sayısı: "
                 + driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']")).getText() );

        //    5. sonuc yazisinin "araba" icerdigini dogrulayin

        String actualResult=driver.findElement(By.xpath("//h1[@class='searchResultSummaryBar-bold']")).getText();
        String expectedResult="araba";

        softAssert.assertTrue (actualResult.contains(expectedResult), "Araba içermiyor");

        //    6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

        String actualResult2=driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']")).getText();
        String expectedResult2="oto";

        softAssert.assertFalse( actualResult2.contains(expectedResult2), "Sonuç yazısı oto kelimesi içerir" );


    }


    @AfterClass
    public void teardown(){

        driver.close();
        softAssert.assertAll();
    }





}
