package Dropdowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {

    public static void main(String[] args) {
 WebDriverManager.chromedriver().setup();
 WebDriver driver= new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
 //using ganaric methods
 
// JavascriptExecutor js=(JavascriptExecutor) driver;
// js.executeAsyncScript("window.scrollBy(0,350)", "");
// 
// Select noofemp=new Select(driver.findElement(By.name("NoOfEmployees")));
// noofemp.selectByValue("21 - 25");
// 
// Select country= new Select(driver.findElement(By.name("Country")));
// country.selectByVisibleText("Angola");
driver.quit();
    }

}
