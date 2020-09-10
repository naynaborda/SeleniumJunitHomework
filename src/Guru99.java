import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Guru99 {
    //4.login successfully in guru99
    WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void logIn() {
        DateFormat dateFormat = new SimpleDateFormat("HH.mm.ss");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        String email = "sitaram" + date1 + "@gmail.com";
        String userId = "mngr283833";
        String password = "gubudYh";
        driver.findElement(By.name("emailid")).sendKeys(email);
        driver.findElement(By.name("btnLogin")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Bank Project')]")).click();
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        //to verify login successful assert text Gtpl Bank
        String expectedText = "Gtpl Bank";
        String actualText = driver.findElement(By.xpath("//h2[@class='barone']")).getText();
        Assert.assertEquals("Log in successfully", expectedText, actualText);

    }

    @After
    public void closingBrowser() {
        driver.quit();
    }

}


