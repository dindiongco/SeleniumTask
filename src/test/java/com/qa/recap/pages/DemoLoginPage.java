package com.qa.recap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLoginPage {
	
	final static String URL = "http://thedemosite.co.uk/login.php";
	
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userName;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passWord;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement loginBtn;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement success;
	
	public DemoLoginPage(WebDriver driver) throws Exception {
		driver.get(URL);
		
		if (!driver.getTitle().equals("Login example page to test the PHP MySQL online system")) throw new IllegalStateException("Site not found");
	}
	
	public DemoLoginPage enterUsername(String username) {
		userName.sendKeys(username);
		
		return this;
	}
	
	public DemoLoginPage enterPassword(String password) {
		passWord.sendKeys(password);
		
		return this;
	}
	
	public DemoLoginPage login() {
		loginBtn.click();
		
		return this;
	}
	
	public String getSuccess() {
		return success.getText();
	}
}

