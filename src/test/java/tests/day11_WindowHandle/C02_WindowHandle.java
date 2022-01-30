package tests.day11_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {

    // ● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void handleWindow() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        String expectedText="Opening a new window";
        String actualText=text.getText();
        softAssert.assertEquals(actualText, expectedText, "Text test is FAİLED");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle() , "The Internet" , "Title test FAİLED");


        //● Click Here butonuna basın.
        // soruda windowhandle degerini bilmedigim bir window açılıyor.O sayfanın window handle degerini bulmak için
        // geçtigim sayfalardaki window handle degerlerini kaydetmeliyim.
        String windowHandle1=driver.getWindowHandle(); // click yapmadan önce birinci sayfanın degerin kaydetmiş oluyorum

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
  // Önceki sayfanın handle degerini kaydettim sonra click yaparak yeni sayfaya geçtim...

        // önce açılan yeni sayfanın handle degerini elde etmeliyim. Bunu set oluşturarak elde edecem.
        // önce tüm handle degerlerini alıp bir sete koyalım.
        Set<String> HandleDegerleri=driver.getWindowHandles();
        String windowHandle2="";

        for (String each:HandleDegerleri) {
            if (!(each.equals(windowHandle1))) {
                windowHandle2=each;
            }
        }

        //  artık açılan yeni sayfaya geçiş yapabilirim. Normalde driverim eski sayfada kaldı,getWindowsHandels
        //  diyince otomasyon açtıgı sayfaların handle degerlerinin hespini getirir. Getirdigi handle degerlerden
        //  açmış oldugu sayfanınkini bulup hemde açılan sayfaların
        //  unique handle degerlerini bildigim için denklem kurarak yeni açılan pencerenin handle degerini elde ederim.
        //  elde ettigim bu degerle driverimi ve mausumu bu sayfaya geçirebilirim...


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(windowHandle2);
        softAssert.assertEquals(driver.getTitle(), "New Window", "New Window Title test FAİLED" );


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement secondText=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(secondText.getText(), "New Window" , "Text test New Window is FAİLED");



        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandle1);
        softAssert.assertEquals(driver.getTitle(), "The Internet" , "Second Title test is FAİLED");

         softAssert.assertAll();
    }



    @AfterClass
    public void tearDown() {
       driver.quit();
    }

    // Eğer biz newWindow yaparak geçiyorsak driverimiz o sayfaya gider ve handle degerini de elde edebilriz.
    // Eğer bir yere click yaparak gidiyorsak o zaman;
    //             farklı bir yöntemle o sayfanın handle numarasını elde etmiş oluyorum.



}
