package practice.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements {
   
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajeswari V\\Desktop\\Selenium\\practice\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/#");
	   String parentwindow=driver.getWindowHandle();
	   System.out.println(parentwindow);
		WebElement drpdwnlink=driver.findElement(By.xpath("//*[@id=\"nav1\"]/li[3]/a"));
		drpdwnlink.click();
		driver.findElement(By.xpath("//*[@id=\"nav1\"]/li[3]/ul/li[6]/a")).click();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.xpath("//*[@id=\"newWindowBtn\"]")).click();
		Set<String> windowhandles=driver.getWindowHandles();
		for(String handle : windowhandles) {
		System.out.println(handle);
		
		if(!handle.equals(parentwindow))
		   {
			driver.switchTo().window(handle);
			String title=driver.getTitle();
			System.out.println(title);
			driver.findElement(By.id("firstName")).sendKeys("rajeswari");
			Thread.sleep(3000);
			driver.close();
		   }
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("name")).sendKeys("raj");	
		Thread.sleep(2000);
		
		
		}
		
		
	}
  
}
