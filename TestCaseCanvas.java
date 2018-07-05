package UNCG;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseCanvas {
public static void main(String [] args) throws InterruptedException {
	String os = System.getProperty("os.name").toLowerCase();
	//implements google chrome
	
	
	//if its mac or windows
	if(os.contains("mac")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
	}else {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver();

    

	driver.get("http://www.uncg.edu/"); 
	driver.manage().window().fullscreen();
	
	
	List <WebElement> Canvas = driver.findElements(By.cssSelector("a[href^='https://uncg.instructure.com/"));
	Canvas.get(0).click();
	
	WebElement username = driver.findElement(By.id("j_username"));
	username.sendKeys("npgomes");
	
	WebElement password = driver.findElement(By.id("j_password"));
	password.sendKeys("Marylandcolorado");
	
	WebElement submit = driver.findElement(By.name("_eventId_proceed"));
	submit.click();
	Thread.sleep(1000);
	
	//image click
	WebElement click = driver.findElement(By.xpath("//img[@ src='https://uncg.instructure.com/images/messages/avatar-50.png']"));
	click.click();
	Thread.sleep(1000);
	
	//Logging Out 
	List <WebElement> clickLogOut = driver.findElements(By.className("_2CUXt80"));	
	WebElement  logOut= null;
	for(WebElement Click: clickLogOut) {
		String List = Click.getText();
		//System.out.println(List);
		
		if(List.contains("Logout")) {
			logOut = Click;
			
		}
		
	}
	logOut.click();
	
	
	
	Thread.sleep(2000);
	driver.quit();
}
}
