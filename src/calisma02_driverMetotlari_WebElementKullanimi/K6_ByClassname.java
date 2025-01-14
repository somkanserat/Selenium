package calisma02_driverMetotlari_WebElementKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class K6_ByClassname {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // test otomasyonu anasayfasına gidin
        driver.get("https://www.testotomasyonu.com/");

        // arama kutusuna phone yazıp aratın
        // Kodlarimiz ile reel browser'daki bir webelement'i kullanabilmek icin
        // once o webelementi kodlarimizla tanimlayip
        // bir obje olarak class'da kaydetmeliyiz
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone");
        aramaKutusu.submit();

        // arama sonucunda ürün bulunabildiğini test edin
        // bulunan ürünleri class attribute'u sayesinde toplu locate edebiliyoruz
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size(); // gerçek bulunan ürün sayısı
        System.out.println(actualBulunanUrunSayisi);

        if (actualBulunanUrunSayisi>0){
            System.out.println("Arama Testi PASSED");
        }else {
            System.out.println("Arama Testi FAILED");
        }

        //sayfayı kapatın
        Thread.sleep(3000);
        driver.quit();
    }
}
