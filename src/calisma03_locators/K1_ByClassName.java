package calisma03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class K1_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        /*
            1- Bir test class’i olusturun ilgili ayarlari yapin
            2- https://www.testotomasyonu.com/ adresine gidin
            3- arama kutusuna phone yazip aratin
            4- Category bolumunde 8 element oldugunu test edin
            5- Category isimlerini yazdirin
            6- Sayfayi kapatin
         */

        // 1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // bu süre tüm işlemler için ayrı ayrı geçerlidir
        // tüm işlemler--> sayfa bulunması ve her bir elementin locate edilmesi
        // buraya yazılan 10 saniye boyunca bekler

        // 2- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com/");

        // 3- arama kutusuna phone yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        // Keys.ENTER --> submit(); ile aynı işlevdedir.
        //aramaKutusu.submit();

        // 4- Category bolumunde 8 element oldugunu test edin

        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-list"));
        // kategori kısmında birden fazla webelement olduğu için, webelementlerini list içerisine kaydederiz

        int expectedCategorySayisi = 8; // beklenen kategori sayısı
        int actualCategorySayisi = categoryElementleriList.size(); // gerçekte kategori sayısı

        if (expectedCategorySayisi == actualCategorySayisi){ // if ile kontrol
            System.out.println("Category sayisi Testi PASSED ");
        }else {
            System.out.println("Category sayisi Testi FAILED");
        }

        // 5- Category isimlerini yazdirin

        System.out.println(categoryElementleriList);
        // Listede Webelementler olduğu için direkt yazdıramayız.
        // Eğer listedeki her bir elementi ele alırsak, üzerindeki text'i yazdırabiliriz.

        System.out.println("Category İsimleri:");
        for (WebElement eachElement : categoryElementleriList){ // tüm kategori isimlerini for each ile yazdırırız
            System.out.println(eachElement.getText());
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
