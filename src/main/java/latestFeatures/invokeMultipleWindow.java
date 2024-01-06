package latestFeatures;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class invokeMultipleWindow {

	public static void main(String[] args) {
		
		//In the middle of automation if user wants to invoke new browser
		//Scenario - 
		// navigate to a URL given(https://rahulshettyacademy.com/angularpractice/), 
		//Then, Fill the name field with the first course name available at -
		//URL -https://rahulshettyacademy.com/ (Scroll and get the title of first course available)
		
		System.setProperty("webdriver.edge.driver", "D:\\Workspace\\Web Drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/"); //First URL
        
        // Selenium opens a blank window
        driver.switchTo().newWindow(WindowType.WINDOW); //New Window
        //driver.switchTo().newWindow(WindowType.TAB); // New Tabs
        
        //get the Id of parent window and child window
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        
        //Now, Give access to the child window and open the new URL
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");
        
        String corseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
        		.get(1).getText();
        driver.switchTo().window(parentWindowId);
        
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(corseName);
        
	}

}
