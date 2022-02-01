package tests.myworkspace;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActions {

    // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //3- Link 1" e tiklayin
    //4- Popup mesajini yazdirin
    //5- Popup'i tamam diyerek kapatin
    //6- “Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

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
    public void mauseTest(){

        driver.get("http://webdriveruniversity.com/Actions");

        WebElement hover=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));

        Actions actions=new Actions(driver);

        actions.moveToElement(hover).perform();

        WebElement link1=driver.findElement(By.xpath("//a[@class='list-alert']"));
        link1.click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        WebElement box=driver.findElement(By.id("click-box"));
        actions.clickAndHold(box).perform();

        WebElement textBox=driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(textBox.getText());

        actions.doubleClick(driver.findElement(By.xpath("//div[@class='div-double-click']"))).perform();

    }
}
