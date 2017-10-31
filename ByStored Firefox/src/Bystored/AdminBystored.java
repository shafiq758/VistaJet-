package Bystored;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminBystored {
	public static WebDriver driver;
	
	HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
	@BeforeTest
	public void openbrowser() throws MalformedURLException 
	
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\VD\\Desktop\\Gecko\\geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();
	//	options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(); 



	driver.manage().window().maximize(); 
	driver.get("http://qa-admin.bystored.com/#/"); } 

	
	//@BeforeTest
   /* public void beforeWebdriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa-admin.bystored.com/#/");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
	}*/
  @Test
  public void Login() throws IOException {
	   
	  File src=new File("C:\\Users\\VD\\Desktop\\Data.xls");
	  
	        
	  
	       // Load the file.
	  
	       FileInputStream finput = new FileInputStream(src);
	  
	        
	  
	       // Load he workbook.
	  
	      workbook = new HSSFWorkbook(finput);
	  
	        
	  
	       // Load the sheet in which data is stored.
	  
	       sheet= workbook.getSheetAt(0);
	       
	       String name = sheet.getRow(0).getCell(0).toString();
	       String Password = sheet.getRow(0).getCell(1).toString();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("email")).sendKeys(name);
	    driver.findElement(By.id("password")).sendKeys(Password);
	    
	    driver.findElement(By.xpath(".//*[@id='page-content']/div/div[3]/form/div[2]/div/button")).click();

  }
  @Test
  public void updateCustomerProfile() throws InterruptedException{
	  Thread.sleep(50000);
	  
	    driver.findElement(By.xpath(".//*[@id='reactAdmin']/div/div[3]/header/div[2]/button")).click();
	    
	    driver.findElement(By.xpath(".//*[@id='reactAdmin']/div/div[3]/header/div[1]/div[2]/div[1]/a/div/div/a")).click();
	    
		  Thread.sleep(10000);

	    driver.findElement(By.xpath(".//*[@id='page-content']/div/div/div[1]/div/button")).click();
	    driver.findElement(By.xpath(".//*[@id='page-content']/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).click();

	    driver.findElement(By.xpath(".//*[@id='page-content']/div/div/div[2]/div/div[1]/div[2]/div/div[1]")).sendKeys("1841");
		  Thread.sleep(10000);

	    driver.findElement(By.xpath(".//*[@id='page-content']/div/div/div[2]/div/div[2]/div/div/div/div/div[1]")).click();
		  Thread.sleep(5000);

	    
	    driver.findElement(By.xpath(".//*[@id='page-content']/div/div[1]/div[2]/div/button")).click();
	    driver.findElement(By.name("lastName")).clear();

	    driver.findElement(By.name("lastName")).sendKeys("Aziz");
		  Thread.sleep(10000);

	    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	    
	    driver.findElement(By.xpath(".//*[@id='page-content']/div/form/div[4]/button")).click();


	  
	  
  }
}
