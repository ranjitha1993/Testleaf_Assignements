package assignements.week4;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		//WindowHandling 
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='col-12 col-md-2 col-sm-3']/a[text()='NSE Bulk Deals']")).click();
		Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='table-responsive']//tbody/tr"));
		int rowSize = rows.size();
		List<String> text =new LinkedList<String>();
		
		for (int i=1; i<=rowSize; i++ )
		{
			text.add(driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr[" +i+ "]/td[3]")).getText());
			//System.out.println(text);
		}
		int namesSize = text.size();	
		System.out.println("The number of security names is : "+ namesSize);
		Thread.sleep(2000);
		
		
		driver.close();
		
		//Ensure whether there are duplicate Security names
		Map<String,Integer> map = new TreeMap<String,Integer>(); 		 // Declaring Tree Map
		
		for (String eachItem : text) {
			map.put(eachItem, map.getOrDefault(eachItem, 0)+1);			// Adding the array items to the map along with the count of duplicates
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for (Entry<String, Integer> eachItem : entrySet) {
		System.out.println(eachItem.getKey()+"-->"+eachItem.getValue());   // Print the map as per format
		}
		
		for (Entry<String, Integer> eachItem : entrySet) {
			if(eachItem.getValue()>1)
				{
				System.out.println("There are duplicate security names");
				break;
				}
			else
				{
				System.out.println("There are no duplicate security names");								
				}
		}

	}

}
