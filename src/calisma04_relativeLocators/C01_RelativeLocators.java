package calisma04_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        /*
            1 ) https://testotomasyonu.com/relativeLocators adresine gidin
            2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative locator ile locate edip tiklayin
            3 ) Acilan urunun DSLR Camera oldugunu test edin.
         */

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        // 2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative locator ile locate edip tiklayin

            //3 farklı relative locator ile locate edip tıklayın

                //1-Relative locator'i kullanmak için öncelikle
                  // hedef webelement'e ait bir özelliği bulmamız gerekir.
                  // bunun için locate edecek gibi webelementi inceleyelim
                  // <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
                  // <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
                  //<span>DSLR Camera</span></a>

                //2- Hedef webelementin etrafında kullanabildiğimiz bir webelementi locate edip kaydedelim
        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

                //3- Artık Relative locator ile hedef elementi locate edip kaydedebiliriz
        driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon)).click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin.

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (actualUrunIsmi.contains(expectedUrunIsmi)){
            System.out.println("DSLR camera isim 1. testi PASSED");
        }else {
            System.out.println("DSLR camera isim 1. testi FAILED");
        }

        // 2.olarak Apple kulaklığın sağında diye relative lacotor kullanalım
        driver.get("https://testotomasyonu.com/relativeLocators");
        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(RelativeLocator.with(By.className("overlay")).toRightOf(appleKulaklik)).click();

        //expectedUrunIsmi = "DSLR Camera";
        //actualUrunIsmi = urunIsimElementi.getText();
        //HATA: StaleElementReferenceException
        /* ---------------------------------
            Bir web sayfasındaki elementi locate ettikten sonra
            baska sayfalara gidilip yeniden locate ettiğimiz webelementin olduğu sayfaya dönersek
            driver, daha önceden locate ettiği elementlerin aynı kaldığından emin olmak ister
            bize NoSuchElementException(elementi bulamadım) demez
            onun yerine, StaleElementReferenceException (bu webelementi locate etmiştik ama üstünden çok zaman geçti) diyor
            --------------------------------
         */

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElementi= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR camera isim 2.testi PASSED");
        }else {
            System.out.println("DSLR camera isim 2.testi FAILED");
        }

        //3.olarak Bat kulaklığın altında diye relative locator kullanalım
        driver.get("https://testotomasyonu.com/relativeLocators");
        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(RelativeLocator.with(By.id("pictext7")).below(batKulaklik)).click();

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera isim 3. test PASSED");
        }else {
            System.out.println("Dslr camera isim 3. test FAILED");
        }

        Thread.sleep(3000);
        driver.quit();



    }
}
