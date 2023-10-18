package Class01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver","C:\\project\\chromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //1- driver.get ("url") --> yazdığımız url'e gider
        //https: kesinlikle olmak zorundadır!

        driver.get("https:\\www.trendyol.com");


        //2- driver.getTitle() --> içinde olduğu sayfanın title'ını döndürür
        System.out.println("sayfa title: " + driver.getTitle());

        //3- driver.getCurrentUrl() -> içinde olduğu sayfanın URL'ini döndürür
        System.out.println("güncel url:" +driver.getCurrentUrl());

        //4- driver.getPageSource(); --> içinde olduğu sayfanın kaynak kodlarını döndürür

        //5- driver.getWindowhandle() --> içinde olduğu sayfanın UNIQUE hash kodunu döndürür
        //6- driver.getWindowhandles() --> driver çalışırjeb açılan tümm sayfaların UNIQUE hash kodunu döndürür
    }
}
