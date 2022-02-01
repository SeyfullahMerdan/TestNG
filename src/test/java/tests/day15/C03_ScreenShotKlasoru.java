package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    // amazona gidin. 3 farklı test methodu ile java nutella ve elma aratıp sonuc sayfasının ss'ini kaydedin.

    @Test
    public void test01() throws IOException {
        // amazon ansayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella için arama yapalım
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        tumSayfaScreenshot();
    }

    @Test
    public void test02() throws IOException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.clear();
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        tumSayfaScreenshot();
    }

    @Test
    public void test03() throws IOException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.clear();
        searchBox.sendKeys("Elma" + Keys.ENTER);

        tumSayfaScreenshot();
    }


}
