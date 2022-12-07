package com.qa.opencart.base;

import org.testng.annotations.AfterMethod;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Parameters;  
//import com.beust.jcommander.Parameters;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	
	public DriverFactory df;
	
	public LoginPage loginPage;
	public AccountsPage accPage;
	public SearchResultsPage searchResPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage regPage;
	
	public SoftAssert softAssert;
	
	@Parameters({"browser","browserversion"})
	@BeforeTest
	public void setup(String browserName, String browserVersion) {
		df = new DriverFactory();
		
		prop = df.initProp();
		
		
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
		}
		
		
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}