
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NopCommerce {
    public static String browserName = "Firefox";
    public WebDriver driver;

    @Before
    public void openBrowser() {
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "E:\\Software Testing\\Soft Folder\\Browser Driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //Program 1
    @Test
    public void clothingShoppingWithScreenShot() {
        //click on Apparel
        driver.findElement(By.linkText("Apparel")).click();
        //click on clothing
        driver.findElement(By.linkText("Clothing")).click();
        //click on sort by
        Select select = new Select(driver.findElement(By.id("products-orderby")));
        //select Price: Low to High
        select.selectByVisibleText("Price: Low to High");
        //click on display
        Select select1 = new Select(driver.findElement(By.id("products-pagesize")));
        //select 3 per page
        select1.selectByVisibleText("3");
        //click on List
        driver.findElement(By.linkText("List")).click();

        //To take a Screenshot
        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File("");
        // FileUtils.copyfile(SrcFile,DestFile);

        //add custom t-shirt to compare list
        driver.findElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //add  oversized women t-shirt to compare list
        driver.findElement(By.xpath("//div[@class='product-list']//div[3]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //click on product comparison from green line link
        driver.findElement(By.linkText("product comparison")).click();
        //asserting product name custom t-shirt
        String expectedResult = "Custom T-Shirt";
        String actualResult = driver.findElement(By.xpath("//a[contains(text(),'Custom T-Shirt')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        //clear compare list
        driver.findElement(By.xpath("//a[@class='clear-list']")).click();
        //asserting message you have no items to compare
        String expectedText = "You have no items to compare.";
        String actualText = driver.findElement(By.xpath("//div[@class='no-data']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    //program2
    @Test
    public void clothingShoppingWithoutScreenShot() {
        //click on Apparel
        driver.findElement(By.linkText("Apparel")).click();
        //click on clothing
        driver.findElement(By.linkText("Clothing")).click();
        //click on sort by
        Select select = new Select(driver.findElement(By.id("products-orderby")));
        //select  Price:High to Low
        select.selectByVisibleText("Price: High to Low");
        //click on display
        Select select1 = new Select(driver.findElement(By.id("products-pagesize")));
        //select 9 per page
        select1.selectByVisibleText("9");
        //click on List
        driver.findElement(By.xpath("//a[text()='List']")).click();
        //add custom t-shirt to compare list
        //driver.findElement(By.xpath("//div[@class='product-list']//div[3]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //add  oversized women t-shirt to compare list
        driver.findElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //click on product comparison from green line link
        driver.findElement(By.xpath("//a[text()='product comparison']")).click();
        //asserting product name oversized women t-shirt
        //String expectedName="Oversized Women T-Shirt";
        //String actualName=driver.findElement(By.linkText("Oversized Women T-Shirt")).getText();
        //Assert.assertEquals(expectedName,actualName);
        //or we can do this way as well
        Assert.assertTrue(driver.findElement(By.linkText("Oversized Women T-Shirt")).isDisplayed());
        //clear compare list
        driver.findElement(By.xpath("//a[@class='clear-list']")).click();
        //asserting message you have no items to compare
        String expectedText = "You have no items to compare.";
        String actualText = driver.findElement(By.xpath("//div[@class='no-data']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    //program5
    @Test
    public void verifyRegistration() {
        // String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        // String email= "test"+ timeStamp + "@test.com";

        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        String email = "test" + date1 + "@test.com";

        //click on register
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Ram");
        driver.findElement(By.id("LastName")).sendKeys("Sita");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("2");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("March");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1986");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys("TurnerLtd");
        driver.findElement(By.id("Password")).sendKeys("sitaram");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("sitaram");
        driver.findElement(By.id("register-button")).click();
        //To Verify message "your registration completed"
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals("Registered successfully", expectedMessage, actualMessage);
        //now  log out and log in again with registered email address
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("sitaram");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

    }

    //program 7
    @Test
    public void addingVirtualGiftCard() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        String myEmail = "software" + date1 + "@test.com";
        String recipientEmail = "automation" + date1 + "@test.com";


        //click on register
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Ram");
        driver.findElement(By.id("LastName")).sendKeys("Sita");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("2");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("March");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1986");
        driver.findElement(By.id("Email")).sendKeys(myEmail);
        driver.findElement(By.id("Company")).sendKeys("TurnerLtd");
        driver.findElement(By.id("Password")).sendKeys("sitaram");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("sitaram");
        driver.findElement(By.id("register-button")).click();
        //now  log out and log in again with registered email address
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(myEmail);
        driver.findElement(By.id("Password")).sendKeys("sitaram");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        //click on gift card
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Gift Cards')]")).click();
        //adding a virtual gift card in the cart
        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
        //filling all the personal details
        driver.findElement(By.id("giftcard_43_RecipientName")).sendKeys("Sam");
        driver.findElement(By.id("giftcard_43_RecipientEmail")).sendKeys(recipientEmail);
        driver.findElement(By.id("giftcard_43_SenderName")).sendKeys("Ram");
        driver.findElement(By.id("giftcard_43_SenderEmail")).sendKeys(myEmail);
        //click on send an email a friend
        driver.findElement(By.xpath("//input[@value='Email a friend']")).click();

    }

    //program 6
    @Test
    public void buyingBook() {
        //click on books
        driver.findElement(By.linkText("Books")).click();
        //click on Fahrenheit 451 by ray Bradbury
        driver.findElement(By.linkText("Fahrenheit 451 by Ray Bradbury")).click();
        //clear the Quantity
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_37']")).clear();
        //enter the quantity 4
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_37']")).sendKeys("4");
        //add the book in wishlist
        driver.findElement(By.id("add-to-wishlist-button-37")).click();
        //verify The "product has been added to your wishlist" from top green line
        String expectedMessage = "The product has been added to your wishlist";
        String actualMessage = driver.findElement(By.className("content")).getText();
        Assert.assertEquals("Verify passed", expectedMessage, actualMessage);
        //add product in to cart
        driver.findElement(By.id("add-to-cart-button-37")).click();
        //go to cart from top green message
        driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();
        //click on terms and condition
        driver.findElement(By.id("termsofservice")).click();
        //click on checkout
        driver.findElement(By.id("checkout")).click();
        //click on checkout as guest
        driver.findElement(By.xpath("//input[@class='button-1 checkout-as-guest-button']")).click();
        //filling all personal details
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Raj");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Kapoor");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("rajkapoor@test.com");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
        select.selectByVisibleText("United Kingdom");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("606 ShivNagar");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("fg5 9lo");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("08965434875");
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")).click();
        driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page div.page-body.checkout-data ol.opc li.tab-section.allow.active:nth-child(3) div.step.a-item form:nth-child(1) div.buttons:nth-child(2) > input.button-1.shipping-method-next-step-button")).click();
        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
        driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
        //add card details
        Select select1 = new Select(driver.findElement(By.id("CreditCardType")));
        select1.selectByVisibleText("Master card");
        driver.findElement(By.id("CardholderName")).sendKeys("Mr Raj");
        driver.findElement(By.id("CardNumber")).sendKeys("378282246310005");
        driver.findElement(By.id("ExpireMonth")).sendKeys("02");
        driver.findElement(By.id("ExpireYear")).sendKeys("2021");
        driver.findElement(By.id("CardCode")).sendKeys("324");
        driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
        //continue
        driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page div.page-body.checkout-data ol.opc li.tab-section.allow.active:nth-child(6) div.step.a-item div.buttons:nth-child(2) > input.button-1.confirm-order-next-step-button")).click();
        //Asserting Confirmation message
        String expectedText = "Your order has been successfully processed!";
        String actualText = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();
        Assert.assertEquals("Order Completed", expectedText, actualText);
    }

    @After
    public void closingBrowser() {
        driver.quit();
    }


}
