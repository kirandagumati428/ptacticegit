package Caluandor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalanderRedbus {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.redbus.in");
        String year="2023",mouth="july",date="10";
       driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
       while(true) {
           String mouthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
           System.out.println(mouthyear);
           
           String arr[]=mouthyear.split(" ");
          String mou=arr[0];
          String yer=arr[1];
           if(mou.equalsIgnoreCase(mouth)&&(yer.equalsIgnoreCase(year)))
               break;
           
           else 
               
           driver.findElement(By.xpath(" //td[@class='next']")).click();
        }
           //dateselection
       
   List<WebElement> alldates   =driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
       int count=alldates.size();
       
       for(WebElement w:alldates) {
        String dat   =w.getText();
        
        if(dat.equalsIgnoreCase(date)) {
            w.click();
            break;
        }
       }
       }
       
       
        }
    


