package latestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

//import a specific package for relative locators
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\Workspace\\Web Drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        //Relative locator - Above
        System.out.println(driver.findElement(with(By.tagName("Name")).above(nameEditBox)).getText());
        
        //Relative Locator - Below
        WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dob)).click();
        
        //to-Left of
        WebElement iceCreameLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreameLabel)).click();
        
        //to-right of
        WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText());
        //System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText());
	}

}
