package assignements.week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Entering the amazon URL 
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String title = driver.getTitle();
		System.out.println("The title of the page is " +title);
		String key="OnePlus";
		
		List<WebElement> findElements = driver.findElements(By.xpath("(//div[@class='a-section']//span[@class='a-size-medium a-color-base a-text-normal'])"));
		//int size = findElements.size();
		int count=0;
		String price;
		for (WebElement eachElement : findElements) {
			String text = eachElement.getText();
			count++;
			if (text.contains(key)) {
				System.out.println("The onePlus mobile present in the first is " +text);
				price = driver.findElement(By.xpath("(//span[@class='a-price']//span[@class='a-price-whole'])["+count+"]")).getText();
				String customerRating=driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])["+count+"]")).getText();
				System.out.println("The price of your phone is : " +price);
				System.out.println("The cusotmer Rating of your phone is "+customerRating);
				driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])["+count+"]")).click();
				String title2 = driver.getTitle();
				System.out.println(title2);
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> window=new ArrayList<String>(windowHandles);
				driver.switchTo().window(window.get(1));
				Thread.sleep(2000);
				File source = driver.getScreenshotAs(OutputType.FILE);
				File destination=new File("./snaps/sc1.png");
				FileUtils.copyFile(source, destination);
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				Thread.sleep(5000);
				String subtotal = driver.findElement(By.xpath("//span[contains(text(),' Added to Cart')]/following::span[@id='attach-accessory-cart-subtotal']")).getText();
				System.out.println("The subtotal amount in the cart is "+subtotal);
				if (subtotal.contains(price)) {
					System.out.println("The cart total is correct");
				}else {
					System.out.println("The cart total is not correct");
				}
				break;
			}
			else {
				continue;
			}
			
		}
		driver.quit();
	
	}


}
