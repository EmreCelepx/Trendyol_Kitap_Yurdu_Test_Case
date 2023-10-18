package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1- driver.navigate.to("") -->istenen url'e gider
        //   driver.get(url) ile aynı işlemi yapar ama forward ve back yapılmasına imkan tanır

        driver.get("https://www.amazon.com.tr/");
        driver.navigate().to("https://www.trendyol.com/");

        //2-  driver().navigate().back(); --> bir önceki sayfaya dönüş yapar
        driver.navigate().back(); // örnekte amazona dönüş yapar

        //3- driver.navigate().forward(); --> back() ile geri genilen sayfaya dönüş yapar
        driver.navigate().forward(); // örnekte trendyola geri döner

        //4- driver.navigate().refresh(); --> Sayfayı yeniler
        driver.navigate().refresh();

        //5- driver.close(); açılan sayfayı -tab'ı- kapatır
        driver.close();
        //6-  driver.quit(); tüm tab'ı kapatır
        driver.quit();


    }
}
