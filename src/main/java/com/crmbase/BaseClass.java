package com.crmbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crmutil.excelTestData;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
//	public static final String File_Path = "E:\\eclipse-workspace\\crmpractice\\src\\main\\java\\com\\crmtestdata\\";
//	public static final String File_Name = "Testdata.xlsx";
	
	public BaseClass(){
		
		
		
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream("E:/eclipse-workspace/crmpractice/src/main/java/com/crmconfig/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void initialisation() {
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			//	System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
		}
		else if(browser.contentEquals("firefox")){
				System.setProperty("webdriver.gecko.driver", "E:\\drivers\\geckodriver.exe");
			    driver = new FirefoxDriver();
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
	//	excelTestData.setExcelFile(File_Path+File_Name, "Sheet1");
	}

}
