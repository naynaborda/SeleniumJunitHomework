import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class YouTube {
    WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void mukeshOtwaniVideo() {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Take screenshot of the failed test");
        driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-searchbox']")).click();
        driver.findElement(By.id("thumbnail")).click();


    }

    @After
    public void closingBrowser() {
        driver.quit();
    }

}
