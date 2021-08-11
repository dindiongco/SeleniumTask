package com.qa.recap;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationTest {
	
	private WebDriver driver;
	private JavascriptExecutor executor;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		executor = (JavascriptExecutor) driver;
		
		Window window = driver.manage().window();
		window.maximize();
		
		Timeouts timeouts = driver.manage().timeouts();
		timeouts.implicitlyWait(Duration.ofSeconds(5)); 
		timeouts.pageLoadTimeout(Duration.ofSeconds(15));
	}
	
//	@Test
//	public void testSelect() throws InterruptedException {
//		Actions action = new Actions(driver);
//		driver.get("http://way2automation.com/way2auto_jquery/selectable.php#load_box");
//		
//		WebElement serialize = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[3]/a"));
//		action.click(serialize);
//		Thread.sleep(500);
//		
//		
//		WebElement selectable = driver.findElement(By.cssSelector("#selectable > li.ui-widget-content.ui-selectee.ui-selected"));	
//		
//		action.click(selectable);
//		
//		action.build()
//				.perform();
//		Thread.sleep(1000);
//		
//	}
	
	@Test
	public void testAlert() throws InterruptedException {
		driver.get("http://way2automation.com/way2auto_jquery/alert.php#load_box");
		

//		Actions actions = new Actions(driver);
//		WebElement alertButton = driver.findElement(By.xpath("/html/body/button"));
		Alert alert = driver.switchTo().alert();
//		actions.click(alertButton);
		Thread.sleep(500);
		alert.accept();
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
