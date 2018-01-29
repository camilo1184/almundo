/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.almundo.servlet;

import org.junit.Test;
import javax.naming.NamingException;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author cmunoz
 */
public class llamadasServletTest {

    private WebDriver driver;

    public llamadasServletTest() {
    }

    @Before
    public void setUp() throws NamingException {
        // Create a new instance of the html unit driver
       /* driver = new FirefoxDriver();

        //Navigate to desired web page
        driver.get("http://localhost:8085/callcenter/index_1.jsp");*/
    }

    @Test
    public void shouldBeAbleEnterUserNameAndClickSubmitToVerifyWelcomeMessage() {
        
        
        /*System.out.println("driver :::::::::::: "+driver.getPageSource());
        
        // verify title of index page
        verifyTitle("Enter your name");

        //verify header of index page
        verifyHeaderMessage("Please enter your name");

        //enter user name as Allen
        enterUserName("Allen");

        //verify title of welcome page
        verifyTitle("Welcome");

        //verify header of welcome page
        verifyHeaderMessage("Welcome Allen!!!");

        //verify back link and click on it
        backToPreviousPage("go back");

        //verify title of index page again to make sure link is working
        verifyTitle("Enter your name");*/
    }

    private void verifyTitle(String expectedTitle) {
        //get the title of the page
        String actualTitle = driver.getTitle();

        // verify title
        //assertThat(actualTitle, equalTo(expectedTitle));
    }

    private void verifyHeaderMessage(String expectedHeaderMessage) {
        // find header element
        WebElement element = driver.findElement(By.tagName("h3"));

        String actualHeaderMessage = element.getText();

        // verify header text
    }

    private void enterUserName(String userName) {
        // find the input text box
        WebElement element = driver.findElement(By.id("userName"));

        // set the user name in input text box
        element.sendKeys(userName);

        // submit form
        element.submit();
    }

    private void backToPreviousPage(String expectedLinkText) {
        // find the link by its id
        WebElement element = driver.findElement(By.id("back"));

        //get the actual link text
        String actualLinkText = element.getText();

        //verify link text with expected like text
        //   assertThat(actualLinkText, equalTo(expectedLinkText));
        // click the link
        element.click();
    }
}
