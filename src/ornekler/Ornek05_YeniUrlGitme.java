package ornekler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ornek05_YeniUrlGitme {

    public static void main(String[] args) throws InterruptedException {
        /*
            1. Yeni bir class olusturalim
            2. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
               (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
               yazdirin.
            3. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
               “actual” URL’i yazdirin.
            4. https://www.walmart.com/
               sayfasina gidin.
            5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
            6. Tekrar “facebook” sayfasina donun
            7. Sayfayi yenileyin
            8. Sayfayi tam sayfa (maximize) yapin
            9. Browser’i  kapatin
         */

        // 1. Yeni bir class olusturalim
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        // (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        // yazdirin.
        driver.get("https://www.facebook.com/");
        String expectedSayfaBasligi = "facebook";
        String actualSayfaBasligi = driver.getTitle();

        if (actualSayfaBasligi.contains(expectedSayfaBasligi)){
            System.out.println("Sayfa Başlığı testi PASSED");
        }
        else {
            System.out.println("Doğru Başlık:"+ actualSayfaBasligi);
        }

        // 3. Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        // “actual” URL’i yazdirin.
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url Testi PASSED");
        }else {
            System.out.println("Actual URL:"+actualUrl);
        }

        // 4. https://www.walmart.com/
        // sayfasina gidin.
        Thread.sleep(1000);
        driver.navigate().to("https://www.walmart.com/");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedWalmartSayfaBasligi = "Walmart.com";
        String actualWalmartSayfaBasligi = driver.getTitle();

        if (actualWalmartSayfaBasligi.contains(expectedWalmartSayfaBasligi)){
            System.out.println("Walmart Sayfa Başlığı Testi PASSED");
        }else {
            System.out.println("Doğru Başlık:"+actualWalmartSayfaBasligi);
        }

        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(2000);
        //7. Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);
        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9. Browser’i  kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
