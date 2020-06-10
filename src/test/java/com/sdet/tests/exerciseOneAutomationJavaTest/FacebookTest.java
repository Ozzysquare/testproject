package com.sdet.tests.exerciseOneAutomationJavaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest {



    @Test
    public void driver() {

        String test;
        String title;
        WebElement month;
        WebElement gender;
        WebElement text;
        WebElement forgot;
        WebElement findYourAccount;
        WebElement email;
        WebElement errorMessage;

        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        test = driver.getCurrentUrl();
        title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals(test,"https://www.facebook.com/");
        Assert.assertEquals(title,"Facebook - Log In or Sign Up");


        month = driver.findElement(By.id("month"));
        month.findElement(By.cssSelector("#month option:nth-child(11)")).isEnabled();
        month.click();

        gender = driver.findElement(By.id("u_0_6"));
        gender.isEnabled();
        gender.click();

        text = driver.findElement(By.cssSelector("#content div._8esl h2"));
        text.getText();
        System.out.println(text);
        Assert.assertNotEquals(text,"Connect with friends and the world around you on Facebook.");

        forgot = driver.findElement(By.cssSelector("#login_form td:nth-child(2) a"));
        forgot.isEnabled();
        forgot.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#identify_yourself_flow div:nth-child(2) h2")));
        findYourAccount = driver.findElement(By.cssSelector("#identify_yourself_flow div:nth-child(2) h2"));
        findYourAccount.getText();
        System.out.println(findYourAccount);

        Assert.assertNotEquals(findYourAccount,"Find Your Account");

        email = driver.findElement(By.id("email"));
        email.isEnabled();
        email.click();
        email.sendKeys("ozzy@hotmail.com");
        email.submit();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer")));
        driver.switchTo().activeElement().isDisplayed();
        errorMessage = driver.findElement(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer"));
        Assert.assertNotEquals(errorMessage,"Alert");
    }
}
