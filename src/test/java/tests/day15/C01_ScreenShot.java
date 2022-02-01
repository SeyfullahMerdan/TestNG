package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {

    @Test
    public void nutellaTesti() throws IOException {

        // amazon ansayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella için arama yapalım
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // sonuçların nutella içerdigini test edelim.
        WebElement resultText=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String resultValue=resultText.getText();
        Assert.assertTrue(resultValue.contains("Nutella"));

        // testin çalıştıgının ispatı için tüm sayfanın screenshotunu alalım

        // tüm sayfa ss için 4 adım gereklidir.
        // 1.Adım: TakeScreenShot objesi oluşturmak

        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2. Adım: Kaydedecegimiz dosyayı oluşturalım.

        File allPageSS=new File("target/screenshot/tumsayfa.png");

        //3. Adım: Bir dosya daha oluşturup screenshot objesi ile screenshotı alalım.

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //4. Adım olarak: Geçici resmi kaydetmek istedigimiz asıl dosyaya assign edelim.

        FileUtils.copyFile(geciciResim,allPageSS);







    }


}
