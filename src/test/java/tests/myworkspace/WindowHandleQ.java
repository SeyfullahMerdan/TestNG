package tests.myworkspace;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class WindowHandleQ extends TestBase {
    //● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin


    @Test
    public void amazon () {

        driver.get("https://www.amazon.com");
        String amazonHandle=driver.getWindowHandle();
        String searchWord="Amazon";
        String actualTitle=driver.getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(searchWord), "ActualTitle doesnt exist Amazon");


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        String techProHandle=driver.getWindowHandle();
        searchWord="TECHPROEDUCATION";
        actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(searchWord), "ActualTitle doesnt exist TECHPROEDUCATION");


        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        searchWord="Walmart";
        actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(searchWord),"ActualTitle doesnt exist Walmart");


        driver.switchTo().window(amazonHandle);
        String expectedURL="https://www.amazon.com/";
        String actualURL=driver.getCurrentUrl();
        softAssert.assertEquals(actualURL,expectedURL, "This is not Amazon webpage");


         softAssert.assertAll();
    }

}
