package tests.day13_Exist_DownUpLoad_Syncronized;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
    //        - https://the-internet.herokuapp.com/download adresine gidelim.
    //        - code.txt dosyasını indirelim - sample1.png
    //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test (priority = 2)
    public void isExistTesti(){
        String filePath=System.getProperty("user.home") + "\\Downloads\\sample.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }

    @Test (priority = 1)
    public void downloadTesti() throws InterruptedException {   //TESTNG alafabetik sıraya bakar, önce bu çalışır
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[.='sample.png']")).click();
        Thread.sleep(3000);
    }



}
