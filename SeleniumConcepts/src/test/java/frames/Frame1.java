package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        WebElement text=driver.findElement(By.className("frmTextBox"));
        text.sendKeys("hello");
        driver.switchTo().frame("frm1");
        Select s= new Select(driver.findElement(By.id("course")));
        s.selectByValue("java");
        driver.switchTo().defaultContent();
        WebElement text1=driver.findElement(By.className("frmTextBox"));
        text.sendKeys("world");
        
        driver.close();
    }

}
