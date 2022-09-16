package assignments.week2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// Delete Lead
		// setting up the webdriver	
		WebDriverManager.chromedriver().setup();
		
		// Launching the browser
		ChromeDriver driver= new ChromeDriver();
		
		// maximize
		driver.manage().window().maximize();
		
		// loading theURL 
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Enter UserName
		WebElement userName=driver.findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys("a");
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//finding captured lead ID
		String LeadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		System.out.println(LeadID);
		//Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Verify title of the page
		String title = driver.getTitle();
		if (title.contains("View Lead"))
		{
			System.out.println("The title is view lead");
		}else
		{
			System.out.println("The title is not view lead");
		}
		
		
	
		Thread.sleep(5000);
		
		//Delete lead
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Delete']")).click();
		
		//Click Find leads button
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//Entering the captured LeadID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID);
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion	
		Thread.sleep(3000);
		String displayMessage = driver.findElement(By.xpath("//div[@id='ext-gen304']//div[@class='x-paging-info']")).getText();
		
		if (displayMessage.contains("No records to display"))
		{
			System.out.println("No records to display");
		}
		else
		{
			System.out.println("Records are not deleted");
		}
		
		//close the browser
		driver.close();
	}

}
