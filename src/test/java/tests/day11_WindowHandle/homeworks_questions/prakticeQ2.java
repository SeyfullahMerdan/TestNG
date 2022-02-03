package tests.day11_WindowHandle.homeworks_questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class prakticeQ2 {

    // 2.soru :Ingilizce
    //    go to url :http://demo.automationtesting.in/Alerts.html
    //     click  "Alert with OK" and click 'click the button to display an alert box:'
    //     accept Alert(I am an alert box!) and print alert on console
    //     click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //     cancel Alert  (Press a Button !)
    //     click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //     and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.print ("The Codes are succesfully completed! All PASSED!");
    }

    @Test
    public void alertTest(){
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

        System.out.println( "Alert Text: " + driver.switchTo().alert().getText() ) ;
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo1")));

        String lastText=driver.findElement(By.id("demo1")).getText();
        System.out.println(lastText);
    }
}
