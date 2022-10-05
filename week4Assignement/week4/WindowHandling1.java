package assignements.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		// Launching the browser
		ChromeDriver driver= new ChromeDriver();
		
		// maximize
		driver.manage().window().maximize();
		
		// loading theURL 
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Passing the userName
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//entering password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//clicking on Submit
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//  Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//li/a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> firstWindow=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(firstWindow.get(1));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first')]//a[@class='linktext'])[1]")).click();
		Thread.sleep(2000);			
		
		driver.switchTo().window(firstWindow.get(0));
		
		
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> secondWindow=new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(secondWindow.get(1));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first')]//a[@class='linktext'])[2]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().window(secondWindow.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("The title of the page is verifies as : " +title);
		
		driver.quit();
		
		
	}

}
