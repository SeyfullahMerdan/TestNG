package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {

    // amazon anasayfaya gidip
    // sell linkine js executer ile tıklayalım.
    // ilgili sayfaya gittigmizi test edelim

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        // 1.Adım JSExecuter objesi oluşturulaım ve driveri cast edelim

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 2.Adım ilgili web elementi locate edelim
        WebElement sellElement = driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        // 3. Adım ilgili script ve argument ile objemiz üserinden executeScript methodunu çalıştıralım
        js.executeScript("arguments[0].click();", sellElement);

        Thread.sleep(3000);


    }


}
