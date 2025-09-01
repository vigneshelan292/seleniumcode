package screenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;          // ✅ use this one
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

    public String screen(String testname, WebDriver driver) throws IOException {
        

        // Take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save it to a location
        String destPath = "C:\\Users\\New\\eclipse-workspace\\seleniumcode\\screenshots\\" + testname + ".png";
        File destFile = new File(destPath);
        Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return destPath;
       
    }
    
}