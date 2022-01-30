package tests.day08_Priority_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {

    // ● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void amazonTest() {
        //    - Test 1
        //    www.amazon.com/ adresine gidin.
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        driver.get(" https://www.amazon.com/");
        WebElement dropdownElement=driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(dropdownElement);

        List<WebElement> list=select.getOptions();

        int actualSize=list.size();
        int expectedSize=45;

        Assert.assertEquals(actualSize, expectedSize, "Kategori sayısı istenilen ile uyuşmamaktadır.");


    }



    @Test
    public void amazonTest2() {
        //    -Test- 2
        //    1. Kategori menusunden Books secenegini  secin

        //    2. Arama kutusuna Java yazin ve aratin
        //    3. Bulunan sonuc sayisini yazdirin
        //    4. Sonucun Java kelimesini icerdigini test edin










    }


    @AfterMethod
    public void teardown() {
        // driver.close();
    }








}
