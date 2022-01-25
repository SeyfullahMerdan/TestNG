package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssert {
    // Yeni bir Class Olusturun : C03_SoftAssert
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)"
    // ,"Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)"
    // ,"Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)"
    // ,"Singapore (dollar)","Thailand (baht)"

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void softTest(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin

        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin

        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin

        driver.findElement(By.id("user_login")).sendKeys("username");

        // 4. Password kutusuna “password” yazin

        driver.findElement(By.id("user_password")).sendKeys("password");


        // 5. Sign in tusuna basin

        driver.findElement(By.name("submit")).click();

        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();


        // 6. Pay Bills sayfasina gidin

        driver.findElement(By.xpath("//li[@id='pay_bills_tab']")).click();


        // 7. “Purchase Foreign Currency” tusuna basin

        driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin

        WebElement dropdown=driver.findElement(By.id("pc_currency"));
        Select currency=new Select(dropdown);
        currency.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin

        SoftAssert softAssert=new SoftAssert();
        String actualSelect=currency.getFirstSelectedOption().getText();
        String expectedSelect="Eurozone (Euro)";

        softAssert.assertEquals(actualSelect, expectedSelect, "Dropdown doğru seçilemedi");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin

        List<WebElement> optionList=currency.getOptions();

        String actualOptionListString="";

        for (WebElement each:optionList) {
            actualOptionListString += "\"" + each.getText() + "\", ";
        }
      //    actualOptionListString=actualOptionListString.trim();

        actualOptionListString=actualOptionListString.substring(0,actualOptionListString.length()-2);
        String expectedListeStringOlarak="\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\", \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";
        softAssert.assertEquals(actualOptionListString,expectedListeStringOlarak);

        softAssert.assertAll();
        // buradan sonra kod çalışmayı durdurur. Eğer failed olan kodlar varsa buraya kadar absorbe eder.

    }



    @AfterClass
    public void teardown() {

        driver.close();
    }








}
