package tests.day08_Priority_Dropdown;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test (priority = -9)  // priority harf sırasına göre çalıştırır. Priority int olmak zorundadır.
    public void youtubeTesti(){
        System.out.println("Youtube testi çalıştı");
    }

    @Test (priority = 5)
    public void amazonTesti(){  // priority atanmazsa priority=0 kabul eder.
        System.out.println("Amazon testi çalıştı");
        // priority koymazsak TestNG test methodlarını alfabetik sıraya göre çalıştırır. Aşagıdan yukarıya
        // çalıştırmaz. ASCII sırası ne ise ona göre çalışır
    }


    @Test
    public void bestbuyTesti(){
        System.out.println("Bestbuy testi çalıştı");
    }


}
