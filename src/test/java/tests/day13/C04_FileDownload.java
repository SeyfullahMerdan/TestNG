package tests.day13;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_FileDownload extends TestBase {

    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //        - https://the-internet.herokuapp.com/download adresine gidelim.
    //        - code.txt dosyasını indirelim
    //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void isExistTesti(){
        driver.get("https://the-internet.herokuapp.com/download");

    }

    @Test
    public void downloadTesti(){


    }





}
