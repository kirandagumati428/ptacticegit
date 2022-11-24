package windows;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {

    public static void main(String[] args) throws InterruptedException {
   WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().deleteAllCookies();
   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
   
   String parantwindow=driver.getWindowHandle();
System.out.println(parantwindow);
//driver.findElement(By.id("name")).sendKeys("ravi");
driver.findElement(By.id("newWindowBtn")).click();
Set<String> handlewins=driver.getWindowHandles();

for(String childwins:handlewins) {
    System.out.println(childwins);
    if(!childwins.equalsIgnoreCase(parantwindow)) {
        driver.switchTo().window(childwins);
        driver.findElement(By.id("firstName")).sendKeys("kiran");
        Thread.sleep(3000);
        driver.close();
    }
    driver.findElement(By.id("name")).sendKeys("kumar");
}
driver.close();
    }

}
