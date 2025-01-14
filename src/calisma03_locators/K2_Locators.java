package calisma03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class K2_Locators {

    public static void main(String[] args) throws InterruptedException {

        /*
            1- Bir test class’i olusturun ilgili ayarlari yapin
            2- http://zero.webappsecurity.com/ adresine gidin
            3- “ONLINE BANKING” linkine tiklayin
            4- Resim altinda 6 islem basligi oldugunu test edin
            5- Islem basliklari icinde “Pay Bills” oldugunu test edin
            6- Sayfayi kapatin
         */

        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 3- “ONLINE BANKING” linkine tiklayin
        WebElement onlineBakingLinki = driver.findElement(By.id("onlineBankingMenu"));
        onlineBakingLinki.click();
        // driver.findElement(By.id("onlineBankingMenu")).click(); --> click yapılacağı zaman, üstteki 2 satır kodu bu şekilde de yazabiliriz

        // 4- Resim altinda 6 islem basligi oldugunu test edin
        List<WebElement> baslikElementleriList = driver.findElements(By.className("headers"));
        //“ONLINE BANKING” linkindeki başlıkları List içerisine kaydettik.

        int expectedBaslikSayisi = 6; // beklenen başlık sayısı
        int actualBaslikSayisi = baslikElementleriList.size(); // gerçek başlık sayısı

        if (expectedBaslikSayisi == actualBaslikSayisi){ // if ile kontrol
            System.out.println("Başlık sayısı testi PASSED");
        }else {
            System.out.println("Başlık sayısı testi FAILED");
        }

        // 5- Islem basliklari icinde “Pay Bills” oldugunu test edin

        List<String> baslikListesiStr = new ArrayList<>(); // tüm başlıkları String List'e tutalım

        for (WebElement eachBaslik : baslikElementleriList){
            baslikListesiStr.add(eachBaslik.getText());
            // baslikElementleriList'inden tüm başlık isimlerini alıp, baslikListesiStr'e ekledik.
        }

        String expectedBaslikIsmi = "Pay Bills"; // aranan başlık

        if (baslikListesiStr.contains(expectedBaslikIsmi)){ // if ile kontrol
            System.out.println("Pay Bills testi PASSED");
        }else {
            System.out.println("Pay Bills testi FAILED");
        }

        //6- Sayfayi kapatin
        Thread.sleep(3000); //bekleme
        driver.quit(); // sayfaları kapat

    }
}
