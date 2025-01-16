package ornekler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek08_GoogleArama {

    /*
        Google'da bir arama yapın ve sonuçların doğru olduğunu kontrol edin.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Google'a git
        driver.get("https://www.google.com.tr/");

        //Google arama kutusuna "Fenerbahçe" yaz
        WebElement googleAramaKutusu = driver.findElement(By.xpath("//*[@role='combobox']"));
        googleAramaKutusu.sendKeys("Fenerbahçe"+ Keys.ENTER);
        Thread.sleep(2);

        //Çıkan sonucun sayısını yazdır.
        WebElement araclarTabButonu = driver.findElement(By.xpath("//*[text()='Araçlar']"));
        araclarTabButonu.click();

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("'Fenerbahçe' Arama Sonucu: "+sonucYazisi.getText());
        Thread.sleep(2);

        driver.quit();
    }
}
