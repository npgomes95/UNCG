package UNCG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseUNCGENIE {
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
		driver.get("https://banweb.uncg.edu/");
		
		List <WebElement> webpage = driver.findElements(By.className("submenulinktext2"));
		WebElement clickSecureArea = null;
		for(WebElement element :webpage) {
			String list = element.getText();
//			System.out.println(list);
			
			if(list.contains("Enter Secure Area")) {
				clickSecureArea = element;
			}
			
			
		}
		clickSecureArea.click();
		
		Thread.sleep(2000);
		WebElement userID = driver.findElement(By.name("sid"));
		userID.sendKeys("880098004");
		
		WebElement pin = driver.findElement(By.name("PIN"));
		pin.sendKeys("112995");
		pin.submit();
		
		
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
