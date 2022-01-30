package tests.day12_Mause_KeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {

    // Yeni bir class olusturalim: D15_MouseActions4
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//button[@title='Tüm Çerezlere İzin Ver']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        Actions action=new Actions(driver);

        WebElement user=driver.findElement(By.xpath("(//input[@type='text'])[2]"));

        action.click(user).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).sendKeys("eyfu").
                sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).sendKeys("erdanli").
                sendKeys(Keys.TAB).sendKeys("merdanseyfullah3@gmail.com").
                sendKeys(Keys.TAB).sendKeys("merdanseyfullah3@gmail.com").
                sendKeys(Keys.TAB).sendKeys("123456asdF.").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("19").
                sendKeys(Keys.TAB).sendKeys("Nis").
                sendKeys(Keys.TAB).sendKeys("1989").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

     /*  Araya Thread.Sleep ve benczeri kodları koymak istersek perform() yaptıktan sonra yazmak istedigimiz kodu
       koyar. Ardından işleme  ----  action.sendKeys(Keys.ENTER) veya sendKeys("....") vb...  ------
            şeklinde kaldıgımız yerden devam ederiz.


     // bunu oluşturmadan da   WebElement submitButton=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        action.click(submitButton).   Keys.TAB ile bir sonraki tuşa geçebiliriz.
                sendKeys(Keys.ENTER).perform();
*/



    }

}
