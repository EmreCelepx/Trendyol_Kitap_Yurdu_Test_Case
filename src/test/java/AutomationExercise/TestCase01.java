package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase01 {
    @Test
    public void test01(){
       // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 2. Navigate to url 'http://automationexercise.com'
         driver.get("https://automationexercise.com");

       // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com";
        //String actualUrl = driver.getCurrentUrl();
        //Assert.assertEquals(actualUrl,expectedUrl);

       // 4. Click on 'Signup / Login' button
        WebElement loginLogonBox = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        loginLogonBox.click();
       // 5. Verify 'New User Signup!' is visible
        String expectedText = "Login to your account";
        String actualText= driver
                .findElement(By.xpath("//h2[text()='Login to your account']"))
                .getText();
        Assert.assertEquals(expectedText ,actualText);
        // 6. Enter name and email address
        // 7. Click 'Signup' button
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        actions.click(nameBox)
                .sendKeys("emre")
                .sendKeys(Keys.TAB)
                .sendKeys("celebian.01@gmail.com")
                .sendKeys(Keys.ENTER)
                .perform();



       // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfoBox = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        String expectedAccountInfoBoxText = "Enter Account Information";
        String actualAccountInfoBoxText = accountInfoBox.getText();


       // 9. Fill details: Title, Name, Email, Password, Date of birth
       // 10. Select checkbox 'Sign up for our newsletter!'
       // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement genderButton = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(genderButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys("18")
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.ESCAPE)
                .sendKeys(Keys.TAB)
                .sendKeys("January")
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("1996")
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()
                .perform();


        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // 13. Click 'Create Account button'
        WebElement addressFirstNameBox= driver.findElement(By.xpath("//input[@name='first_name']"));
        actions.click(addressFirstNameBox)
                .sendKeys("Emre")
                .sendKeys(Keys.TAB)
                .sendKeys("CELEP")
                .sendKeys(Keys.TAB)
                .sendKeys("zzz")        //company
                .sendKeys(Keys.TAB)
                .sendKeys("xxxx")       // adress
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")     // country
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("aaaa")       // state
                .sendKeys(Keys.TAB)
                .sendKeys("bbbb")       // city
                .sendKeys(Keys.TAB)
                .sendKeys("123A")       // zipcode
                .sendKeys(Keys.TAB)
                .sendKeys("55544466")   // mobile// Create Account
                .sendKeys(Keys.ENTER)
                .perform();

       // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedBox = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));

        // 15. Click 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();

       // 16. Verify that 'Logged in as username' is visible

       // 17. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleteAccountVerified = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        String ExpectedDeleteAccount ="Account Deleted!";
        String ActualDeleteAccount = deleteAccountVerified.getText();

    }
}
