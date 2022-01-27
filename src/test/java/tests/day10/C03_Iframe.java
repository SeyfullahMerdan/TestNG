package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {

    // Bir class olusturun: IframeTest
    //  https://the-internet.herokuapp.com/iframe adresine gidin.
    //  Bir metod olusturun: iframeTest
    //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //  Text Box’a “Merhaba Dunya!” yazin.
    //  TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.


    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void iframe() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement textElement=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(textElement.isEnabled(), "Text is not enabled");
        System.out.println(textElement.getText());

        // Text Box’a “Merhaba Dunya!” yazin



        // yazı yazmak istedigimiz text kutusu iframein içinde oldugundan direk ulaşamıyoruz.
        // önce iframei locate edip onun içine switch yapmalıyız. iframe tag ile  yapabiliriz
        WebElement iFrame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya" );

//  TextBox’in altinda bulunan “Elemental Selenium” linkini tıklayın
//  textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


        WebElement sponsoredYazisi=driver.findElement(By.xpath("//p[text()='Sponsored by'"));

        softAssert.assertTrue(sponsoredYazisi.isDisplayed(), "Sponsored yazısı görünmüyor");



        softAssert.assertAll();
    }
    //1.Driver bizim elimiz, gozumuz gibidir. Onu nereye gonderirsek orda bizim adimiza istedigimiz islemleri yapar.
    //Ama bazen driver'i gonderdigimiz sayfa disina cikmamiz gerekebilir. (alert, iframe, tabs veya yeni pencere gibi..)
    //2.Driver'i gonderdigimiz sayfa disinda bir yerde islem yaptirmak istrersek driver.switchto().yeni ortam
    //3.switch.to() ile gittigimiz ortam alert ise
    //-Ok'e basmak icin .accept()
    //-cancel'e basmak icin .dismiss
    //-alert uzerinde var olan yaziyi almak icin .getText()
    //-alert'de varsa yazi gondermek icin .sendKeys() method'larina kullanabiliriz
    //4.switchTo() ile gittigimiz ortam iframe ise
    //-3 farkli yontem ile iframe'e grcis yapabiliriz
    //i- index
    //ii-id veya name(String)
    //iii-Webelement olarak gecis icin method kullanabiliriz
    //-bir defa iframe'e gecince tekrar o iframe'den cikmamiz gerekirse yine .switchTo() kullanmaliyiz
    //i-parentFrame : icinde oldugumuz iframe'den bir ust iframe'e cikar
    //ii- defaultContent : en ust seviyeye yani anasayfaya gecis yapar
    //eger sadece bir tane iframe varsa bu iki yontem ayni islemi yapmis olur


}
