package tests.praktice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q11_DataProvider extends TestBase {

    // http://amazon.com adresine gidiniz
    // araba, ev, anahtarlik, ayakkabi, gomlek  kelimelerini arayiniz

    @Test (dataProvider = "urunler")
    public void amazonTesti(String kelime) {

        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime + Keys.ENTER);


    }

    @DataProvider(name="urunler")
    public Object [] [] getUrunler () {
        Object [] [] urunler = { {"araba"} , {"ev"} , {"anahtar link"} , {"ayakkabi"} , {"gomlek"} };
        return urunler;
    }


    // https://www.gittigidiyor.com/ adresine gidiniz
// java, javascript ve python kelimelerini arayiniz


    @Test(dataProvider = "aranacakKelimeler")
    public void gittiGidiyorTest(String aranankelime) {

        driver.get("https://www.gittigidiyor.com/");
        driver.findElement(By.xpath("//input[@name ='k']")).sendKeys(aranankelime + Keys.ENTER);

    }




    @DataProvider
    public Object [] [] aranacakKelimeler () {
        Object [] [] data = { {"java"} , {"javascript"} , {"python"}  };
        return data;
    }







}
