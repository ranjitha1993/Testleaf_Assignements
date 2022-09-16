package assignments.week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
				// EditLead
		
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
				driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys("Meenakshi");
				
				//Click Find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				Thread.sleep(5000);
				
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
				
				//Click Edit
				String companyName="Test";
				driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
				
				//Change the company name
				driver.findElement(By.xpath("//div[@class='fieldgroup-body']//input[@name='companyName']")).clear();
				driver.findElement(By.xpath("//div[@class='fieldgroup-body']//input[@name='companyName']")).sendKeys(companyName);
				
				//Click Update
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				
				//Confirm the changed name appears
				String  text= driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
				if(text.contains(companyName))
				{
					System.out.println("The changes appears");
				}
				else
				{
					System.out.println("The changes are invalid");
				}
				
				//Close the browser (Do not log out)
				driver.close();
				}
	}
