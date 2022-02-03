package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class S01 extends TestBase {

    @Test
    public void screenshot() throws IOException {

        driver.get("https://www.hepsiburada.com");

        WebElement we=driver.findElement(By.xpath("//div[@id='myAccount']"));

        webElementScreenshot(we);

        //  Hepsi buradaya gidip giriş yap elementinin SSini aldık.


    }


}
