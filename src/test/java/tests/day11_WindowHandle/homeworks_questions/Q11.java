package tests.day11_WindowHandle.homeworks_questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q11 extends TestBase {
     /*
      go to url :http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (somepne@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window
     */

    @Test
    public void switctTest(){
        //  go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement securty=driver.findElement(By.className("faktor-iframe-wrapper"));
        driver.switchTo().frame(securty);
        driver.findElement(By.xpath("(//span[text()='Tümünü Kabul Et'])[1]")).click();
        driver.switchTo().defaultContent();
        //      get the first window




        //      clicking on click here button
        //      get all the window in the set
        //      switch to window
        //      input email id (somepne@gmail.com) and type something in that input
        //      Clicking on the submit button
        //      verify title as expected
        //      switch to first window















    }

}
