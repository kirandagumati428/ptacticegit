package links;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAndOpenAllLinks {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
WebElement footer=driver.findElement(By.id("gf-BIG"));
System.out.println(footer.findElements(By.tagName("a")).size());
System.out.println(footer.getText());
//Thread.sleep(2000);
WebElement rowfirstfooter=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
System.out.println(rowfirstfooter.findElements(By.tagName("a")).size());
System.out.println(rowfirstfooter.getText());

//click on each link on the column check if the pages are opened or not

for(int i=1;i<rowfirstfooter.findElements(By.tagName("a")).size();i++) {
    
    String clinkoneachlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
    rowfirstfooter.findElements(By.tagName("a")).get(i).sendKeys(clinkoneachlink);
}

//get all the windows tittles
Thread.sleep(6000);
Set<String> handle=driver.getWindowHandles();
Iterator<String> it=handle.iterator();//swith between the windows
while(it.hasNext()) {
    driver.switchTo().window(it.next());
    System.out.println("print the tittles"  +driver.getTitle());
}
//driver.close();
    }

}
