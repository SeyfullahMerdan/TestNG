package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {

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

        // testin çalıştıgının ispatı için çıkan sonuç sayısının screenshotunu alalım

        // yine 4 adım gereklidir.

        // 1.Adım: ss çekecegimiz web elementi locate edelim
                              // Yukarıda locate etmiştim burda etmiyorum o yüzden....
        // 2. Adım: SS'i kaydedecegimiz bir file oluşturalım
        File webElementSS=new File("target/screenshot/webelement.jpeg");

        //3. Adım:
        File geciciResim=resultText.getScreenshotAs(OutputType.FILE);

        //4. Adım olarak: Geçici resmi kaydetmek istedigimiz asıl dosyaya assign edelim.
        FileUtils.copyFile(geciciResim,webElementSS);



    }

}
