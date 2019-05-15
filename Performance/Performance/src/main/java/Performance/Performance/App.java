package Performance.Performance;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

/**
 * Hello world!
 *
 */
public class App extends commonFunctions
{
	
   @Test
   public void createInvoice() throws InterruptedException {
	   System.setProperty("webdriver.chrome.driver", "D:\\Performance AP\\Performance\\driver\\Chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://coraap-qa.herokuapp.com/");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.id("inputUsername")).sendKeys("approver1@coraapflow.qa");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.id("inputPassword")).sendKeys("cora@123");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//button[@class = 'slds-button slds-button--brand']")).click();
	   Thread.sleep(20000);
	   driver.findElement(By.xpath("(//li[@class = 'slds-context-bar__item ng-scope'])[1]")).click();
	   Thread.sleep(6000);
	   driver.findElement(By.xpath("(//div[@class = 'slds-button-group']/button)[1]")).click();
	   Thread.sleep(4000);
	   Select se = new Select(driver.findElement(By.id("CoraAP__Document_Type__c0")));
	   se.selectByIndex(1);
	   Thread.sleep(4000);
	   Select se1 = new Select(driver.findElement(By.id("CoraAP__Invoice_Type__c0")));
	   se1.selectByIndex(1);
	   Thread.sleep(4000);
	   String random = randomAlphaNumeric(7);
	   driver.findElement(By.id("CoraAP__Invoice_No__c1")).sendKeys(random);
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   Select se2 = new Select(driver.findElement(By.id("CoraAP__Heroku_User_Action__c0")));
	   se2.selectByIndex(1);
	   Thread.sleep(4000);
	   Select se3 = new Select(driver.findElement(By.id("CoraAP__Heroku_User_Action__c0")));
	   se3.selectByIndex(1);
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("(//input[@label = 'Date Picker Label'])[1]")).click();
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/sobject-layout-section[1]/div/div[2]/div[2]/div/div[3]/form/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/span")).click();
	   Thread.sleep(4000); 
	   driver.findElement(By.xpath("//span[@class = 'slds-checkbox--faux']")).click();
	   Thread.sleep(6000);
	   driver.findElement(By.xpath("(//span[contains(text(), 'Add')])[2]")).click();
	   Upload_docs_WithoutWait("D:\\Test.pdf");
	   Thread.sleep(4000); 
	   driver.findElement(By.xpath("//button[@ng-show = '!file.isPersisted']/*[name() = 'svg']")).click();
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("(//button[@ng-click='close()'])[1]")).click();
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("//button[@ng-click = 'save()']")).click();
	   Thread.sleep(4000);
	   driver.findElement(By.id("CoraAP__Invoice_No__c2")).sendKeys(random);
	   Thread.sleep(8000);
	   driver.findElement(By.xpath("(//button[@ng-click = 'search(1,pageSize)'])[2]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("(//button[@ng-click = 'search(1,pageSize)'])[2]/*[name() = 'svg']")).click();
	   Thread.sleep(4000);
	   if (driver.findElement(By.xpath("//td[@title = 'Test.PDF']")).isDisplayed()) {
		  boolean flg = true;
		   Assert.assertEquals(true, flg);
	   }
	   
   }
}
