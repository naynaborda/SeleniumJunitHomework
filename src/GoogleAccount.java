import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class GoogleAccount {


    WebDriver driver;

    @Before
    public void openBrowser() {
        //9.Creating a google account
        System.setProperty("webdriver.gecko.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\chromedriver.exe");
       // driver = new ChromeDriver();
        driver.get("https://www.google.com/account/about/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void googleAccount() {
        driver.findElement(By.linkText("Create an account")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sita");
        driver.findElement(By.id("lastName")).sendKeys("Ram");
        driver.findElement(By.id("username")).sendKeys("testcase.borda@gmail.com");
        driver.findElement(By.name("Passwd")).sendKeys("Testing1");
        driver.findElement(By.name("ConfirmPasswd")).sendKeys("Testing1");
        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        driver.findElement(By.id("phoneNumberId")).sendKeys("07897143893");
        driver.findElement(By.className("VfPpkd-RLmnJb")).click();
        driver.findElement(By.id("code")).sendKeys("959464");
        driver.findElement(By.className("VfPpkd-RLmnJb")).click();

    }

    @After
    public void closingBrowser() {
        driver.quit();
    }

}


