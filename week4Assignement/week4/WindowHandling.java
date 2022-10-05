package assignements.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Launching the browser
		ChromeDriver driver= new ChromeDriver();
		
		// maximize
		driver.manage().window().maximize();
		
		// loading theURL 
		driver.get("https://www.leafground.com/window.xhtml");
		Thread.sleep(2000);
		
		//Window Handling
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//div[@class='card']//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		System.out.println("Click and Confirm new Window Opens:");
		driver.switchTo().window(window.get(1));
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("The title of the new tab opened is " +title);
		driver.close();
		
		//Find the number of opened tabs
		driver.switchTo().window(window.get(0));
		System.out.println("Finding the number of opened tabs:");
		driver.findElement(By.xpath("//div[@class='card']//span[text()='Open Multiple']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> window1=new ArrayList<String>(windowHandles1);
		int size = window1.size();
		System.out.println("The number of tabs opened while clicking the buttons are "+(size-1));
		
		//Closethewindow
		driver.switchTo().window(window1.get(0));
		System.out.println("Closing all windows except Primary:");
		driver.findElement(By.xpath("//div[@class='card']//span[text()='Close Windows']")).click();
		Set<String> windowHandle2=driver.getWindowHandles();
		List<String> window2=new ArrayList<String>(windowHandle2);
		int tab = window2.size();
		for(int i=tab-1; i>0 ;i--) {
			driver.switchTo().window(window2.get(i));
			driver.close();
			Thread.sleep(2000);
		}
		System.out.println("All the browswer opened are closed");
		
		//Wait for 2 new tabs to open
		driver.switchTo().window(window2.get(0));
		System.out.println("Waiting for 2 new tabs to open:");
		driver.findElement(By.xpath("//div[@class='card']//span[text()='Open with delay']")).click();
		Thread.sleep(2000);
		Set<String> windowhandle3=driver.getWindowHandles();
		List<String> window3= new ArrayList<String>(windowhandle3);
		int tabs=window3.size();
		if( (tabs-1)==2) {
			System.out.println("The windows launched successfully");
		}
		else
		{
			System.out.println("the windows was not launched successfully");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
