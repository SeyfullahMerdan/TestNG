package tests.day14_Faker_Cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screeenshot extends TestBase {


    @Test
    public void screenTest(){

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();

        // 1. adim: screenshot almak için obje oluşturalım ve deger olarak driver'imizi atayalım
        //     deger olarak driver'i kabul etmesi için casting yapmamız gerekir.

        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim: tüm sayfanın screenshotunu almak için bir file oluşturalım ve
        // dosya yolunu belirtelim.

        File tumSayfaSS=new File("src//tumSayfa.png");

        // 3. adim: oluşturdugumuz file ile takescreenshot objesini ilişkilendirelim

        tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);


        // eğer spesifik bir webelementin ss'ini almak istiyorsanız

        WebElement logoElementi=driver.findElement(By.xpath(""));
        File logoResmi=new File("src/logo.png");
        logoResmi=logoElementi.getScreenshotAs(OutputType.FILE);


    }

}
