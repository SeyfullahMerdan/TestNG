package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecutorScroolIntoView extends TestBase {

    // 1- Yeni bir class olusturun : ScroolInto
    //2- hotelmycamp anasayfasina gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
    //4- istediginiz oda inceleme sayfasi acildigini test edin

    /*
    Actions classından Pagedownda belli adımlarla gidiyorduk
    ancak Javascriptte bunu daha da kolaylaştıracak bir method söz konusu.
    Sayfada gözükmeyen bir elementi java script kullanarak, bu elementi görene kadar aşagı in şeklinde kodlayabiliriz
    Ve defalarca pagedown yapmak yerine js kodu ile daha pratik ve kesin bir çözümle kodumuzu çalıştırabilriz.
     Takescreenshot 4 adımda idi.
     JavascriptExecutor 3 adımda yapabiliriz !!!.

     */
    @Test (priority=1)
    public void scroolAction(){
        driver.get("https://www.hotelmycamp.com");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform(); // Bu elementi görene kadar aşagı indirdim.
        // bu elementi görecek ve click yapacak
        WebElement odaInceleElementi=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        odaInceleElementi.click();
    }

    @Test (priority=2)
    public void scroolJsExecutor(){
        driver.navigate().back();
        driver.navigate().refresh();
        //js executor bjesi oluştur ve driveri cast et.
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //çalışacagımız web elementi locate edelim
        WebElement odaInceleElementi=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        //ilgili script ve argüment (elementimiz) ile jsexecutor.executescript() methodunu çalıştıralım.
        js.executeScript("arguments[0].scrollIntoView()", odaInceleElementi);
        js.executeScript("arguments[0].click()", odaInceleElementi);
    }
}
