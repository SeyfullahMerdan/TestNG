package tests.day12_Mause_KeyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    // 1- Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin


    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions=new Actions(driver);
        actions.click(searchBox).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("A").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).perform();



    }


}
