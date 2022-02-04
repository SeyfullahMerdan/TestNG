package tests.praktice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Calendar;

public class Q10 extends TestBase {
    // Faker class ile instagram twittera girmeye çalışalım, girilemedigini dogrulayalım.
    // twitter a faker class kullanarak kayit olmaya calisiniz(actions class kullanmadan - TestNg Framework de)

    @Test
    public void twitterAccess(){

       driver.get("https://www.twitter.com");
       WebElement kaydol=driver.findElement(By.xpath("//span[.='Telefon numarası veya e-posta adresiyle kaydol']"));
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript( "arguments[0].scrollIntoView()" , kaydol  );
       js.executeScript("arguments[0].click()", kaydol);

       WebElement name=driver.findElement(By.xpath("//input[@autocomplete='name']"));
       WebElement tel=driver.findElement(By.xpath("//input[@autocomplete='tel']"));
       // driver.findElement(By.xpath("//span[.='E-posta kullan']")).click();
       // WebElement eposta=driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-16y2uox r-1wbh5a2'])[2]"));
       WebElement bMonth=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
       js.executeScript( "arguments[0].scrollIntoView()" , bMonth  );
       js.executeScript("arguments[0].click()", bMonth);
       WebElement bDay=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
       WebElement bYear=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
       WebElement ileri=driver.findElement(By.xpath("(//div[@role='button'])[4]"));

       Faker faker=new Faker();

       name.sendKeys(faker.name().name());
       tel.sendKeys(faker.phoneNumber().cellPhone());
      // eposta.sendKeys(faker.internet().emailAddress());
       bMonth.sendKeys(faker.letterify("Nisan"));
       bDay.sendKeys(faker.numerify("19"));
       bYear.sendKeys(faker.numerify("1989"));
       ileri.click();


    }

}
