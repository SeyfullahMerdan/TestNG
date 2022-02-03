package tests.day11_WindowHandle.homeworks_questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q9 {
    //   1- https://www.facebook.com adresine gidelim
    //   2- Yeni hesap olustur butonuna basalim
    //   3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        // driver.quiz();
    }

    @Test
    public void facebookHesapTest() throws InterruptedException {

        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//button[@title='Tüm Çerezlere İzin Ver']")).click();

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();


        Actions action=new Actions(driver);

        WebElement user=driver.findElement(By.xpath("(//input[@type='text'])[2]"));

        action.click(user).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).sendKeys("eyfullah").
                sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).sendKeys("erdanli").
                sendKeys(Keys.TAB).sendKeys("merdanseyfullah3@gmail.com").
                sendKeys(Keys.TAB).sendKeys("merdanseyfullah3@gmail.com").
                sendKeys(Keys.TAB).sendKeys("123456asdF.").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("19").
                sendKeys(Keys.TAB).sendKeys("Nis").
                sendKeys(Keys.TAB).sendKeys("1989").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }

}
