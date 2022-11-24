package windows;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleTabs {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    String parantwin    =driver.getWindowHandle();
System.out.println(parantwin);

driver.findElement(By.id("newTabBtn")).click();
Set<String> handletads=driver.getWindowHandles();

for(String childwin:handletads) {
    if(!childwin.equalsIgnoreCase(parantwin)) {
        driver.switchTo().window(childwin);
       System.out.println(childwin);
        driver.findElement(By.id("alertBox")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.close();
    }  
        //or
//     Iterator<String> id  =handletads.iterator();
//    String par =id.next();
//   String chi =id.next();
//   driver.switchTo().window(chi);
//    System.out.println(driver.getTitle());    
//        
    
   // driver.findElement(By.id("name")).sendKeys("ok");
}
    }

}
