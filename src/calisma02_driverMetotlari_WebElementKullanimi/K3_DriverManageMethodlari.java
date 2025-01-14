package calisma02_driverMetotlari_WebElementKullanimi;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class K3_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // HTML kodların daha erişilebilir olması için
        // her class'ın başına mutlaka maximize yaparız
        
        driver.get("https://www.testotomasyonu.com");

        // açılışta window size ve konumu yazdırın
        System.out.println("Açılışta boyut: "+driver.manage().window().getSize()); // Açılışta boyut: (1051, 798)
        System.out.println("Açılışta konum: "+driver.manage().window().getPosition()); // Açılışta konum: (9, 9)
        Thread.sleep(2000); // 2sn bekle

        // window'u maximize yapın
        driver.manage().window().maximize();
        Thread.sleep(2000); // 2sn bekle

        // maximize yaptığımızda size ve konumu yazdırın
        System.out.println("Maximize boyut: "+driver.manage().window().getSize()); // Maximize boyut: (1552, 832)
        System.out.println("Maximize konum: "+driver.manage().window().getPosition()); // Maximize konum: (-8, -8)
        Thread.sleep(2000); // 2sn bekle

        // window'u fullscreen yapın
        driver.manage().window().fullscreen(); // tam ekran
        Thread.sleep(2000); // 2sn bekle

        //istediğimiz konum ve boyuta getirelim
        driver.manage().window().setSize(new Dimension(500,500)); // yeni boyut değerleri
        driver.manage().window().setPosition(new Point(100,100)); // yeni konum değerleri

        // istediğimiz boyutta iken konum ve boyut yazdırın
        System.out.println("İstediğimiz boyutta boyut:" +driver.manage().window().getSize());
        // İstediğimiz boyutta boyut:(516, 503) --> çözünürlüğe göre oynamalar olabilir
        System.out.println("İstediğimiz boyutta konum:" +driver.manage().window().getPosition()); // İstediğimiz boyutta konum:(100, 100)

        Thread.sleep(2000); // 2sn bekle
        driver.quit(); // sayfaları kapat
    }
}
