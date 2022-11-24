package Dropdowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSugesstionDropDown {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//span[text()='From']")).click();
      WebElement form=  driver.findElement(By.xpath("//input[@placeholder='From']"));
      form.click();
     // form.clear();
      Thread.sleep(2000);
      form.sendKeys("sydney");
      Thread.sleep(2000);
    form.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
        form.sendKeys(Keys.ENTER); 
        Thread.sleep(2000);
        
    }

}
