package UNCG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseSpartanCard {
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
		
		driver.get("https://spartancard.uncg.edu/onlinemgmt/");
		driver.manage().window().maximize();
		
		WebElement clickSpartanCardOnline = driver.findElement(By.xpath("//button[contains(.,'Enter SpartanCard Online')]"));
		clickSpartanCardOnline.click();
		
		WebElement clickSignIn = driver.findElement(By.id("MainContent_SignInButton"));
		clickSignIn.click();
		
		
		
		WebElement username = driver.findElement(By.id("j_username"));
		username.sendKeys("npgomes");
		
		WebElement password = driver.findElement(By.id("j_password"));
		password.sendKeys("Marylandcolorado");
		
		WebElement submit = driver.findElement(By.name("_eventId_proceed"));
		submit.click();
		
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
