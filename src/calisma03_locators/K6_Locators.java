package calisma03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class K6_Locators {

    public static void main(String[] args) throws InterruptedException {
        /*
            1- Bir test class’i olusturun ilgili ayarlari yapin
            2- https://www.testotomasyonu.com/ adresine gidin
            3- Browseri tam sayfa yapin
            4- Sayfayi “refresh” yapin
            5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin.
            6- Furniture linkine tiklayin
            7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
            8- filtreleme sonucunda urun bulunabildigini test edin
            10-Ilk urunu tiklayin
            11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
            12-Sayfayi kapatin
        */
        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/"); //sayfaya git

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedSayfaBaslik = "Test Otomasyonu"; // istenen başlık
        String actualSayfaBaslik = driver.getTitle();   // başlığı string olarak kaydettik

        if (actualSayfaBaslik.contains(expectedSayfaBaslik)){ // if ile kontrol
            System.out.println("Sayfa başlık testi PASSED");
        }else {
            System.out.println("Sayfa başlık testi FAILED");
        }

        //6- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='has-sub'])[5]")).click();
        // linki Xpath ile bulduk ve tıkladık

        /*
            ***NOT**** Bir HTML elementi, açılan sayfada ekranın altında kalıyorsa (görünür değilse),
            o elementi kullanıp kullanamayacağımız, tamamen sayfanın nasıl kodlandığına bağlıdır:

            * Bazı sayfalarda, görünürde olmayan element kullanılabilir,
            * Bazı sayfalarda ise, görünür olmadan o elemente erişim sağlanamaz. Bu yüzden;
                - Elementi kullanmayı dene. Çalışıyorsa sorun yok,
                - Çalışmıyorsa, sayfayı aşağıya kaydır. Aşağıda yazılan kod gibi
        */

        // sayfayı aşağı indiririz.
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        //7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minFiyatKutusu = driver.findElement(By.xpath("//*[@class='form-control minPrice']"));
        //Xpath ile min değeri bulduk ve webElement olarak tanımladık.
        minFiyatKutusu.clear(); // temizleme yaptık.
        minFiyatKutusu.sendKeys("40"); // değeri yazdık

        WebElement maxFiyatKutusu = driver.findElement(By.xpath("//*[@class='form-control maxPrice']"));
        //Xpath ile max değeri bulduk ve webElement olarak tanımladık.
        maxFiyatKutusu.clear(); // temizleme yaptık.
        maxFiyatKutusu.sendKeys("200"); // değeri yazdık

        Thread.sleep(3000); //3sn bekle
        driver.findElement(By.xpath("//*[@*='price-range-button']")).click();
        // "Filter Price" tuşunu Xpath ile bulduk ve tıkladık.

        // *[@id="shopping-info-detail"]/div[2]/div/div[2]/div[3]/button --> Xpath içerisine copy Xpath'deki değer de yazılabilir.
        // bu, incele kısmında otomatik kopyaladığımız Xpath

        //8- filtreleme sonucunda urun bulunabildigini test edin

        WebElement aramaSonucYaziElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        //arama yapıldıktan sonra "... Product Found" yazısını, Xpath ile bulduk ve WebElement olarak atadık.
        String unExpectedYazi = "0 Products Found"; // beklenmeyen yazı
        String actualYazi = aramaSonucYaziElementi.getText(); // gerçekte çıkacak olan yazı

        if (! unExpectedYazi.equals(actualYazi)){ // if ile kontrol (! = değilse ifadesine dikkat edilmeli)
            System.out.println("Filtreleme testi PASSED");
        } else {
            System.out.println("Filtreleme testi FAILED");
        }

        /*  2.YOL
        ---------Burada çıkan yazıyı webElement olarak kaydettik, daha sonra webElement->String->int şeklinde kaydettik
        ve çıkan sonucun 0'dan farklı olup olmadığını if ile kontrol ettik-------------

        WebElement bulunanUrun = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String bulunanUrunStr = bulunanUrun.getText();
        int bulunanUrunSayisi = Integer.parseInt(bulunanUrunStr.replaceAll("\\D",""));

        if (bulunanUrunSayisi>0){
            System.out.println("Ürün bulma testi PASSED");
        }else {
            System.out.println("Ürün bulma testi FAILED");
        }
        */

        // 10-Ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]")).click(); // ilk ürünü Xpath ile bulduk ve tıkladık
        /*
            //*[@id="shopping-list"]/div/ul/li[1]/div/a/img  --> site üzerinden fotoğrafa sağ click
            incele yaptıktan sonra, işaretlenen koda sağ click yapıp, copy üzerinden COPY Xpath aldığımız değerdir.
            By.xpath içerisine bunu yazarsak da kabul edecektir.
        */

        // 11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement ilkUrunFiyatElementi = driver.findElement(By.id("priceproduct")); //Fiyatı webElement olarak kaydettik
        /*
            WebElement ilkUrunFiyatElementi = driver.findElement(By.xpath("//*[@id=\"priceproduct\"]"));
            yine sayfa üzerinden aldığımız Xpath
        */
        String fiyatStr = ilkUrunFiyatElementi.getText(); // String olarak yazdırdık, getText() ile
        fiyatStr = fiyatStr.replaceAll("\\D",""); // sayı hariç tüm elemanları sildik (d:digit, D:digit olamayan)

        double fiyatDbl = Double.parseDouble(fiyatStr)/100; //5000/100=50

        if (fiyatDbl>=40 && fiyatDbl<=200){ //if ile kontrol
            System.out.println("İlk ürün fiyat testi PASSED");
        }else {
            System.out.println("İlk ürün fiyat testi FAILED");
        }

        //12-Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
