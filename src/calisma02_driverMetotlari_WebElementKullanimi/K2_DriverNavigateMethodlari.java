package calisma02_driverMetotlari_WebElementKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class K2_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {


        // System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/"); //sayfaya git

        // ve url'in youtube icerdigini test edin
        String expectedUrlIcerik = "https://www.youtube.com/"; //beklenen url
        String actualUrl = driver.getCurrentUrl(); // gerçek url

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url Testi Passed");
        }else {
            System.out.println("Youtube url Testi Failed");
        }

        //3. Testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //   Title'in "Test Otomasyonu" icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu"; //beklenen başlık
        String actualTitle = driver.getTitle(); //beklenen başlık
        Thread.sleep(1000);

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test Otomasyonu Title Testi PASSED");
        }else {
            System.out.println("Test Otomasyonu Title Testi FAILED");
        }

        //4. Tekrar YouTube'sayfasina donelim
        //driver.navigate().to();  driver.get(); ile aynı işlevi yerine getirir
        driver.navigate().back(); // geri döndürür.
        Thread.sleep(1000); // 1sn bekle

        //5. Yeniden testotomasyonu sayfasina gidelim
        driver.navigate().forward(); // döndüğün sayfaya geri git.
        Thread.sleep(1000); // 1sn bekle

        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh(); // sayfayı yenile
        //7. Sayfayi kapatalim / Tum sayfalari kapatalim

        Thread.sleep(2000); // 2sn bekleme
        driver.quit(); // sayfaları kapat.
    }
}
