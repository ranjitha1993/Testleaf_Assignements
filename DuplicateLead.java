package assignments.week2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// Launching the browser
		ChromeDriver driver= new ChromeDriver();
		// maximize
		
		driver.manage().window().maximize();
		// loading theURL 
		driver.get("http://leaftaps.com/opentaps/control/main");
		WebElement userName=driver.findElement(By.id("username"));
		userName.sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ranjitha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("P");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ranjitha");
		driver.findElement(By.name("departmentName")).sendKeys("Selenium");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Hi this is my first selenium code");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("raksha.216@gmail.com");
		
		WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ss= new Select(state);
		ss.selectByValue("NY");
		
		
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testpage");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ranji");
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		String title1 = driver.getTitle();
		if(title1.contains("View Lead"))
		{
			System.out.println("the test case is pass");
		}else
		{
			System.out.println("thetest case fail ");
		}
	}

}
