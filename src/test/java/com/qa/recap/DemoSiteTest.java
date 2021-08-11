package com.qa.recap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.recap.pages.DemoAddPage;
import com.qa.recap.pages.DemoLoginPage;

public class DemoSiteTest {
	
	private WebDriver driver;
	private JavascriptExecutor executor;
	
	private DemoAddPage demoAddPage;
	private DemoLoginPage demoLoginPage;
	
	private String username;
	private String password;
	
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
		
		demoAddPage = PageFactory.initElements(driver, DemoAddPage.class);
		demoLoginPage = PageFactory.initElements(driver, DemoLoginPage.class);
	}
	
	@Test
	public void addUserTest() throws Exception {
		username = "asfsd";
		password = "sadas";
		String success = "**Successful Login**";
		
		driver.get(demoAddPage.URL);
		demoAddPage.enterUsername(username);
		demoAddPage.enterPassword(password);
		Thread.sleep(1000);
		demoAddPage.submit();

		demoAddPage.loginPage();
		
		demoLoginPage.enterUsername(username);
		demoLoginPage.enterPassword(password);
		Thread.sleep(1000);
		demoLoginPage.login();		
		
		assertTrue(demoLoginPage.getSuccess().contains(success));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}