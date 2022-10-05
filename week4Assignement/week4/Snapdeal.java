package assignements.week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			// Entering the amazon URL 
			driver.get("https://www.snapdeal.com/");
			WebElement mensfashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]/ancestor::li"));
			Actions builder = new Actions(driver);
			builder.moveToElement(mensfashion).perform();
			driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
			String titleofthepage = driver.getTitle();
			System.out.println(titleofthepage);
			String countOfShoes = driver.findElement(By.xpath("//span[@class=\"category-name category-count\"]")).getText();
			System.out.println("The total number of shoes present " +countOfShoes);
			driver.findElement(By.xpath("//div[contains(text(), 'Popularity')]/following-sibling::i")).click();
			Thread.sleep(2000);
			List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
			System.out.println("the price list sorted like below");
			for (WebElement i : price) {
				System.out.println(i.getText());	
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class=\"price-text-box\"]/input)[1]")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class=\"price-text-box\"]/input)[1]")).sendKeys("900");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class=\"price-text-box\"]/input)[2]")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class=\"price-text-box\"]/input)[2]")).sendKeys("1200");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),\"GO\")]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@data-displayname='Color']//i[@class='sd-icon sd-icon-plus']")).click();
			driver.findElement(By.xpath("(//*[@data-name='Color_s']//following::button[text()='View More '])[1]")).click();
			driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
			Thread.sleep(3000);
			
			List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']"));
			System.out.println("The applied filters are: ");
			for (WebElement i : filters) {
				System.out.println(i.getText());
			}
			Thread.sleep(3000);
			
			WebElement firstElement = driver.findElement(By.xpath("(//div[@class='col-xs-6  favDp product-tuple-listing js-tuple '])[1]"));
			Actions builder1= new Actions(driver);
			builder1.moveToElement(firstElement).perform();
			driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
			
			Thread.sleep(2000);
			
			String priceoftheelement = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
			System.out.println("The price of the show is " +priceoftheelement);
			String discountpercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
			System.out.println("The discount percentage of the show is " +discountpercentage);
			Thread.sleep(2000);
			
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destination=new File("./snaps/shoes.png");
			FileUtils.copyFile(source, destination);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
			Thread.sleep(2000);
			driver.close();		

	}

}
