package links;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinks {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
      List<WebElement> win  =driver.findElements(By.tagName("a"));
      int count =win.size();
      System.out.println(count);
      WebElement footer= driver.findElement(By.id("gf-BIG"));
      System.out.println(  footer.findElements(By.tagName("a")).size());
   WebElement row1   =driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
      System.out.println(row1.findElements(By.tagName("a")).size());
    // System.out.println(row1.getText());
      
      for(int i=1;i<row1.findElements(By.tagName("a")).size();i++) {
        String clicklink=  Keys.chord(Keys.CONTROL,Keys.ENTER);
          row1.findElements(By.tagName("a")).get(i).sendKeys(clicklink);
      }
      //get all tiitles
      Thread.sleep(6000);
      
  Set<String> handletittle   =driver.getWindowHandles();
Iterator<String> w =handletittle.iterator();
while(w.hasNext()) {
  
   driver.switchTo().window(w.next());
   System.out.println(driver.getTitle());
}
    }
    

}
