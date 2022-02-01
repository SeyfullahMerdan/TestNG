package tests.praktice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q4_Select extends TestBase {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high
     *     T2 : Verify item prices are sorted from low to high with soft Assert
     */

    @Test
    public void priceTest () {

        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.ENTER );
        driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER );
        driver.findElement(By.id("login-button")).click();
       // T1 : Choose price low to high
        WebElement dropdown=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropdown);
        select.selectByValue("lohi");

        String actual= driver.findElement(By.className("active_option")).getText();
        String expected = "PRICE (LOW TO HIGH)";


        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected, "Fiyatlar istenildigi gibi sıralanmamıştır");
        softAssert.assertAll();
    }


    @Test
    public void verifyTest () {

        driver.navigate().to("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.ENTER );
        driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER );
        driver.findElement(By.id("login-button")).click();

        WebElement dropdown=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropdown);
        select.selectByIndex(2);

        // T2 : Verify item prices are sorted from low to high with soft Assert

        List<WebElement> values=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        ArrayList<Double> valuesDouble=new ArrayList<>();

        for (WebElement w:values
             ) {
            String doubleV=w.getText().replaceAll("^\\D" , "");
            valuesDouble.add(Double.parseDouble(doubleV));
        }

        ArrayList<Double> control=new ArrayList<>(valuesDouble);
        Collections.sort(control);

        Assert.assertEquals(control,valuesDouble);


    }




}
