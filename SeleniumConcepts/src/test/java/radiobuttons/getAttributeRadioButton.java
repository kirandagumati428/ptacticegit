package radiobuttons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getAttributeRadioButton {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.echoecho.com/htmlforms10.htm");
        
      
    int count=    driver.findElements(By.xpath("//input[@name='group1']")).size();
    
    for(int i=0;i<count;i++) {
    String text=    driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
    
    if(text.equalsIgnoreCase("Cheese")){
        driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
    }
    }
    driver.close();
    }
    

}
