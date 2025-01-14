package calisma02_driverMetotlari_WebElementKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class K5_WebElementKullanma {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.drive","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // test otomasyonu sayfasına gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusuna phone yaazıp, aratın
            /*
                kodlarımız ile reel browser'daki bir webelement'i kullanabilmek için
                önce o webelementi kodlarımıza tanımlayıp,
                bir obje olarak class'da kaydetmeliyiz
            */
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

            //By.id --> locator, "global-search"--> unique(eşsiz) id değeri,  driver.findElement(By.id("global-search"));--> locate etme

        /*
            findElement ile id değeri "global-search" olan HTML elementini aradık
            Bulunan elementi bir WebElement nesnesi olarak tanımladık
            ve aramaKutusu ismini verdik
            Bu elementle işlem yapılabilir hale geldik
         */
        aramaKutusu.sendKeys("phone"); // aramaKutusuna "phone" yazdık
        aramaKutusu.submit(); // ve gönderdik(enter tuşu)

        // arama sonucunda urun bulunabildiğini test edin

        // arama sonuc yazısını locate edip
        // oradaki yazının içinde bulunan sayının
        // 0'dan büyük olduğunu test edelim

        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(aramaSonucYaziElementi);
        //[[ChromeDriver: chrome on windows (f077f6a8c2b4d62fe80f49a2a52ec691)] -> class name: product-count-text]

        System.out.println(aramaSonucYaziElementi.getText()); // 4 Products Found

        String sonucSayisiStr = aramaSonucYaziElementi.getText().replaceAll("\\D",""); // sayı olmayanları hiçlik yaptık
        System.out.println(sonucSayisiStr); // "4"
        int sonucSayisi = Integer.parseInt(sonucSayisiStr); // String değeri, int değere dönüştürdük

        if (sonucSayisi>0){ // 4>0
            System.out.println("Arama testi PASSED"); // Arama testi PASSED
        }
        else {
            System.out.println("Arama testi FAILED");
        }
        //sayfayı kapatın
        Thread.sleep(3000);
        driver.quit();


    }
}
