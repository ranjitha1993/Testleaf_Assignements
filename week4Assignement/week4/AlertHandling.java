package assignements.week4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		// validating the click button 
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
		
		//Alert (Simple Dialog)
		
		driver.findElement(By.xpath("//h5[contains(text(), 'Alert')]/following::span[text()='Show']")).click();
		Thread.sleep(2000);
		Alert alert1= driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println("Simple dialog alert: "+ text1);
		alert1.accept();
		Thread.sleep(2000);
		String finalTxt = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println(finalTxt);
		
		// Alert (Confirm Dialog)
		driver.findElement(By.xpath("//h5[text()= ' Alert (Confirm Dialog)']/following-sibling::button")).click();
		Thread.sleep(2000);
		Alert alert2= driver.switchTo().alert();
		String at2 = alert2.getText();
		System.out.println(at2);
		alert2.accept();
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		
		
		//Sweet Alert
		driver.findElement(By.xpath("//h5[contains(text(), 'Sweet Alert (Simple Dialog)')]/following::span[text()='Show']")).click();
		Thread.sleep(2000);
		String dia = driver.findElement(By.xpath("//span[@id='j_idt88:j_idt96_title']")).getText();
		System.out.println(dia +" opened");
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		System.out.println("Dialog opned and then closed");
		Thread.sleep(2000); 
		
		// Sweet Modal Dialog
		driver.findElement(By.xpath("//h5[text()= 'Sweet Modal Dialog']/following-sibling::button")).click();
		Thread.sleep(2000);
		String title3 = driver.findElement(By.xpath("//span[@id='j_idt88:j_idt101_title']")).getText();
		System.out.println(title3 + " is opened successfully");
		driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following::span")).click();
		Thread.sleep(2000);
		
		
		//Alert (Prompt Dialog)
		driver.findElement(By.xpath("//h5[text()= ' Alert (Prompt Dialog)']/following-sibling::button")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("TestLeaf");
		Thread.sleep(2000);
		alert2.accept();
		Thread.sleep(2000);
		String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text3);
		
		//Sweet Alert (Confirmation)
		driver.findElement(By.xpath("//h5[contains(text(), 'Sweet Alert (Confirmation)')]/following::span[text()='Delete']")).click();
		Thread.sleep(2000);
		String text4 = driver.findElement(By.xpath("//span[@id='j_idt88:j_idt107_title']")).getText();
		System.out.println(text4 +" box opened successfully");
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		Thread.sleep(2000);
		
		//Minimize and Maximize
		driver.findElement(By.xpath("//h5[contains(text(), 'Minimize and Maximize')]/following-sibling::button")).click();
		Thread.sleep(2000);
		String tex = driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content']/p)[3]")).getText();
		System.out.println(tex);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-newwin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Min and Max']/following::span[@class='ui-icon ui-icon-closethick'])[1]")).click();
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
