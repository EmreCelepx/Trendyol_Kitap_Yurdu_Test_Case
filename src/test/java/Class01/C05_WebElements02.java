package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_WebElements02 {

 @Test
        public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https:\\www.facebook.com adresine git
        driver.get("https:\\www.facebook.com");
        //e-posta kutusuna rastgele bir mail gir
        WebElement epostaKutusu= driver.findElement(By.xpath("//input[@id='email']"));
        epostaKutusu.sendKeys("HLMsaasfas@gmail.com");
        //şifre kısmına rastgele bir şifre gir
        WebElement pwkutusu= driver.findElement(By.xpath("//input[@id='pass']"));
        pwkutusu.sendKeys("12345678A");
        //giriş yap butonuna bas
        driver.findElement(By.xpath("//button[@name='login']")).click();
        //uyarı olarak Girdiğin e-posta bir hesaba bağlı değil. Hesabını bul ve giriş yap.
        //mesajının çıktığını test edin

        WebElement resultText= driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedResult = "Girdiğin e-posta bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualResult = resultText.getText();


        Assert.assertTrue((actualResult.contains(expectedResult))); //if else yerine kullanıyoruz

        /*
          if (expectedResult.equals(actualResult))
        {
            System.out.println("Girilemedi testi passed");
        }
        else {
            System.out.println("Girilemedi testi failed");
        }
         */
        //sayfayı kapatın
        // driver.close();

    }





}
