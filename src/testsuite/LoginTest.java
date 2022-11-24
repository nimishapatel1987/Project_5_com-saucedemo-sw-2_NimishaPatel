package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter standered username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter Password
        sendTextToElement(By.name("password"), "secret_sauce");
        //click on login button
        clickOnElement(By.xpath("//input[@name = 'login-button']"));
        //this is from requirements
        String expectedMessage = "PRODUCTS";
        String actualMessage = getTextFromElement(By.xpath("//span[@class = 'title']"));
        //valid actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedonPage() {
        //Enter standered username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter Password
        sendTextToElement(By.name("password"), "secret_sauce");
        //click on login button
        clickOnElement(By.xpath("//input[@name = 'login-button']"));
        //verify that six products are  displayed on page
        List<WebElement> list = driver.findElements(By.name("inventory_list"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



