package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluecywait {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		WebElement woo=wait.until(new Function<WebDriver,WebElement>(){

		
			public WebElement apply(WebDriver driver) {
				
			WebElement Element= driver.findElement(By.xpath("//h4[text()='Hello World!']"));
				if(Element.isDisplayed()) {
					return Element;
				}else {
					return null;
				}
				
			}
		 
		

	});
		System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText());
	}

}
