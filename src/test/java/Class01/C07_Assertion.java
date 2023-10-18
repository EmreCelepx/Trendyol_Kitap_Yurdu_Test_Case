package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    @Test

    public void test01(){
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        // 4. Click on 'Signup / Login' button
        WebElement signupLink = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signupLink.click();
        // 5. Verify 'Login to your account' is visible
        WebElement loginYaziElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYaziElementi.isDisplayed());
        // 6. Enter correct email address and password
        WebElement emailKutusu =driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailKutusu.sendKeys("celebian.01@gmail.com");
        WebElement pwKutusu = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        pwKutusu.sendKeys("123456");
        // 7. Click 'login' button
        WebElement loginKutusu = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginKutusu.click();

        // 8. Verify that 'Logged in as username' is visible
        WebElement signUpAs = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(signUpAs.getText());

        // 9. Click 'Logout' button
        WebElement logoutKutusu = driver.findElement(By.xpath("//a[text()=' Logout']"));
        logoutKutusu.click();
        // 10. Verify that user is navigated to login page
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //11. Close driver
        driver.close();

}
}