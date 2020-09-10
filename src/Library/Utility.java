package Library;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Utility {
    public static  void captureScreenshots(WebDriver driver,String screenshotName){
        try {
            //TakeScreenshot is interface that's why we can not create a object
            TakesScreenshot ts= (TakesScreenshot)driver;
            File source= ts.getScreenshotAs(OutputType.FILE);
            // FileUtills.copyFile(source,new File("Path"));
            System.out.println("Screenshot taken");

        }catch (Exception e){
            System.out.println("Exception while taking screenshot"+ e.getMessage());

        }


    }
}
