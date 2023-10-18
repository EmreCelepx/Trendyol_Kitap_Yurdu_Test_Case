package TrendyolTestDeneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ty_GirisSenaryo02 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1	https://www.trendyol.com/ Web sitesine git
        driver.get("https://www.trendyol.com/");
        //2 Kadın cinsiyet seçimini yap
        WebElement genderBox = driver.findElement(By.xpath("//img[@alt='Female']"));
        genderBox.click();
        //3	Giriş Yap'a tıkla
        WebElement loginBox = driver.findElement(By.xpath("//p[text()='Giriş Yap']"));
        loginBox.click();
        //4	Eposta Adresi kutusuna bir veri gir
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='login-email']"));
        emailBox.sendKeys("emrecelep09@gmail.com");

        //5	Şifre kutusuna bir veri gir
        WebElement pwBox = driver.findElement(By.xpath("//input[@id='login-password-input']"));
        pwBox.sendKeys("Yesil1122?Ty?");
        //6	Giriş Yap'a tıkla
        WebElement pwButton = driver.findElement(By.xpath("//button[@type='submit']"));
        pwButton.click();

        //7	Kadın kategorisinde link açıldığını doğrula	https://www.trendyol.com/butik/liste/2/erkek

        String expectedUrl = ("https://www.trendyol.com/butik/liste/1/kadin");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        //8 Sayfayı kapat
        driver.close();
    }
    }
