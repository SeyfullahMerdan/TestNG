package tests.day11_WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {
    // Klavye ve mause ile yapabildigimiz her işi bizim yerimize yapabilen bir classtır.
    // üzerine durabiliriiz, tıklayabilriiz, yazı gönderebiliriz.,Çift click
    //  tutup sürükleme yapabiliriz, klavyede TAB tuş ile bir sonraki seçenege geçebiliriz, vb...
    //  Mesela bazen çılır penceler olur, o pencereye mauseu getirip bekletirsem ordaki web elementlerinin
    // lokasyonlarını görebiliriim alabilirim, otomasyonun da alması için aynı bir mause işlevi görmesi gerek
    // üzerine gelip durmalı ki lokasyonlar gözüksün ve o açıır penceredeki webelementlerini lokasyon edebilsin
  //  Amazondaki dropdown harici açılır pencereler buna örnektir..
    // Bazen de sayfa geniş olunca, sayfanın altında kalan web elementleri olabiliyor.
    // Programımız gördügünü locate edebilir. Aşagıda kalanları göremedigi için locate edemeyebilir.
    // Mause ile pagedown yapıp o elementleri görebiliriz, Action classında da bunu yapabiliriz.
  //  Klavyede işlevsel --temel-- olarak:
   //  tuşa bir kere basma sonra bırakma, tuşa basılı tutma mesela shift tuşu
    //  veya tuşa basılı tutarken elimizi kaldırabilriz caps lock tuşu gibi...

    // Action classında 3 adımda işlem yapabilriz.

    @Test
    public void actionClassTest() throws InterruptedException {
        //➢ doubleClick ( ): WebElement’e çift tıklama yapar
        //➢ clickAndHold ( ): WebElement uzerinde click yapili olarak bizden komut bekler.
        //➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine sürükler ve bırakır
        //➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in uzerinde tutar
        //➢ contextClick ( ): Mouse ile istedigimiz WebElement’e sag tiklama yapar

        driver.get("https://www.amazon.com");

        Actions action=new Actions(driver);

        WebElement element=driver.findElement(By.id("icp-nav-flyout"));

        action.moveToElement(element).perform(); // mauseu üzerine getirdim

        action.contextClick(driver.findElement(By.xpath("(//span[text()='Deutsch'])[1]"))).perform();
                                     // sag tıkladım ve işlem menüsü çıktı elementin üstünde iken
        Thread.sleep(2000);

        action.doubleClick(driver.findElement(By.xpath("(//span[text()='Deutsch'])[1]"))).perform();
                             // elemente çift tıkladım.


        action.dragAndDrop( driver.findElement(By.xpath("//a[text()='Angebote des Tages']")) , driver.findElement(By.id("twotabsearchtextbox")));
            // bir elementi bi yerden aldım diger yere bıraktım

    }

}
