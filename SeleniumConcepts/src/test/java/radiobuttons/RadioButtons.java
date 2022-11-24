package radiobuttons;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
     WebElement radio1=   driver.findElement(By.xpath("//input[@value='radio1']"));
     radio1.click();
     System.out.println(radio1.isSelected());
     WebElement radio2=   driver.findElement(By.xpath("//input[@value='radio2']"));
     radio2.click();
     System.out.println(radio2.isSelected());
     WebElement radio3=   driver.findElement(By.xpath("//input[@value='radio3']"));
     radio3.click();
     System.out.println(radio3.isSelected());
     Thread.sleep(2000);
     driver.close();
    }

}
