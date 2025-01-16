package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03_driverMethods {

    //....Exercise-1:...
    // Create a new class with main method
    // Set Path
    // Create a chrome driver
    // Maximize window
    // Open google home page https://www.google.com
    // On the same class, navigate to wisequarter home page https://www.wisequarter.com and navigate back to google
    // Wait about 4 sn
    // Navigate forward to wisequarter
    // Refresh page
    // Close/quit the browser
    // And Last step print "All is well" on console
    public static void main(String[] args) throws InterruptedException {

        //Ayarları yaptık
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //siteye gittik
        driver.get("https://www.google.com");
        Thread.sleep(1500);

        //wisequarter sitesine "navigate().to" ile gittik
        driver.navigate().to("https://www.wisequarter.com");
        //google'a "navigate().back" ile geri döndük
        driver.navigate().back();

        Thread.sleep(4000);
        //tekrar wisequarter sitesine "forward()" ile gittik
        driver.navigate().forward();
        //sayfa yeniledik
        driver.navigate().refresh();

        //sayfa kapattık
        driver.quit();
        System.err.println("All is well...");
        /*
            System.err.println ve System.out.println farkı;
                System.out.println'de normal çıktı alırken, System.err.println'de hata ve uyarı mesajı şeklinde çıktı alırız.
         */



    }
}
