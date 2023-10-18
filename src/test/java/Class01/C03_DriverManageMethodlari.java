package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //bu 4 ayar her testte olmalıdır !!!!!!



        //1-  driver.manage().window() methodlari
        //1-A driver.manage().window().getSize() --> içinde olduğumuz sayfanın pixel ölçülerini döndürür
        System.out.println(driver.manage().window().getSize());


        //1-B  driver.manage().window().getPosition() --> Başlangıç noktasının pixel kordinatlarını döndürür
        System.out.println(driver.manage().window().getPosition()); //sol alt set edilir (10,10)


        //1-C driver.manage().window.setPosition(new Point(15,15))
        //    içinde olduğu sayfanın solt alt köşesini bizim yazacağımız pixel noktasına taşır
        driver.manage().window().setPosition(new Point(15,15));

        //1-D driver.manage().window().setSize(new Dimension (900,600));
        //    içinde olduğu sayfanın sol alt köşesi sabit olarak bizim yazacağımız ölçülere getirir

        driver.manage().window().setSize(new Dimension(900,600));

        System.out.println("yeni pencere ölçüleri: " + driver.manage().window().getSize());
        System.out.println("yeni pencere konumu: " + driver.manage().window().getPosition());


        //driver.manage().window().maximize();   sayfayı maksimize eder
        //driver.manage().window().fullscreen(); sayfayı tamsayfa yapar

        driver.manage().window().maximize();
        System.out.println("yeni pencere ölçüleri: " + driver.manage().window().getSize()); // (1936, 1048)
        System.out.println("yeni pencere konumu: " + driver.manage().window().getPosition());//(-8, -8)

        driver.manage().window().fullscreen();
        System.out.println("yeni pencere ölçüleri: " + driver.manage().window().getSize()); //(1920, 1080)
        System.out.println("yeni pencere konumu: " + driver.manage().window().getPosition());//(0, 0)

        //driver.manage().window().maximize();   sayfayı simge boyutuna küçültür

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- driver.manage().timeouts() methodlari
         /*      wait konusunu ilerde tek basina ele alacagiz
                ancak her class icin yapmamiz gereken bir ayar oldugu icin burada kisaca deginelim
                implicitlyWait : driver'a sayfanin yuklenmesi ve kullanacagimiz webelementlerin bulunmasi icin
                                 bekleyecegi maximum sureyi belirtir.
                                 driver bu sure icerisinde sayfa yuklenir/web element bulunursa
                                 beklemeden calismaya devam eder.
                                 bu sure bittigi halde sayfa yuklenememis/webElement bulunamamissa
                                 exception vererek calismayi durdurur

                Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zaman class'idir
                                         Yani driver'a ne kadar bekleyecegini soyler
                                         Duration.ofSeconds(15) yerine milis,minutes,hours da kullanilabilir
         */

        /* NOT :    Driver'in istedigimiz islemleri yaparken sorunla karsilasmamasi icin
                    driver.manage() method'larindan
                    maximize() ve implicitlyWait() method'larinin her test'te kullanilmasi
                    FAYDALI OLACAKTIR

         */









    }

}
