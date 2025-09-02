package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Basetest.base;
import screeenshotforfailed.retry;

public class LoginTest extends base {
   

    @Test(retryAnalyzer=retry.class)
    public void testGoogle() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        assert driver.getTitle().equals("Wrong Title");  // fail purposely
    }
    
    @Test
    public void passtest() {
    	System.out.println("pass this test");
    }
}