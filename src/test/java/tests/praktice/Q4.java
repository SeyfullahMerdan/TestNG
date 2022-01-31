package tests.praktice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q4 extends TestBase {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high
     *     T2 : Verify item prices are sorted from low to high with soft Assert
     */

    @Test
    public void sauceTest () {

        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.ENTER );
        driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER );
        driver.findElement(By.id("login-button")).click();

        WebElement dropdown=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("PRICE (LOW TO HIGH)");

        String expected="PRICE (LOW TO HIGH)";
        String actual= driver.findElement(By.className("active_option")).getText();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected, "Fiyatlar istenildigi gibi sıralanmamıştır");
        softAssert.assertAll();
    }

}
