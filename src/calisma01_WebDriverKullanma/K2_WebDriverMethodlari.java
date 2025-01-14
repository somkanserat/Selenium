package calisma01_WebDriverKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class K2_WebDriverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com"); // istenen url'e gider.
        // www yazmasak da web driver objesi url'e gider
        // https: yazmazsak, istenilen url'e gitmez

        System.out.println(driver.getTitle()); // YouTube
        System.out.println(driver.getCurrentUrl()); // https://www.youtube.com/

        // System.out.println("-----------");
        // System.out.println(driver.getPageSource()); // sayfa kaynağını getirir
        // System.out.println("-----------");


        System.out.println(driver.getWindowHandle()); // 57BA930875ED4F8A2BE4F1BB2F8A18BB
        System.out.println(driver.getWindowHandles()); // [57BA930875ED4F8A2BE4F1BB2F8A18BB]

        // * Webdriver oluşturulan her bir objeye benzersiz (unique) bir Window handle değer atar.
        // * Bir class çalıştığında birden fazla window açılırsa her birinin ayrı bir Window Handle değeri olur.
        // * getWindowHandle(), driver'ın açtığı son window'un window handle değerini verir.
        // * getWindowHandles() ise açılan tüm window'ların, window handle değerini, set olarak verir.
        // * her seferinde yeni değer üretir.
        // * driver'ın, açılan Window'lar arasında geçiş yapabilmesi için geçeceği window'un window handle değerini bilmesi gerekir.


        Thread.sleep(3000);


        driver.quit();// açılan tüm driver'ları kapatır.
        driver.close(); // açılan tek driver'ı kapatır.
    }
}
