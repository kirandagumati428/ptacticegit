package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDowns {

    public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
//driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.get("https://www.sugarcrm.com/au/request-demo/");
try {
    driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
    System.out.println("click");
}catch (Exception e) {
    System.out.println("not click");
    // TODO: handle exception
}
Select s=new Select(driver.findElement(By.id("how-select")));
//s.selectByValue("YouTube");
Thread.sleep(2000);
s.selectByIndex(5);
Thread.sleep(2000);
//s.selectByVisibleText("Podcast");
    }

}
