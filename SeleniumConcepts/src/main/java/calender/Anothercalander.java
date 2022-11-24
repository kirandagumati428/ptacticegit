package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Anothercalander {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application");
        
        driver.findElement(By.xpath("//input[@id='dob']")).click();
        
        Select s=new Select( driver.findElement(By.xpath("//select[@aria-label='Select month']")));
     s.selectByVisibleText("Nov");
     
     Select s1=new Select( driver.findElement(By.xpath("//select[@aria-label='Select year']")));
     s1.selectByVisibleText("1996");
   String date="13";  
  List<WebElement> alldates=   driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
   int count=  alldates.size();
        System.out.println(count);
        Thread.sleep(3000);
        for(WebElement date1:alldates) {
         String w  = date1.getText();
            
            if(w.equalsIgnoreCase(date)) {
               date1.click();
               break;
            }
        }
        
//        WebElement mouth=  driver.findElement(By.xpath("//select[@aria-label='Select month']"));
//        mouth.click();
    }

}
