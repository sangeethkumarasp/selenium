package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.IO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.util.Uilityy;

public class Baseclas {
	
	public static WebDriver driver;
public 	static Properties prop;
	public Baseclas()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void initialization()
	{
		String browsname=prop.getProperty("browser");
		if(browsname.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sangeeth\\Downloads\\selenium\\chromedriver.exe");
			// Create object of ChromeOptions class
			ChromeOptions options = new ChromeOptions();

			// add parameter which will disable the extension
			options.addArguments("--disable-extensions");

			// Start the chrome session
			 driver = new ChromeDriver(options);
			
			
		}else if(browsname.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.geckodriver","C:\\Users\\sangeeth\\Downloads\\selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		else if(browsname.equalsIgnoreCase("IE"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			System.setProperty("webdriver.ie.driver","C:\\Users\\sangeeth\\Downloads\\selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Uilityy.pageload_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Uilityy.implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
