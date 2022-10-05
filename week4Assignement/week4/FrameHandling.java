package assignements.week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//1stframe
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//body/input")).sendKeys("TestLeaf");
		
		System.out.println("The firstFrame was Tested Successfully");
		
		Thread.sleep(2000);
		
		WebElement frame3 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//body/input[@id='a']")).click();
		System.out.println("The checkbox was chekcked");
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		WebElement selectanimal = driver.findElement(By.id("animals"));
		Select ss= new Select(selectanimal);
		ss.selectByValue("babycat");
		Thread.sleep(2000);
		System.out.println("The frame 3 operation was successfull");
		driver.close();
		
	}

}
