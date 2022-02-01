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


    @Test (priority=1)
    public void scroolAction(){
        driver.get("https://www.hotelmycamp.com");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();

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
