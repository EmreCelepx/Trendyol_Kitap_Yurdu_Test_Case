package KitapYurduTestDeneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Senaryo06 {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1	 Web sitesine git	https://www.kitapyurdu.com/
        driver.get("https://www.kitapyurdu.com/");

        //2	 Üye Ol linkine tıkla
        WebElement signinButton = driver.findElement(By.xpath("//a[text()='Üye Ol']"));
        signinButton.click();

        //3	 Ad kutusunu bir veri gir	Emre
        WebElement firsnametnameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firsnametnameBox.sendKeys("Emre");

        //4	 Soyad kutusuna bir veri gir	CELEP
        WebElement lastnameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastnameBox.sendKeys("Celep");

        //5	 Eposta Adresi kutusuna bir veri gir	{Eposta adresi}
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys("celebian.01@gmail.com");

        //6	 Şifre kutusuna bir veri gir	12345678a
        WebElement pwBox = driver.findElement(By.xpath("//input[@name='password']"));
        pwBox.sendKeys("12345678");

        //7	 Şifre Tekrarı kutusuna bir veri gir	12345678a
        WebElement pvRetypeBox = driver.findElement(By.xpath("//input[@name='confirm']"));
        pvRetypeBox.sendKeys("12345678");

        //8	 Kişisel Verilerin Korunması kutusuna tıklama
        //9	 Üye Ol butonuna tıkla
        WebElement signupBox = driver.findElement(By.xpath("//button[text()='Üye Ol']"));
        signupBox.click();
        //10  Kayıt işleminin tamamlanmadığını doğrula
        String expectednoKvkkError = "Kişisel Verilerin Korunması metnini kabul etmelisiniz!";
        WebElement noNameError = driver.findElement(By.xpath("//div[@class='ky-error' and contains(text(), 'Kişisel Verilerin Korunması metnini kabul etmelisiniz!')]]"));
        String actualnoKvkkError = noNameError.getText();
        Assert.assertEquals(expectednoKvkkError, actualnoKvkkError);

    }
}