package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    // "https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin

    @Test
    public void facebookKayitTesti() throws InterruptedException {

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@title='Tüm Çerezlere İzin Ver']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        Actions action=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        WebElement user=driver.findElement(By.xpath("(//input[@type='text'])[2]"));

        action.click(user).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("19").
                sendKeys(Keys.TAB).sendKeys("Nis").
                sendKeys(Keys.TAB).sendKeys("1989").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();

       WebElement erkekSecimElementi=driver.findElement(By.xpath("//input[@value='2']"));
       WebElement kadinSecimElementi=driver.findElement(By.xpath("//input[@value='1']"));

        Assert.assertTrue(erkekSecimElementi.isSelected());
        Assert.assertFalse(kadinSecimElementi.isSelected());

        Thread.sleep(3000);



    }


}
