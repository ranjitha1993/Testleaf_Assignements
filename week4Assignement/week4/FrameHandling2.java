package assignements.week4;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// validating the click button 
		driver.get("https://www.leafground.com/frame.xhtml");
		System.out.println("Validating the click button");
		WebElement frame1 = driver.findElement(By.xpath("(//h5[contains(text(), 'Click')]/following::iframe)[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//button[@id ='Click']")).getText();
		System.out.println(text);
		
		// Finding the total number of iframe present in the page 
		System.out.println("Finding the number of frame present in the page ");
		driver.switchTo().defaultContent();
		List<WebElement> fr2 = driver.findElements(By.xpath("//iframe"));
		int size = fr2.size();
		System.out.println("The total number of iframe present in the page is " +size);
		
		//Nested Iframe
		driver.switchTo().defaultContent();
		System.out.println("Click Me (Inside Nested frame)");
		WebElement frame3 = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frame3);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		Thread.sleep(2000);
		String response2 = driver.findElement(By.id("Click")).getText();
		System.out.println(response2);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.close();
	}

}
