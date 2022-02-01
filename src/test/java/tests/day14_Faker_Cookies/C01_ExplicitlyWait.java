package tests.day14_Faker_Cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    // 1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElement=driver.findElement(By.xpath("//p[.=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
       WebElement itsBackElement=driver.findElement(By.xpath("//p[.=\"It's back!\"]"));

       Assert.assertTrue(itsBackElement.isDisplayed());



    }

    @Test
    public void explicitlyWaitTest() {


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // explicitly wait için önce wait objesi oluşturmalıyım.

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
       // WebElement itsGoneElement=driver.findElement(By.xpath("//p[.=\"It's gone!\"]"));
        // wait.until(ExpectedConditions.visibilityOf(itsGoneElement));

        // Her ne kadar kodun anlaşılabilir olması için önce locate edelim sonra bekleyelim yaklaşımı
        // daha güzel görünse de webelement zaten görünür olmadıgından locate etmemiz de mümkün olmayacaktır.
        // bu durumda locate ve bekleme işlemini beraber yapmak gerekir


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.=\"It's gone!\"]")));

        WebElement itsGoneElement=driver.findElement(By.xpath("//p[.=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.=\"It's back!\"]")));

        WebElement itsBackElement=driver.findElement(By.xpath("//p[.=\"It's back!\"]"));

        Assert.assertTrue(itsBackElement.isDisplayed());



    }




}
