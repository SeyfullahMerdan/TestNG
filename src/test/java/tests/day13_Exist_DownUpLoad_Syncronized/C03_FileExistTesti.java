package tests.day13_Exist_DownUpLoad_Syncronized;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistTesti {

    @Test
    public void fileExistTest () {

        // Projenizde pom.xml olduğunu test ediniz.

        String filePath=System.getProperty("user.dir")+"\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        // Bir yerde bir dosyanın oldugunu görmek için yapacagımız işlem sadece bu kadar.

        // Bilgisayarımda MASAÜsTÜ klasörü oldugunu test ediyorum.
        String filePath2=System.getProperty("user.home")+"\\Desktop\\MASAÜSTÜ";
        Assert.assertTrue(Files.exists(Paths.get(filePath2)));

        //Bilgisayarımda TECHPRO klasörü oldugunu test ediyorum.

        String filePath3=System.getProperty("user.home") + "\\Desktop\\techpro";
        Assert.assertTrue(Files.exists(Paths.get(filePath3)));

    }

}
