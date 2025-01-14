package ornekler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ornek01_UrlyeGitme {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyasi/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.trendyol.com/"); // url'ye git.

        Thread.sleep(3000);
        driver.quit();
    }
}
