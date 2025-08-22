package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class impliexpli {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));         //Implicit  wait
		driver.get("https://internalqa1euc1.realizeitglobal.com/RealizeitApp/RealizeIt.aspx");
		driver.findElement(By.xpath("(//div[@class='it-flex-row-center-center ng-scope']//a[normalize-space(text())='Log in directly with username'])[1]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("michelle");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qrt$u;>1Lju}94H5S#C,");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));     //Explicit wait
		String s1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Welcome to the Employee Dashboard_test']"))).getText();
		System.out.println(s1);
		driver.close();

	}

}
