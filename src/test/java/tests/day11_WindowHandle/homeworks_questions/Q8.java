package tests.day11_WindowHandle.homeworks_questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Q8 {
    //  1) "https://www.facebook.com/" SAYFASINA GiDiN
    //  2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    //  3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    //  4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    //  5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@title='Tüm Çerezlere İzin Ver']")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.print ("The Codes are succesfully completed! All PASS!");
    }

    @Test
    public void facebookDropdownDay() {
        //  3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement birthday=driver.findElement(By.xpath("//select[@id='day']"));
        Select select=new Select(birthday);
        List<WebElement>days=select.getOptions();
        for (WebElement each:days) {
            System.out.print (" " + each.getText());
        }
        System.out.println();
    }

    @Test
    public void facebookDropdownMonth() {
        //  4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
        Select select=new Select(month);
        List<WebElement>months=select.getOptions();
        for (WebElement each:months) {
            System.out.print (" " + each.getText());
        }
        System.out.println();
    }

    @Test
    public void facebookDropdownYear() {
        //  5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
        Select select=new Select(year);
        List<WebElement>years=select.getOptions();
        for (WebElement each:years) {
            System.out.print (" " + each.getText());
        }
        System.out.println();
    }





}
