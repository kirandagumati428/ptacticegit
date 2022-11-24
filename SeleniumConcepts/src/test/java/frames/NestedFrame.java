package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrame {
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
    WebElement text=driver.findElement(By.className("frmTextBox"));
    text.sendKeys("hello");//main webpage
    Thread.sleep(3000);
    driver.switchTo().frame("frm3");//frame3
    driver.switchTo().frame("frm1");//under frame3 in frame1
    Select s= new Select(driver.findElement(By.id("course")));
    s.selectByValue("java");
    Thread.sleep(3000);
    
    driver.switchTo().parentFrame();//back to  frame3 starting
    WebElement text1=driver.findElement(By.className("frmTextBox"));
    text1.clear();
    Thread.sleep(3000);
    text1.sendKeys("frame3");
    Thread.sleep(3000);
    driver.switchTo().defaultContent();
    WebElement text2=driver.findElement(By.className("frmTextBox"));
    //text1.clear();
    text2.sendKeys("worldjava");
    Thread.sleep(3000);
}
}
