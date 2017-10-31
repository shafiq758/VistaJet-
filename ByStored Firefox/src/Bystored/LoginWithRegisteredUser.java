package Bystored;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginWithRegisteredUser extends ServerLoader {
	FourstepsWizard a = new FourstepsWizard();
	
  @Test
  public void LoginBooking() throws InterruptedException, IOException {
	 // a.importfromExcel();
	  a.Step1();
	  a.Step2();
	  Thread.sleep(500);

	    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");

	  driver.findElement(By.xpath(".//*[@id='open-login-popup']")).click();
	  /*WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")));
	  driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
*/
	 
	  
  }
  
  @Test
   public void MakeLogin() throws IOException, InterruptedException{
	  a.importfromExcel();
	
	  
	  
	  String email =  a.sheet.getRow(1).getCell(2).toString();
	  String password =  a.sheet.getRow(1).getCell(4).toString();
	 
	  WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='email']")));
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(".//*[@id='email']")).click();
      System.out.println(password);
	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(email);
	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(Keys.TAB + password);
	  
	 // driver.findElement(By.xpath(".//*[@id='password']")).click();
	  
	  driver.findElement(By.xpath(".//*[@id='login-submit']")).click();
  } 
  @Test
  public void confirmBooking() throws InterruptedException{
	  
	  Thread.sleep(5000);

	  driver.findElement(By.xpath(".//*[@id='cardInfo']/div[3]/div/label/input")).click();
	  driver.findElement(By.xpath(".//*[@id='paynow-wizard']")).click();
	  Thread.sleep(10000);

	  driver.findElement(By.xpath(".//*[@id='paymentFailureModal']/div/div/div[1]/button")).sendKeys("");

	  driver.findElement(By.xpath(".//*[@id='paymentFailureModal']/div/div/div[1]/button")).click();
	  
	  
  }
  
  @Test 
  public void CheckNewPickup() throws InterruptedException
  {
	  
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
	  
	  
  }
}
