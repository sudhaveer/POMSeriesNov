package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			//co.setPlatformName("linux");
			co.setCapability("enableVNC", true);
			co.setBrowserVersion(prop.getProperty("browserversion"));
			//co.setCapability("se:timeZone","US/Pacific");
			//co.setCapability("se:screenResolution", "1920*1080");
					
		}
				
		return co;
	}
	
	
	
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			fo.setPlatformName("linux");
			fo.setCapability("enableVNC", true);
			//fo.setCapability("se:timeZone","US/Pacific");
			//fo.setCapability("se:screenResolution", "1920*1080");  these are not selenoid properties
			
		}
		return fo;
	}

	
	//selenoid doesnot support edge
	
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) eo.addArguments("--incognito");
		
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			eo.setPlatformName("linux");
			eo.setCapability("enableVNC", true);
			eo.setCapability("se:timeZone","US/Pacific");
			eo.setCapability("se:screenResolution", "1920*1080");
		}
		return eo;
	}
}
