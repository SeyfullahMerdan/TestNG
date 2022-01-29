package tests.myworkspace;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyboardActions {

    //1- Bir Class olusturalim KeyboardActions2
    //2- https://html.com/tags/iframe/ sayfasina gidelim
    //3- video’yu gorecek kadar asagi inin
    //4- videoyu izlemek icin Play tusuna basin
    //5- videoyu calistirdiginizi test edin


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4500);
        // driver.quiz();
    }

    @Test
    public void videoTest(){

        driver.get("https://html.com/tags/iframe/");

        Actions actions=new Actions(driver);


        //3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();


        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);
        WebElement playButton=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playButton).perform();
        //5- videoyu calistirdiginizi test edin
        WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
        Assert.assertTrue(pauseButton.isEnabled(), "Video is not working. TEST FAİLED");

    }

}
