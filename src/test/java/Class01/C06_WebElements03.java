package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_WebElements03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https:\\www.bestbuy.com adresine gidin
            driver.get("https:\\www.bestbuy.com");
        // 2- cookies çıkarsa kabul et butonuna basın


        // 3- sayfada kaç adet link bulunduğunu yazdırın
        List<WebElement> butonListesi =driver.findElements(By.tagName("button"));
        System.out.println(butonListesi.size());

        // 4- sayfadaki herbir linkin üzerinde ki yazıları yazdırın
        for (WebElement w:butonListesi) {
            System.out.println(w.getText());
        }

    }
}
