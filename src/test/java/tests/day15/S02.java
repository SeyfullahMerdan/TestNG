package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class S02 extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.ebay-kleinanzeigen.de/");
        driver.findElement(By.xpath("//span[@class='jsx-4131758822']")).click();
        driver.findElement(By.xpath("//input[@id='site-search-query']")).sendKeys("laptop" + Keys.ENTER);

        TakesScreenshot tss= (TakesScreenshot) driver; // Driver verbindet TakesScreenshot
        File sSpath=new File("target/screenshot/laptopSuche.png");
        File bild=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(bild,sSpath);

        // Ich nehme Ergebnis der Element auf.

        WebElement ergebnis=driver.findElement(By.className("breadcrump-summary"));
        File ssPath2=new File("target/screenshot/ergebnisText.png");
        File bildEx=ergebnis.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(bildEx,ssPath2);

    }

}
