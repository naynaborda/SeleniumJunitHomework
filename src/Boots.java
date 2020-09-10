import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Boots {
    WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.boots.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void medicineShopping() {
        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //find WebElement 'Shop by department' to perform mouse hover
        WebElement target = driver.findElement(By.linkText("Shop by department"));
        //Mouse hover 'Shop by department'
        actions.moveToElement(target).build().perform();
        //find WebElement 'health & Pharmacy' to perform mouse hover
        WebElement subTarget = driver.findElement(By.linkText("health & pharmacy"));
        //Mouse hover 'health and pharmacy'
        actions.moveToElement(subTarget).build().perform();
        //find WebElement 'medicines & treatments' to perform mouse hover
        WebElement subTarget1 = driver.findElement(By.linkText("medicines & treatments"));
        //Mouse hover 'medicines & treatments'
        actions.moveToElement(subTarget1).build().perform();
        //find WebElement 'pain'
        WebElement selectTarget = driver.findElement(By.linkText("pain"));
        //Mouse hover 'pain'
        actions.moveToElement(selectTarget).build().perform();
        //click on pain
        actions.click().build().perform();
        //verifying user is in pain page
        String expectedValue = "Order online now";
        String actualValue = driver.findElement(By.xpath("//span[text()='Order online now']")).getText();
        Assert.assertTrue("User is in the pain page", expectedValue.equalsIgnoreCase(actualValue));

    }

    @After
    public void closeBrowser() {
        driver.quit();

    }
}
