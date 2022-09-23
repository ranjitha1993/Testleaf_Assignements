package assignments.week3;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.ajio.com/");
		
		driver.findElement(By.xpath("//div[@class='searchbar-view']//input[@name='searchVal']")).sendKeys("bags",Keys.ENTER);
//		String title = driver.getTitle();
//		
//		if (title.contains("bags"))
//		{
//			System.out.println("The search result was successfull");
//		}
//		else
//		{
//			System.out.println("Please check the result once again");
//		}
		driver.findElement(By.xpath("//input[@id='Men']/following::label[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following::label[1]")).click();
		Thread.sleep(2000);
		String Totalcount = driver.findElement(By.xpath("//div[@class='filter']/div[@class='length']")).getText();
		System.out.println(Totalcount);
		
		System.out.println("List of Brands");
		List<WebElement> brand=driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println(brand.size());
		
		// Get the list of names of the bags and print it
		
		List<WebElement> bagnamelist=driver.findElements(By.xpath("//div[@class='nameCls']"));
		System.out.println("Size :" + bagnamelist.size());
		System.out.println(" Names of the Bags");
		for (WebElement webElement : bagnamelist) {
			String text = webElement.getText();
			System.out.println(text);
		}
		driver.close();	

	}

}
