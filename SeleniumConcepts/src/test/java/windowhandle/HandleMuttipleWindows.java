package windowhandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMuttipleWindows {

    public static void main(String[] args) throws InterruptedException {
       
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        // single window handling
String parenthandle=driver.getWindowHandle();
System.out.println("parentwindow"+parenthandle);
//multiplewindows
        driver.findElement(By.id("newWindowBtn")).click();
        Set<String> windowhandles=driver.getWindowHandles();
        for(String childhandles:windowhandles) {
            System.out.println(childhandles);
            if(!childhandles.equals(parenthandle)) {
                driver.switchTo().window(childhandles);
                driver.findElement(By.id("firstName")).sendKeys("kirankumar");
                Thread.sleep(3000);
                driver.close();
            }
            //driver.switchTo().window(parenthandle);
            driver.findElement(By.id("name")).sendKeys("ram"); 
           
        }
        Thread.sleep(2000);
        //driver.quit();

    }

}
