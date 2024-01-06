package latestFeatures;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class webElementScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "D:\\Workspace\\Eclipse Workspace\\Web Drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");
        String corseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
        		.get(1).getText();
        driver.switchTo().window(parentWindowId);
        
        WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
        nameField.sendKeys(corseName);
        
        //Take Web Element Screenshot
        File file = nameField.getScreenshotAs(OutputType.FILE); //File in Selenium
        FileUtils.copyFile(file, new File("nameField.png")); //Physical File in Project
	}

}
