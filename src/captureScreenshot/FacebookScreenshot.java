package captureScreenshot;

import Library.Utility;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class FacebookScreenshot
    //this is from Mukesh Otwani's video
{
    WebDriver driver;
    @Test
    public void captureScreenshot()throws Exception
    {

        System.setProperty("webdriver.gecko.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\geckodriver.exe");
         driver=new FirefoxDriver();

        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();
        //we can call captureScreenshot method from utility class if we calling from utility class than we don't need to write screenShot code here
       // Utility.captureScreenshots(driver,"BrowserStarted");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Learn automation");
        //we can call screenshot method whenever we want to take screenshot
       // Utility.captureScreenshots(driver,"Type Email");
       //TakeScreenshot is interface that's why we can not create a object
       //TakesScreenshot ts= (TakesScreenshot)driver;
       //File source= ts.getScreenshotAs(OutputType.FILE);
      // FileUtills.copyFile(source,new File("Path"));
       System.out.println("Screenshot taken");

        driver.quit();
    }
}
