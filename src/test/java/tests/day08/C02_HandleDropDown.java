package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTesti() throws InterruptedException {

        driver.get("https://www.amazon.com");       // dropdownlar genel itibari ile selectle başlar.
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // select classından bir obje oluşturalım ve parametre olarak locate ettigimiz
        // WebElementi yazalım
        Select select = new Select(dropdownElementi);

        // select objesini kullanarak select classından var olan 3 seçim methodundan
        // istedigimizi kullanarak dropdown'da var olan optionlardan birisini seçebiliriz.
        // seçim yapmamıza yardım eden bu 3 method voiddir. Dolayısıyla bize bir şey döndürmezler
        select.selectByIndex(5);

        // Eğer seçtigimiz option degerini yazdırmak istersek farklı bir method kullanmalıyız.
        System.out.println(select.getFirstSelectedOption().getText()); // Books

        // index degil de belirli bir optiona gitmek için, option adını yazarak gideriz.
        Thread.sleep(2000);
        select.selectByVisibleText("Deals");

        // dropdownları görmek için for each ile yazdırabiliriz.

        Thread.sleep(2000);

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List <WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
        ) {
            System.out.println(each.getText());
        }

        // optionList.stream().forEach(t-> System.out.println(t.getText()));

    }



    @AfterMethod
    public void teardown(){
        driver.close();
    }





}
