package calisma02_driverMetotlari_WebElementKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class K4_DriverManageMethodlari {

    public static void main(String[] args) {

        /*
            Test otomasyonu bizim kodlarimizin
            bizim yerimize internette
            Web sayfalarinda islem yapmasidir

            Bizim yazdigimiz Java kodlarinin hizi ile

            1- bilgisayarimiz
            2- internetimiz
            3- ve ulasmaya calistigimiz sayfanin
            hizlari arasinda fark olur.

            Bu hizlar arasindaki fark
            kodlarimizin calisamamasina
            veya testin FAILED olmasina sebep olur
         */

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // tarayıcı penceresini tam ekran yapar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // elementlerin bulunmasını beklemek için genel bir süre tanımlar.

        /*
            Thread.sleep(3000) -> javadan gelir ve mutlak bir bekleme süresidir.
            İçine yazılan süre boyunca kodları bekletir
            ve alt satıra geçmez

            implicitlyWait(Duration.ofSeconds(10)) -> Selenium'dan gelir ve dinamiktir.
            elementlerin bulunmasını beklemek için genel bir süre tanımlar.
            Bulduğu anda işlemi sonlandırır. Bulmazsa exception fırlatır ve çalışmayı durdurur.

         */
    }
}
