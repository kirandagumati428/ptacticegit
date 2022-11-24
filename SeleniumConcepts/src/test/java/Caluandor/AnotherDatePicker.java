package Caluandor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnotherDatePicker {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application");
        
        driver.findElement(By.xpath("//input[@id='dob']")).click();
        
        
      Select mouth  =new Select (driver.findElement(By.xpath("//select[@aria-label='Select month']")));
      Thread.sleep(3000);
        mouth.selectByVisibleText("Oct");
        Thread.sleep(3000);

        Select year  =new Select (driver.findElement(By.xpath("//select[@aria-label='Select year']")));
        Thread.sleep(3000);

        year.selectByVisibleText("1996");
      //select[@aria-label='Select year']    
        Thread.sleep(3000);

        String date="13";
    List<WebElement> alldates=    driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
    Thread.sleep(3000);

    for(WebElement a:alldates) {
    String dat=a.getText();
    if(dat.equalsIgnoreCase(date)) {
        a.click();
        break;
    
    }
    }

    }
}
