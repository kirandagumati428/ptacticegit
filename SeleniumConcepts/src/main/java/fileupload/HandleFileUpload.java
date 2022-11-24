package fileupload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFileUpload {

    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.monsterindia.com/seeker/registration");
      
//       try {
//           driver.findElement(By.xpath("//div[@class='btn close-button']")).click();
//           System.out.println("click it");
//       }catch (Exception e) {
//System.out.println("not click");
//       }
       WebElement wb =driver.findElement(By.xpath("//span[text()='Choose CV']"));
       wb.click();
        Thread.sleep(3000);
        
        Robot r=new Robot();
        r.delay(3000);
       StringSelection ss=new StringSelection("C:\\files\\kiran.pdf");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
       
       
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_V);
    
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_V);
    
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    
    }
    

}
