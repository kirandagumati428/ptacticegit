package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropDowns {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        driver.switchTo().frame("iframeResult");
        Select s=new Select(driver.findElement(By.name("cars")));
     //   Thread.sleep(2000);
        s.selectByIndex(0);
      //  Thread.sleep(2000);
        s.selectByValue("saab");
     //   Thread.sleep(2000);
        s.selectByVisibleText("Opel");
        Thread.sleep(2000);
        s.deselectByIndex(0);
    Thread.sleep(2000);
 List<WebElement> selectitems=s.getAllSelectedOptions();
        System.out.println(selectitems.size());
        for(WebElement we:selectitems) {
            System.out.println("select elements"+we.getText());
        }
        List<WebElement> allcars=s.getOptions();
        System.out.println(allcars.size());
        for(WebElement w:allcars) {
            System.out.println("select elements"+w.getText());
        }
//        s.selectByValue("option1");
//        Thread.sleep(2000);
//       // s.selectByIndex(3);
//        Thread.sleep(2000);
//       
//        Thread.sleep(2000);
//        List<WebElement> allitems1=s.getAllSelectedOptions();
//        System.out.println(allitems1.size());
//        s.deselectAll();
//        WebElement firstoption=s.getFirstSelectedOption();
//        System.out.println(firstoption.getText()   );
//        Thread.sleep(2000);
       driver.close();

    }

}
