package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    // amazon sayfaya gidin.
    // sag üstte hello,sign in elementinin üzerinde mauseu bekletin
    // açılan menüde new list linkine tıklayın
    // ve new list sayfasının açıldıgını test edin

    //➢ doubleClick ( ): WebElement’e çift tıklama yapar
    //➢ clickAndHold ( ): WebElement uzerinde click yapili olarak bizden komut bekler.
    //➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine sürükler ve bırakır
    //➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in uzerinde tutar
    //➢ contextClick ( ): Mouse ile istedigimiz WebElement’e sag tiklama yapar

    @Test
    public void amazonTest() throws InterruptedException {

        driver.get("https://www.amazon.com");


        Actions action=new Actions(driver);

        WebElement helloElement=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        action.moveToElement(helloElement).perform();
        Thread.sleep(4000);

        WebElement listElement=driver.findElement(By.xpath("//span[.='Create a List']"));
        listElement.click();

        Thread.sleep(4000);

        String actualTitle=driver.getTitle();
        String expectedText="Your List";

        Assert.assertTrue(actualTitle.contains(expectedText), "Did not PASS,FAİLED");

        // HardAssert ile SoftAssert arasındaki fark HardAsserttaki kullandıgımız True,False,Equals methodlarının
        // **static** olması ile ilgilidir.



    }

}
