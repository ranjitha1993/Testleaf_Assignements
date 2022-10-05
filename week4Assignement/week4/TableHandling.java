package assignements.week4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		Thread.sleep(2000);
		List<WebElement> rowvalue = driver.findElements(By.xpath("//div[@class='render']//tbody/tr"));
		int rowsize = rowvalue.size();
		System.out.println("The total row size is "+rowsize);
		
		List<WebElement> cols = driver.findElements(By.xpath("//div[@class='render']/table/thead//th"));
		int colSize = cols.size();
		System.out.println("The count of the number of columns is : "+ colSize);
		
		driver.close();

	}

}
