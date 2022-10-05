package assignements.week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Entering the amazon URL 
		driver.get("https://www.nykaa.com/");
		Thread.sleep(3000);
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']/a[text()=\"L'Oreal Paris\"]")).click();
		String title = driver.getTitle();
		System.out.println("The title of the page is "+title);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']/following-sibling::span")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Concern']/following::div[@class='css-xdicx1'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Color Protection']/following::div)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		Thread.sleep(1000);
		WebElement selectSize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select sizeofbottle= new Select(selectSize);
		sizeofbottle.selectByVisibleText("175ml");
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']/span[@class='css-1jczs19']")).getText();
		System.out.println("The price of the shampoo is "+price);
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		//driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']//*[local-name()='svg' ]/*[local-name()='path']")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		Thread.sleep(3000);
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='portal-root']//iframe"));
		driver.switchTo().frame(frame1);
		String priceinshoppingbag = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("The grandTotalValue of the shampoo is " +priceinshoppingbag);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		Thread.sleep(2000);
		String grandtotalprice = driver.findElement(By.xpath("//div[text()='Grand Total']//following::span")).getText();
		if (priceinshoppingbag.contains(grandtotalprice)) {
			System.out.println("The total is same");
		}else {
			System.out.println("the total is not same");
		}
		
		driver.quit();
	}

}
