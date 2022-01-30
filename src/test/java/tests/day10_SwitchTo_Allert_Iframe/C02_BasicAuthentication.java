package tests.day10_SwitchTo_Allert_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication {

    // 1- Bir class olusturun : BasicAuthentication
    // 2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //    Html komutu : https://username:password@URL
    //    Username     : admin
    //    password      : admin
    // 4- Basarili sekilde sayfaya girildigini dogrulayin

    WebDriver driver;

    // Uygulamalar arasındaki haberleşmeler genellikle API ile halledilir.
    // Sitelerde bazen sitelere ait olmayan sürekli degişen bilgiler bulunabilir, bu tür sayfalar bi yerle analaşarak API
    // ile bu bilgileri alarak,güncel olarak yaynlarlar. Bu tür hizmet veren firmalar Authentication verirler.

    // Basic Authentication aslında bir HTML komutudur. Girişi çıkışı kontrol altında olan siteler olabilir, sisteme
    // kimin girip kimin giremeyecegini kontrol eder ve bunlar locate edilemez. Kullanıcı adı ve şifre olmadan girilemez,
    // biliyorsak eğer locate yaparken yollayarak siteye gideriz ve öyle gideriz.
      // Html komutu içerisinde gönderiyoruz.

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void authenticationTesti(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        // driver.get("https://the-internet.herokuapp.com/basic_auth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin.
        //  Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        //  basic authentication isteyen web servisleri bize nasil ve hangi bilgilerle authentication
        // yapabilecegimiz bilgisini de vermek zorundadir.
        // bi de bize tarif edilen yontem ve bize verilen bilgileri birebir uygulayarak
        // istedigimiz webservise giris saglayabiliriz
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratMesajElementi=driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratMesajElementi.isDisplayed());
    }


    @AfterClass
    public void teardown() {
        driver.close();
    }



}
