package ornekler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Ornek03_KategoriLocateEtme {

    public static void main(String[] args) throws InterruptedException {

        /*
            1- Bir test class’i olusturun ilgili ayarlari yapin
            2- https://www.automationexercise.com/ adresine gidin
            3- Category bolumundeki elementleri locate edin
            4- Category bolumunde 3 element oldugunu test edin
            5- Category isimlerini yazdirin
            6- Sayfayi kapatin
         */

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("Webdriver.chrome.driver","kurulumDosyasi/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin

        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        List<WebElement> kategoriler = driver.findElements(By.xpath("//*[@class='panel panel-default']"));
            //Birden fazla webElement kaydederken "driver.findElements" yazılır. çoğul eki unutulmamalı
        List<String> kategorilerStr = new ArrayList<>();
            //Buradaki String List'i, WebElementleri, String olarak kaydetmek için yazdık.

        for (WebElement kategori : kategoriler){
            // her bir kategoriler elementini, tek bir webElement'te(yani kategori WebElementine) kaydedip,
            // kategori.getText() ile String değer alıp, add komutu ile kategorilerStr List'ine atarız.

            kategorilerStr.add(kategori.getText());
        }

        // 4- Category bolumunde 3 element oldugunu test edin

        int beklenenKategoriElementiSayisi = 3;
        int actualKategoriElementiSayisi = kategorilerStr.size(); // kategorilerStr list'indeki eleman sayısını bize getirecek.

        if(actualKategoriElementiSayisi == beklenenKategoriElementiSayisi){
            System.out.println("Category bölümü element sayısı testi PASSED");
        }else {
            System.out.println("Category bölümü element sayısı testi FAILED");
        }
        Thread.sleep(2000);

        // 5- Category isimlerini yazdirin
        System.out.println("Kategori İsimler:"+kategorilerStr);

        // 6- Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
