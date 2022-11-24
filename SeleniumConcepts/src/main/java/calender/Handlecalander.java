package calender;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlecalander {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.redbus.in");
        String mouth="jan",year="2023",date="12";
        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
        
        while(true) {
    String text =   driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
    System.out.println(text);
    
  String arr[]=  text.split("");
  String mou =arr[0];
  String yea =arr[1];
  
  if(mou.equalsIgnoreCase(mouth)&&(yea.equalsIgnoreCase(year)))
     
      break;
  else 
      driver.findElement(By.xpath("//td[@class='next']")).click();
  }
    
 List<WebElement> date1  =driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
 
 for(WebElement w:date1) {
  String textdate=   w.getText();
 
     if(textdate.equalsIgnoreCase(date)) {
         
         w.click();
         break;
     }
     }
 }
    
    
}