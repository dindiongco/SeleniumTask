package com.qa.recap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddPage {
	
	public final String URL = "http://thedemosite.co.uk/addauser.php";
	
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userName;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passWord;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submitBtn;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginPageBtn;
	
	public DemoAddPage(WebDriver driver) throws Exception {
		driver.get(URL);
		
		if (!driver.getTitle().equals("Add a user - FREE PHP code and SQL")) throw new IllegalStateException("Site not found");
	}
	
	public DemoAddPage enterUsername(String username) {
		userName.sendKeys(username);
		
		return this;
	}
	
	public DemoAddPage enterPassword(String password) {
		passWord.sendKeys(password);
		
		return this;
	}
	
	public DemoAddPage submit() {
		submitBtn.click();
		
		return this;
	}
	
	public DemoAddPage loginPage() {
		loginPageBtn.click();
		
		return this;
	}
}