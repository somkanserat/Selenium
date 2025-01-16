package ornekler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek04_UrunArama {
    public static void main(String[] args) throws InterruptedException {
        /*
            1- https://www.testotomasyonu.com/ sayfasına gidin.
            2- Arama kutusuna “dress” yazip aratin
            3- Görüntülenen sonuçların sayısını yazdırın
            4- Listeden ilk urunun resmine tıklayın.
            5- Urun detayinda dress kelimesi geçtiğini test edin.
         */
        System.setProperty("Webdriver.chrome.driver","kurulumDosyasi/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://www.testotomasyonu.com/ sayfasına gidin.

        driver.get("https://www.testotomasyonu.com/");

        // 2- Arama kutusuna “dress” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
            //öncelikle aramaKutusu adında webElementi oluşturduk. Sitede karşılık gelen xPath değerini referans aldık.
        aramaKutusu.sendKeys("dress"+ Keys.ENTER); // aramaKutusuna dress yazdık ve enter'ladık

        //3- Görüntülenen sonuçların sayısını yazdırın

            //sitede '10 Products Found' şeklinde bir yazı ile karşılaştık. Bu yazıdaki bulunan sayıyı şu şekilde yazdırırız
        WebElement bulunanUrunSayisi = driver.findElement(By.xpath("//*[@class='product-count-text']"));
        String bulunanUrunSayisiStr = bulunanUrunSayisi.getText().replaceAll("\\D","");
            // WebElementi, String haline getirdik. sayıyı yazdırmak istediğimiz için int'e çevirmeye gerek yok.
            // \\D sayesinde, digit olmayan her şeyi, hiçliğe("") çevirdik. Böylece Str içerisinde sadece sayılar kalacak.
            //  integer değere çevirmek istersek Integer.parseInt kullanılabilir.
        System.out.println("Bulunan Ürün Sayısı:"+bulunanUrunSayisiStr);

        // 4- Listeden ilk urunun resmine tıklayın.

        driver.findElement(By.xpath("//*[@href='https://www.testotomasyonu.com/product/51'][1]")).click();
            // *[@href='https://www.testotomasyonu.com/product/51'] --> bu tag'dan 2 tane olduğu için, [1] yazarak
            // html kodları arasında aramayı 1 of 1 yaparak, özelleştiriyorum.

        // 5- Urun detayinda dress kelimesi geçtiğini test edin.

        WebElement arananKelime = driver.findElement(By.xpath("//*[@class='product-short-desc  my-2']"));
        String actualKelime = arananKelime.getText(); // kelimeyi String olarak kaydettik.
        String expectedKelime = "dress"; // beklenen kelime

        if (actualKelime.contains(expectedKelime)){
            System.out.println("'dress' kelime testi PASSED");
        }else {
            System.out.println("'dress' kelime testi FAILED");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
