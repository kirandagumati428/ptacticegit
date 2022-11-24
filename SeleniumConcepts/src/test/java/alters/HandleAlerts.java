package alters;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.findElement(By.id("alertBox")).click();
//        Alert simplealert = driver.switchTo().alert();
//        System.out.println(simplealert.getText());
//        // Thread.sleep(3000);
//        simplealert.accept();
//        // Thread.sleep(3000);
//        // confirm alert

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmBox")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("promptBox")).click();
        
        Thread.sleep(3000);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("fghrdgdd");
        driver.switchTo().alert().accept();

//        Alert confirmAlert = driver.switchTo().alert();
//        System.out.println(confirmAlert.getText());
//        // Thread.sleep(3000); Alert confirmAlert = driver.switchTo().alert();
//        System.out.println(confirmAlert.getText());
//        // Thread.sleep(3000);
//        confirmAlert.accept();
//        // Thread.sleep(3000);
//        // promptalert
//       
//        
//        Alert promtalert = driver.switchTo().alert();
//        System.out.println(promtalert.getText());
//        Thread.sleep(2000);
//
//        promtalert.sendKeys("kirankumar");
////Thread.sleep(3000);
//        promtalert.accept();
//        System.out.println(driver.findElement(By.id("output")).getText());
//        confirmAlert.accept();
//        // Thread.sleep(3000);
//        // promptalert
//       
//        
//        Alert promtalert = driver.switchTo().alert();
//        System.out.println(promtalert.getText());
//        Thread.sleep(2000);
//
//        promtalert.sendKeys("kirankumar");
////Thread.sleep(3000);
//        promtalert.accept();
//        System.out.println(driver.findElement(By.id("output")).getText());
        driver.quit();
    }
}
