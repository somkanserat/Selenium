package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04_seleniumTest {
    /*
          1-Driver oluşturalim
          2-Java class'imiza chromedriver.exe i tanitalim
          3-Driver'in tum ekranı kaplamasini saglayalim
          4-Driverla sayfanın yuklenmesini 10.000 milisaniye boyunca beklemesini
            söyleyelim. Eger oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
          5-"https://www.testotomasyonu.com" adresine gidelim
          6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
          7-Title'ın Test ve url inin testotomasyonu kelimesini içerip icermedigini kontrol edelim
          8-Ardindan "https://wisequarter.com/" adresine gidip
          9-Bu adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
          10-Bir onceki web sayfamiza geri donelim
          11-Sayfayı yenileyelim
          12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
          13- En son adim olarak butun sayfalarimizi kapatmis olalim
        */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe"); //1
        WebDriver driver = new ChromeDriver(); //2
        driver.manage().window().maximize(); //3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //4

        driver.get("https://www.testotomasyonu.com"); //5-siteye gidelim

        //6- sayfa başlığı ve linkini alalım
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        //7- sayfa title ve linkini kontrol edelim
        String expectedUrl =  "testotomasyonu";
        String expectedTitle = "testotomasyonu";

        if (actualUrl.contains(expectedUrl)){
            System.out.println("TestOtomasyonu Url testi PASSED");
        }else {
            System.out.println("TestOtomasyonu Url testi FAILED");
        }

        if (actualTitle.contains(expectedTitle)){
            System.out.println("TestOtomasyonu Title testi PASSED");
        }else {
            System.out.println("TestOtomasyonu Title testi FAILED");
        }

        //8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");

        //9-Bu adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim

        actualTitle = driver.getTitle();
        expectedTitle = "Quarter";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Wise Title testi PASSED");
        }else {
            System.out.println("Wise Title testi FAILED");
        }

        //10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();

        //11-Sayfayı yenileyelim
        driver.navigate().refresh();

        //12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().forward();
        driver.close();

        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
