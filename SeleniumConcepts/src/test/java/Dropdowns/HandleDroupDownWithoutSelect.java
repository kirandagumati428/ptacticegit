package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDroupDownWithoutSelect {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://demo.guru99.com/test/newtours/register.php");

/*WebElement droupdowns=driver.findElement(By.xpath("//select[@name='country']"));


Select drpsele= new Select(droupdowns);
//drpsele.selectByVisibleText("ANGOLA");//take text
//drpsele.selectByValue("AUSTRALIA");//take value
//drpsele.selectByIndex(10);// just assume index start from 0.


//select option from droupdowns without using ganaric methods(select byvisable text,index,value)

List<WebElement>  allelemnts=drpsele.getOptions();
System.out.println(allelemnts.size());
for(WebElement option :allelemnts) {
    if(option.getText().equals("AUSTRALIA")) {
        option.click();
        break;
    }
}*/
//or

/*List<WebElement> allele=driver.findElements(By.xpath("//select[@name='country']/option"));
System.out.println(allele.size());//print size

for(WebElement w:allele) {
    //System.out.println(w.getText());//print all the values
    if(w.getText().equals("ANGOLA")) {
        w.click();
        break;
        //System.out.println(w.getText());
    }
}*/
//or streams


List<WebElement> DropdownElements = driver.findElements(By.xpath("//select[@name='country']/option"));
Thread.sleep(1000);
DropdownElements.stream().filter(s->s.getText().equalsIgnoreCase("ANGOLA")).findAny().get().click();

    
}}

