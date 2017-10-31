package Bystored;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FourstepsWizard extends ServerLoader {
 

	HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;

	 public String importfromExcel() throws IOException{
		 
		 File src=new File("C:\\Users\\VD\\Desktop\\Data.xls");
		  
	     
		  
	     // Load the file.

	     FileInputStream finput = new FileInputStream(src);

	      

	     // Load he workbook.

	    workbook = new HSSFWorkbook(finput);

	      

	     // Load the sheet in which data is stored.

	     sheet= workbook.getSheetAt(1);
	     String sheet1= sheet.toString();
		return sheet1;
		 
	 }


	//@BeforeMethod defines this method has to run before every @Test methods 
	//@BeforeTest
	
	@Test 
	
	public void Step1() throws InterruptedException 
	{ 
//	String title = driver.getTitle();
	//System.out.print("Current page title is : "+title); 
	//System.out.print("\n'TestNGOne -> TestNGOnePack -> ClassOne -> testmethodone' has been executed successfully"); 
    //driver.findElement(By.xpath(".//*[@id='LandingDesktop']/div/div/div[2]/div/div[2]/a")).click();	
	driver.findElement(By.id("LandingDesktop")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
    driver.findElement(By.xpath(".//*[@id='need-packing-assistance']/li[2]/ul/li[2]")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    driver.findElement(By.id("step1-submit")).click();
    
    // Step 1 Completed
	}
	@Test 
	public void Step2() throws InterruptedException, IOException 
	{ 
		//String title = driver.getTitle();
		//System.out.print("Current page title is : "+title); 
		//System.out.print("\n'TestNGOne -> TestNGOnePack -> ClassOne -> testmethodone' has been executed successfully"); 
    
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
    String coder= importfromExcel();
    //System.out.println("The sheet has" + coder);
    String code = sheet.getRow(0).getCell(0).toString();

    driver.findElement(By.id("postcode")).sendKeys(code);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.id("selected-parking")).click();
    
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
    //((JavascriptExecutor)driver).executeScript("scroll(0,400)");

    driver.findElement(By.xpath(".//*[@id='postCodeForm']/div/div[2]/div[3]/div[1]/ul/li[2]")).click();
    
    driver.findElement(By.id("selected-floor")).click();
    driver.findElement(By.xpath(".//*[@id='postCodeForm']/div/div[2]/div[3]/div[2]/ul/li[3]")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
Thread.sleep(5000);
    ((JavascriptExecutor)driver).executeScript("scroll(0,-1000)");
    ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
   // driver.findElement(By.className("ui-datepicker-next ui-corner-all ui-state-hover ui-datepicker-next-hover")).click();
    //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
   // driver.findElement(By.xpath(".//*[@id='datepicker']/div/table/tbody/tr[4]/td[2]/a")).click();
    driver.findElement(By.className("hasDatepicker")).isDisplayed();
	//driver.findElement(By.xpath("//*[@data-handler='selectDay']"));
	//driver.findElements(By.xpath(".//*[@class='ui-state-default']")).size();
	driver.findElement(By.xpath(".//*[@id='datepicker']/div/div/a[2]/span")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.xpath(".//*[@id='datepicker']/div/table/tbody/tr[2]/td[5]")).click();
Thread.sleep(5000);
if (driver.findElement(By.xpath("//input[@value=1]")).getAttribute("disabled")=="disabled"){
	WebElement element=	driver.findElement(By.xpath("//input[@value=1]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
	System.out.println("Value 1");
} 

else if (driver.findElement(By.xpath("//input[@value=2]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=2]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
	System.out.println("Value 2");
} 
else if (driver.findElement(By.xpath("//input[@value=3]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=3]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
	System.out.println("Value 3");
} 

else if (driver.findElement(By.xpath("//input[@value=4]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=4]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
	System.out.println("Value 4");
} 

else if (driver.findElement(By.xpath("//input[@value=5]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=5]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
	System.out.println("Value 5");
} 

else if (driver.findElement(By.xpath("//input[@value=6]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=6]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 

else if (driver.findElement(By.xpath("//input[@value=7]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=7]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 

else if (driver.findElement(By.xpath("//input[@value=8]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=8]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 
else if (driver.findElement(By.xpath("//input[@value=9]")).isEnabled()){
	
WebElement element=	driver.findElement(By.xpath("//input[@value=9]"));
((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
element.click();

	}
else if (driver.findElement(By.xpath("//input[@value=10]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=10]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 
   
else if (driver.findElement(By.xpath("//input[@value=11]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=11]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 

else if (driver.findElement(By.xpath("//input[@value=12]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=12]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 
else if (driver.findElement(By.xpath("//input[@value=13]")).isDisplayed()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=13]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 
else if (driver.findElement(By.xpath("//input[@value=14]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=14]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 

else if (driver.findElement(By.xpath("//input[@value=15]")).isEnabled()){
	WebElement element=	driver.findElement(By.xpath("//input[@value=15]"));
	((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().x+")");
	element.click();
} 
else {System.out.println("Kuch Ni hoga tmse");}
driver.findElement(By.id("step2-submit")).click();

	//Step 2 Completed
}
	@Test
	public void Step3() throws InterruptedException, IOException 
	{ 
	//	String title = driver.getTitle();
		//System.out.print("Current page title is : "+title); 
		//System.out.print("\n'TestNGOne -> TestNGOnePack -> ClassOne -> testmethodone' has been executed successfully"); 
    
Thread.sleep(500);
((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
importfromExcel();
Boolean isPresent1=true;
int i=1;
do{
	//isPresent1=false;
//	Thread.sleep(1000);
	driver.findElement(By.id("user-firstname")).clear();
	driver.findElement(By.id("user-lastname")).clear();
	driver.findElement(By.id("user-email")).clear();
	driver.findElement(By.id("user-phone")).clear();
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.xpath(".//*[@id='user-passwordrepeat']/input")).clear();
String name = sheet.getRow(i).getCell(0).toString();
String 	Lname = sheet.getRow(i).getCell(1).toString();
String email = sheet.getRow(i).getCell(2).toString();
String  Pno = sheet.getRow(i).getCell(3).toString();
//String Pno1= Integer.toString(Pno);
String pass = sheet.getRow(i).getCell(4).toString();
String Repass = sheet.getRow(i).getCell(5).toString();

driver.findElement(By.id("user-firstname")).sendKeys(name);
driver.findElement(By.id("user-lastname")).sendKeys(Lname);
driver.findElement(By.id("user-email")).sendKeys(email);
driver.findElement(By.id("user-phone")).sendKeys(Pno);
driver.findElement(By.id("password")).sendKeys(pass);
driver.findElement(By.xpath(".//*[@id='user-passwordrepeat']/input")).sendKeys(Repass);
driver.findElement(By.id("step3-submit")).click();
/*if (i==2)
	isPresent1=false;

// isPresent1 = driver.findElements(By.xpath(".//*[@id='registerForm']/label[contains(text(),'That email address is already registered.')]")).size() > 0;
//isPresent1=isPresent;
*/
i++;
Thread.sleep(10000);
String URL = driver.getCurrentUrl();
//Assert.assertEquals(URL, "http://dev.bystored.com/start-storing#step/4" );
System.out.println(URL);
String DURL="http://qa.bystored.com/start-storing#step/4";
   if (URL.equals(DURL)){
	System.out.println("Agaya hai andar");
isPresent1=false;	
System.out.println(isPresent1);
//driver.navigate().refresh();
}

System.out.println(isPresent1);
}while (isPresent1==true);

//Assert.assertFalse(true , "User Already Registered");
// Step 3 Done
}
	@Test
	public void Step4() throws IOException, InterruptedException 
	{ 
		importfromExcel();
	//	Thread.sleep(1000);
	//	String title = driver.getTitle();
		//System.out.print("Current page title is : "+title); 
		//System.out.print("\n'TestNGOne -> TestNGOnePack -> ClassOne -> testmethodone' has been executed successfully"); 
    
Thread.sleep(5000);

		 String card = sheet.getRow(7).getCell(0).toString();
		 String cardnum=sheet.getRow(7).getCell(1).toString();
		 String expiry=sheet.getRow(7).getCell(2).toString();
		 String CVV= sheet.getRow(7).getCell(3).toString();
driver.findElement(By.id("card_name")).sendKeys(card);
driver.findElement(By.id("card_number")).sendKeys(cardnum);
driver.findElement(By.id("expiry")).sendKeys(expiry);
driver.findElement(By.id("cvv")).sendKeys(CVV);
((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
//Thread.sleep(500);
driver.findElement(By.xpath(".//*[@id='cardInfo']/div[3]/div/label/input")).click();
driver.findElement(By.xpath(".//*[@id='paynow-wizard']")).click();
Thread.sleep(15000);
//driver.findElement(By.xpath(".//*[@id='paymentSuccessModal']/div/div/div[1]/button")).click();
 //driver.findElement(By.xpath(".//*[@id='paymentSuccessModal']/div/div/div[1]/button/span[1]")).click();
/*JavascriptExecutor javascript = (JavascriptExecutor) driver;
String toenable = "document.getElementsByXpath('.//*[@id='paymentSuccessModal']/div/div/div[1]/button')[0].removeAttribute('disabled');";
System.out.println("Yes this is the value"+toenable);
javascript.executeScript(toenable);
Thread.sleep(3000);
*/

//driver.findElement(By.xpath(".//*[@id='paymentSuccessModal']/div/div/div[1]/button/span[1] [starts-with(@aria-label, 'x']")).click();
driver.findElement(By.xpath(".//*[@id='paymentSuccessModal']/div/div/div[1]/button")).sendKeys("");
driver.findElement(By.xpath(".//*[@id='paymentSuccessModal']/div/div/div[1]/button")).click();

//Step 4 Done

}
}
