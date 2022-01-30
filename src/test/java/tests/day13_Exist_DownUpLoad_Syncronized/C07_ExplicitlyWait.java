package tests.day13_Exist_DownUpLoad_Syncronized;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C07_ExplicitlyWait extends TestBase {

    @Test
    public void test01() {

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50)); // Obje oluşturmamız lazım.
        wait.until(ExpectedConditions.alertIsPresent());    //   ...... 'a kadar bekle
       //  wait.until(ExpectedConditions.)  --> Burdan sonra çıkacak çeşitli methodlarla işlemi belirleriz

        //  Thread.sleep  --> java ile ilgilidir   (Hardwait)

        //  Selenium'da wait 2'ye ayrılır:
        //  Implicit Wait ve Explicit Wait         (Dynamic Wait)


        // Implicitly Wait timeouts ile çalışıyor.
        // Explicitly Wait ise obje oluşturarak çalışır


        // Implicitly Wait --> Sayfadaki tüm ögeler için geçerlidir. Global bir zaman aşımıdır

        // Explicitly Wait --> Sadece bir işlem içindir ve o işlem için tanımlanır
        //            spesifik bir işlem gereklidir bunu kullanmam için. Implicitly ile halledemeyeceksek eğer
        //            o zaman explicitly kullanırız.




    }


}
