package tests.praktice;

import org.testng.annotations.Test;

public class Q1_Priority {

    /*
    JUnit-->>  @Ignore
               @Test
  ●TestNG (default ) olarak @Test methodları ni alfabetik sıraya gore run eder ..(Yukardan asagi degil)
  ●priority annotation Testlere öncelik vermek icin kullanilir, Kucuk olan Numara daha once calisir.
  priority:  TestNG testlerinde, testler konsola alfabetik sira ile yazdirilir. Default degeri sıfırdır.
  enabled = false  methodu : Testi gormezden gelmek icin @Test in yanina    '(enabled = false)' fonksiyonunu kullaniriz.
 */


    @Test (priority = 3000)
    public void b(){
        System.out.println("b");
    }

    @Test (priority = 2002 , enabled = false)
    public void a(){
        System.out.println("a");
    }

    @Test (priority = 2000)
    public void c(){
        System.out.println("c");
    }


    @Test
    public void test1(){
        System.out.println("Test1.....");
    }


    @Test
    public void test2(){
        System.out.println("Test2.....");
    }

    @Test
    public void test3(){
        System.out.println("Test3.....");
    }

    @Test (enabled=false)
    public void test4(){
        System.out.println("Test4.....");
    }

    @Test (enabled=false)
    public void test5(){
        System.out.println("Test5.....");
    }

    @Test
    public void test6(){
        System.out.println("Test6.....");
    }


}
