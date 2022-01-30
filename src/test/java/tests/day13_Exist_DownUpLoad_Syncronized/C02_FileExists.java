package tests.day13_Exist_DownUpLoad_Syncronized;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){

       System.out.println(System.getProperty("user.home"));

        //Masaüstündeki Deneme klasörünün pathini almak istersek::

        // Yani dinamik olarak masaüstümdeki deneme klasörünün pathini yazmak istersem

        String path= System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";
//içinde bulunulan klasörün yolunu-pathini- verir bize...
        System.out.println(path);

        System.out.println( "user.dir: " + System.getProperty("user.dir"));
// userdir projemizin oldugu directoryi verdi bize, bu şekilde projemizin nerde oldugunu görebiliriz.
 // ========================================================================================================= //
        // ==============================================================================================//

        //TEST-CASE: Masaüstündeki Deneme kalsörü içerisinde selenium isminde bir dosya oldugunu test edelim...
            //***************!!!! MAsaüstünde deneme klasörü olmadan çalışmaz !!!***********************
        //1) Önce bu dosyaya ulaşmak için gerekli dinamik path oluşturalım.

        String filePath= System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.xlsx";

        //Selenium ile windows uygulamalarını test edemiyoruz. Bunu niçin Javayı kullanabiliriz.
        // Bilgisyarda dosya olup olmadıgını (exist) kontrol için Javayı kullabiliriz.
        //userhome MyComputer kısmını verir. userdir ise projenin içinde bulundugu klasörün yolunu verir.

        System.out.println( Files.exists(Paths.get(filePath)) ); ///boolean bir sonuç dönecek true veya false

        //TEST-CASE:  projemizde pom.xml oldugunu test edelim...
// pom.xml yolu-->> C: \ Users \ user \ IdeaProjects \ com.TestNGBatch44 \pom.xml
        System.out.println(System.getProperty("user.dir")); // Önce projemin yolunu alacam

        String pomPath = System.getProperty("user.dir") + "\\pom.xml";
       // önce projemin yolunu buldum--->> C: \ Users \ user \ IdeaProjects \ com.TestNGBatch44

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));




    }

}
