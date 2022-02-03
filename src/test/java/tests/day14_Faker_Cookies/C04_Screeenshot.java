package tests.day14_Faker_Cookies;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_Screeenshot extends TestBase {


    @Test
    public void screenTest() throws IOException {

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Elektrikli Araç" + Keys.ENTER);

        // 1. adim: screenshot almak için obje oluşturalım ve deger olarak driver'imizi atayalım
        //     deger olarak driver'i kabul etmesi için casting yapmamız gerekir.

        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim: tüm sayfanın screenshotunu almak için bir file oluşturalım ve
        // dosya yolunu belirtelim.

        File tumSayfaSS=new File("target/screenshot/tumSayfa.png");

        //3. Adım: Bir dosya daha oluşturup screenshot objesi ile screenshotı alalım.

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);


        // 4. adim: gecici resmi kaydetmek isedigimiz asıl doyaya copy edelim.

       FileUtils.copyFile(geciciResim,tumSayfaSS);


 /*     Eğer spesifik bir webelementin ss'ini almak istiyorsanız

        WebElement logoElementi=driver.findElement(By.xpath("")); -- önce elementi locate ettim
        File logoResmi=new File("target/screenshot/logo.png");    -- File classı ile koyacagım klasörü oluştrudm
        File geciciResim=logoElementi.getScreenshotAs(OutputType.FILE); -- Elementin SSini aldım,File dosyasına assign ettim.
        FileUtils.copyFile(geciciResim,logoResmi);  --SSi belirledigim yola copy paste yapıyorum.

*/


    }

}
