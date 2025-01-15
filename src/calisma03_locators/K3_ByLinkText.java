package calisma03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class K3_ByLinkText {

    public static void main(String[] args) throws InterruptedException {
        /*
            1- Bir test class’i olusturun ilgili ayarlari yapin
            2- https://www.automationexercise.com/ adresine gidin
            3- Sayfada 147 adet link bulundugunu test edin.
            4- Products linkine tiklayin
            5- special offer yazisinin gorundugunu test edin
            6- Sayfayi kapatin
         */

        //***1- Bir test class’i olusturun ilgili ayarlari yapin***

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //***2- https://www.automationexercise.com/ adresine gidin***

        driver.get("https://www.automationexercise.com/");

        //***3- Sayfada 147 adet link bulundugunu test edin.***

        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a")); //linkleri, List içerisine kaydettik

        int expectedLinkSayisi = 147; // beklenen link sayısı
        int actualLinkSayisi = linkElementleriList.size(); //  gerçek link sayısı

        if (expectedLinkSayisi == actualLinkSayisi){ // if ile kontrol
            System.out.println("Link sayısı testi PASSED");
        }else {
            System.out.println("Link sayısı testi FAILED");
        }

        //***4- Products linkine tiklayin***

        //driver.findElement(By.linkText(" Products")).click();
        driver.findElement(By.partialLinkText("Products")).click();
        /*
        ******************************************************************
            ****By.linkText ve By.partialLinkText arasındaki fark;****
            By.linkText: Metnin tamamıyla eşleşir.
            By.partialLinkText: Metnin bir kısmıyla eşleşir.
            * Hangi yöntemi seçeceğiniz, test senaryosundaki ihtiyaçlarınıza bağlıdır.
            * Eğer bağlantı metni sabitse ve tam eşleşme gerekiyorsa By.linkText,
            * eğer metnin sadece bir kısmı sabitse veya metin çok uzunsa By.partialLinkText daha uygundur.
        ******************************************************************
         */


        //***5- special offer yazisinin gorundugunu test edin***

        WebElement specialOfferYaziElementi = driver.findElement(By.id("sale_image")); //special offer yazısına sağ click -> incele -> id="sale_image"

        if (specialOfferYaziElementi.isDisplayed()){ // if ile kontrol --> isDisplayed: Web element gorunuyor ise true, yoksa false döner
            System.out.println("Special Offer Yazı Testi PASSED");
        }else {
            System.out.println("Special Offer Yazı Testi FAILED");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
