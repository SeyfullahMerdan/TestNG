package tests.myworkspace;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class TestCases extends TestBase {

    /*
    1.TestCase
     -amazona gidin
     -Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
     -dropdown menude 40 eleman oldugunu dogrulayın.
    2.TestCase
    -dropdown menuden elektronik bölümü seçin
    -arama kutusuna iphone yazıp aratın ve bulunan sonuç sayısını yazdırın
    -sonuç sayısı bildiren yazının iphone içerdigini test edin
    -ikinci ürüne relative locater kullanrak tıklayın
    -ürünün titleini ve fiyatını variablea assign edip ürün sepete ekleyelim
    3.TestCase
    -yeni bir sekme açarak amazon anasayfaya gidin
    -dropdown'dan bebek böümüne geçin
    -bebekpuset aratıp bulunan sonuç sayısını yazdırın
    -sonuç yazısının puset içeridigni test edin
    -üçüncü ürüne relative locater kullanrak tıklayın
    -title ve fiyat bilgilerini assign edelim ve ürünü sepete ekelyin.
    4.TestCase
    -sepetteki ürünlerle ekledigimiz ürünlerin aynı oldugunu isim ve fiyat olarak dogrulayalım.
    */

    static Select select;
    static SoftAssert softAssert;

    @Test (priority = 1)
    public void dropdown(){

        softAssert=new SoftAssert();

        driver.get("https://www.amazon.com/");
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        select=new Select(dropdown);

        List<WebElement> dropdownsList=select.getOptions();
        int count=1;
        for (WebElement e:dropdownsList
        ) {
            System.out.println( count + "'inci dropdown: " + e.getText() + " ");
            count++;
        }
        softAssert.assertEquals(dropdownsList.size(),"40", "Dropdown Element size test FAİLED!" );
    }



    @Test (priority = 2)
    public void iphone(){

        select.selectByValue("search-alias=electronics-intl-ship");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);

        WebElement resultText=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        String resultTextS=resultText.getText();
        System.out.println( "Result Text: " +  resultTextS);
       // WebElement iphoneText=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        softAssert.assertTrue(resultTextS.contains("iphone"));

        WebElement firstP=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement thirdP=driver.findElement(By.xpath("(//img[@class='s-image'])[9]"));
        WebElement secondProduct=driver.findElement(RelativeLocator.with(By.tagName("img")).above(thirdP).below(firstP));
        secondProduct.click();

        WebElement productT=driver.findElement(By.xpath("(//span[@id='productTitle'])[1]"));
        WebElement productP=driver.findElement(By.xpath("(//span[@id='price_inside_buybox'])[1]"));
        String productTitle=productT.getText();
        String productPreis=productP.getText();
        driver.findElement(By.id("add-to-cart-button")).click();
        System.out.println("Sepete eklenen ürün: " + productTitle + " Fiyatı: " + productPreis );
    }












}
