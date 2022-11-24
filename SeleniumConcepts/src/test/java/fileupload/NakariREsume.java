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

public class NakariREsume {

    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.monsterindia.com/seeker/registration");
        //driver.findElement(By.xpath("//span[text()='Choose CV']")).click();
//        Thread.sleep(4000);
//        WebElement browse = driver.findElement(By.xpath("//input[@id='file-upload']"));
//        //click on ‘Choose file’ to upload the desired file
//        browse.sendKeys("C:\\\\files\\\\kiran.pdf"); //Uploading the file using sendKeys
//        System.out.println("File is Uploaded Successfully");
//      
     //   driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\files\\kiran.pdf");
     //using robot class
        
        WebElement button=driver.findElement(By.xpath("//span[text()='Choose CV']"));
        button.click();
        Thread.sleep(3000);
        //robotclass
        Robot r =new Robot();
        r.delay(2000);
        
        StringSelection ss=new StringSelection("C:\\files\\kiran.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        
        //press contol_v for the paste 
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        
        //relase control+v for pasting
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        
        // for pressing and releasing Enter
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

}
