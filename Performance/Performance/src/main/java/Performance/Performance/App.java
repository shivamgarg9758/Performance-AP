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
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.id("inputUsername")).sendKeys("approver1@coraapflow.qa");
   
   }
}
