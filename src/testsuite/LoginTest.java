package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //find the element of username and send the username key
        WebElement UserNameElement = driver.findElement(By.id("username"));
        UserNameElement.sendKeys("tomsmith");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");
        //click on loging button using elements
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
        //this os form requirement
        String expectedLogInText = "Secure Area";
        //find the welcome text element and get the text
        WebElement actualLogInTextElements = driver.findElement(By.tagName("h2"));
        String actualLogInText = actualLogInTextElements.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedLogInText,actualLogInText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //find the element of username and send the username key
        WebElement UserNameElement = driver.findElement(By.id("username"));
        UserNameElement.sendKeys("tomsmith1");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");
        //click on loging button using elements
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
        //this os form requirement
        String expectedErrorMessage = "Your username is invalid!";
        //find the welcome text element and get the text
        WebElement actualErrorMessageElements = driver.findElement(By.cssSelector("div#flash"));
        String actualErrorMessage = actualErrorMessageElements.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        //find the element of username and send the username key
        WebElement UserNameElement = driver.findElement(By.id("username"));
        UserNameElement.sendKeys("tomsmith");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("“SuperSecretPassword");
        //click on loging button using elements
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
        //this os form requirement
        String expectedErrorMessage = "Your password is invalid!";
        //find the welcome text element and get the text
        WebElement actualErrorMessageElements = driver.findElement(By.cssSelector("div#flash"));
        String actualErrorMessage = actualErrorMessageElements.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
