package tests.day09_Depends_SoftAssert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {


    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(a,b, "1. Test başarısız"); // failed
        softAssert.assertTrue(a>b, "2. Test başarısız"); // failed
        softAssert.assertTrue(a<c, "3. Test başarısız");
        softAssert.assertTrue(c>b, "4. Test başarısız");
        softAssert.assertTrue(c<a, "5. Test başarısız"); // failed


        // assertAll demezsek class çalışır ve passed yazar, çünkü aslında raporlama yapmaz
        // sadce kodlar çalışmış olur.

        // soft assertte hata mesajı yazmak önemli. Hangi hatanın hangisi oldugunu bilme açısından önemlidir.

        softAssert.assertAll();



    }















}
