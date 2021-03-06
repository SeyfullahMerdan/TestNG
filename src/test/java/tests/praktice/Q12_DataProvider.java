package tests.praktice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q12_DataProvider extends TestBase {

// Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
// login yapiniz Email: batch44@gmail.com   password : 123456789
// Search fonksiyonunu kullanarak
// Mac,ipod ve samsung icin Dataprovider ile yapınız.

    @Test (dataProvider = "getData")
    public void searchFunction(String txt){

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("batch44@gmail.com" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456789" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement searchArea = driver.findElement(By.xpath("//input[@name='search']"));
        searchArea.sendKeys(txt);
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']\n")).click();

    }


    @DataProvider
    public Object [][] getData () {

        String data [][] = {{"mac"}, {"ipod"}, {"samsung"}};
        return data ;

    }












}
