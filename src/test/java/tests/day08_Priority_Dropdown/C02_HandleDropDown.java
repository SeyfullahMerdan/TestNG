package tests.day08_Priority_Dropdown;

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

    WebDriver driver;  // bütün methodların içinde kullanmak istediğim için instance olarak burada oluşturdum.

    @BeforeMethod    // TestNG de before,after... kalkıyor,beforeclass,aftermethod gibi ikili anotionlar geliyor...
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTesti() throws InterruptedException {
              // Dropdown'da var olan seçeneklerden birisini seçmek için: (3 adımda yapabiliriz bunu.. ):
        // 1-) Önce Dropdown webelementini locate edip bir degişkene atıyoruz.
        driver.get("https://www.amazon.com");
        WebElement dropdownElement=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // Dropdown kutusunu önce locate ettim burada...

        //****** Dropdownlar genel itibari ile selectle başlar. **********
        //****** Select Selenyumda var olan classlardan birisidir *********

        // 2-) Select classından bir obje oluşturalım ve parametre olarak locate ettigimiz WebElementi yazalım.
        Select select = new Select(dropdownElement);

        // select objesini kullanarak select classından var olan 3 seçim methodundan
        // istedigimizi kullanarak dropdown'da var olan optionlardan birisini seçebiliriz.
        // seçim yapmamıza yardım eden bu 3 method voiddir. Dolayısıyla bize bir şey döndürmezler
        select.selectByIndex(5);

        // Eğer seçtigimiz option degerini yazdırmak istersek farklı bir method kullanmalıyız.
        System.out.println(select.getFirstSelectedOption().getText()); // Books
// getFSelectedOption web element döndürür o yüzden üzerindeki yazıyı almamız lazım..
        // index degil de belirli bir optiona gitmek için, option adını yazarak gideriz.
        Thread.sleep(2000);
        select.selectByVisibleText("Deals");

        // dropdownları görmek için for each ile yazdırabiliriz.

        Thread.sleep(2000);

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List <WebElement> optionList = select.getOptions(); // WebElementlerden oluşur direk yazdıramam.
        for (WebElement each: optionList // Listten webelementleri getir ve bunları getText ile yazdır
        ) {
            System.out.println(each.getText());
        }

        // optionList.stream().forEach(t-> System.out.println(t.getText()));
    }

 // Dropdown olunca mutlaka select objesi olur.
    // Biz de select classından select objesinden methodlarla Handle edebiliriz

// Bir dropdownda 3 tane seçim methodumuz var.  Index - Text ve Value degeri



    @AfterMethod
    public void teardown(){
        driver.close();
    }


}
