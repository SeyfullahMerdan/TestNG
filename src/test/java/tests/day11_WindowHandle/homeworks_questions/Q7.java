package tests.day11_WindowHandle.homeworks_questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q7 {
    //  4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    //    https://www.n11.com/ SAYFASINA GiDİN.
    //    https://www.gittigidiyor.com/ SAYFASINA GiDiN
    //    https://getir.com/ SAYFASINA GiDiN
    //    https://www.sahibinden.com/ SAYFASINA GiDiN

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void n11Test(){
        driver.get("https://www.n11.com/");
    }

    @Test (priority = 1)
    public void gittiGTest(){
        driver.get("https://www.gittigidiyor.com/");
    }
    @Test (priority = 2)
    public void getirTest(){
        driver.get("https://getir.com/");
    }

    @Test (priority = 3)
    public void sahibindenTest(){
        driver.get("https://www.sahibinden.com/");
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }


}
