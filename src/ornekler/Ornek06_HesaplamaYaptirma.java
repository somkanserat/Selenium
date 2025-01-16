package ornekler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Ornek06_HesaplamaYaptirma {

    /* Exercise3... */
    // https://testpages.herokuapp.com/styled/index.html adresine gidin
    // Calculater altında Micro Apps 'ın altındaki Calculater'e tıklayın
    // İlk kutucuğa herhangi bir sayı yazın
    // İkinci kutucuğa herhangi bir sayı yazın
    // Calculate'e tıklayın
    // Sonucu alın
    // Sonucu yazdırın

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyasi/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //sayfayı aşağı kaydırdık
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        //calculator'a tıkladık
        driver.findElement(By.xpath("//*[@id='calculatetest']")).click();

        Thread.sleep(1000);
        WebElement soldakiKutucuk = driver.findElement(By.xpath("//*[@id='number1']"));
            //soldaki kutucuğu Webelement olarak kaydettik
        soldakiKutucuk.sendKeys("10"); // değer girdik

        Thread.sleep(1000);
        WebElement sagdakiKutucuk = driver.findElement(By.xpath("//*[@id='number2']"));
            //sağdaki kutucuğu Webelement olarak kaydettik
        sagdakiKutucuk.sendKeys("15");// değer girdik

        Thread.sleep(1000);
        // Calculate'e tıklayın
        driver.findElement(By.xpath("//*[@id='calculate']")).click();

        WebElement answer = driver.findElement(By.xpath("//*[@id='answer']"));
        String answerStr = answer.getText();
        System.out.println("Çıkan sonuç:"+answerStr);

    }
}
