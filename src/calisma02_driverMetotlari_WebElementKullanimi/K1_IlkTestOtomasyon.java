package calisma02_driverMetotlari_WebElementKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  K1_IlkTestOtomasyon {

    /*
        1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        2. Sayfa basligini(title) yazdirin
        3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin
        4. Sayfa adresini(url) yazdirin
        5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.
        6. Sayfa handle degerini yazdirin
        7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin
        8. Sayfayi kapatin.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 2. Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle(); // gerçek başlık
        System.out.println("Sayfa Title: "+actualTitle); // Sayfa Title: Test Otomasyonu - Test Otomasyonu

        // 3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu"; //beklenen başlık

        if (actualTitle.contains(expectedTitleIcerik)){

            System.out.println("Title Testi Passed");
        }
        else {
            System.out.println("Title Testi Failed");
        }

        // 4. Sayfa adresini(url) yazdirin

        String actualUrl = driver.getCurrentUrl(); // gerçek url
        System.out.println("Gidilen Url:"+actualUrl);

        // 5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.

        String expectedUrl = "https://testotomasyonu.com/"; // beklenen url

        if (expectedUrl.equals(actualUrl)){

            System.out.println("Url Testi Passed");
        }
        else {
            System.out.println("Url Testi Failed"); // Url Testi Failed -- > www. yazılmadığı için
        }

        // 6. Sayfa handle degerini yazdirin

        System.out.println("Açılan window'un window handle değeri:"+driver.getWindowHandles());
        // Açılan window'un window handle değeri:[7BBD56B549A323761FB80692885EF1A0]

        // 7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin

        String expectedSayfaKaynagiIcerik = "otomasyon"; // beklenen sayfa kaynağının içeriği
        String actualSayfaKaynagi = driver.getPageSource(); // gerçek sayfa kaynağının içeriği

        if (actualSayfaKaynagi.contains(expectedSayfaKaynagiIcerik)){
            System.out.println("Sayfa Kaynağı Testi Passed"); // Sayfa Kaynağı Testi Passed
        }
        else {
            System.out.println("Sayfa Kaynağı Testi Failed");
        }

        Thread.sleep(3000); // 3sn bekleme
        driver.quit(); // sayfayı kapat
    }
}
