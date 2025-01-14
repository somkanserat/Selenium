package calisma01_WebDriverKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class K1_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

        // Bir test'e baslamadan once MUTLAKA
        // bir WebDriver edinmeliyiz.
        // Javadan yardım alacağız

        System.setProperty("Webdriver.chrome.driver","kurulumDosyasi/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com"); // url'ye gitti.

        Thread.sleep(3000); // 3sn bekledi.

        driver.quit(); // sayfayı kapattı.
    }
}
