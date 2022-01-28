package tests.day11;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBase extends TestBase {

    // İnheritance ve Kalıtım konusunda gördügümüz kurallar ve eylemleri otomasyonlarımızda
    // kullanacagız. Gerekli tüm elementleri hazır bir classda oluşturup extends ile çagırıp kullancagız.
    // reusubility ve code temizligi...

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

    }












}
