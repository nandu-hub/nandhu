package com.base1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase1 {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICT_WAIT=20;
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase1() throws IOException
	{
		prop = new Properties();
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"/src/com/config1/config.properties1");
		prop.load(fin);
		
		
	}
	public static void initiliazation()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pnandu\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		
	}
}
