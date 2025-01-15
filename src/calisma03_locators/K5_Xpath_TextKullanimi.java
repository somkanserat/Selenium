package calisma03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class K5_Xpath_TextKullanimi {

    public static void main(String[] args) throws InterruptedException {

        /*
            1- https://testotomasyonu.com/addremove/ adresine gidin
            2- Add Element butonuna basin
            3- Remove butonu’nun gorunur oldugunu test edin
            4- Remove tusuna basin
            5- “Add/Remove Elements” yazisinin gorunur oldugunu
         */

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/"); //adrese git

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click(); //Xpath ile webelementi bulduk ve tıkladık
        Thread.sleep(2000);//2sn bekle

        // 3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        ////Xpath ile webelementi bulduk ve kaydettik
        Thread.sleep(2000); //2n bekle

        if (removeButton.isDisplayed()){ // if ile kontrol --> isDisplayed: Web element gorunuyor ise true, yoksa false döner
            System.out.println("Remove butonu testi PASSED");
        }else {
            System.out.println("Remove butonu testi FAILED");
        }

        // 4- Remove tusuna basin
        removeButton.click(); // 34.satırda tanımladığımız removeButton webelementine tıkladık

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2[.='Add/Remove Elements']"));
        // yazıyı Xpath ile web element olarak kaydettik

        if (addRemoveYaziElementi.isDisplayed()){ //if ile kontrol
            System.out.println("Add Remove Yazisi görünme testi PASSED");
        }else {
            System.out.println("Add Remove Yazisi görünme testi FAILED");
        }

        Thread.sleep(2000); //2n bekle
        driver.quit(); //sayfaları kapat

    }
}
