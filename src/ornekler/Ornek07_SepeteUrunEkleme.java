package ornekler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek07_SepeteUrunEkleme {

    /*
        1. “https://www.saucedemo.com” Adresine gidin
        2. Username kutusuna “standard_user” yazdirin
        3. Password kutusuna “secret_sauce” yazdirin
        4. Login tusuna basin
        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        6. Add to Cart butonuna basin
        7. Alisveris sepetine tiklayin
        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        9. Sayfayi kapatin
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu = driver.findElement(By.xpath("//*[@id='user-name']"));
        usernameKutusu.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu = driver.findElement(By.xpath("//*[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunIsmi = driver.findElement(By.xpath("//*[@id='item_4_title_link']"));
        System.out.println("İlk Ürünün İsmi: "+ilkUrunIsmi.getText());
        Thread.sleep(1500);
        ilkUrunIsmi.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart']")).click();
        Thread.sleep(1500);

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urunNo = driver.findElement(By.xpath("//*[@class='cart_quantity']"));
        String urunNoStr = urunNo.getText();
        int urunNoInt = Integer.parseInt(urunNoStr);

        if (urunNoInt == 1){
            System.out.println("Ürün sepete eklendi.");
        }else {
            System.out.println("Ürün sepete eklenmedi.");
        }

        //9. Sayfayi kapatin
        Thread.sleep(1500);
        driver.quit();

    }
}
