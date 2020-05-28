package com.sdet.tests.exerciseOneAutomationJavaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppleHomePageTest {

    @Test
    public void driver() {

        String test;
        String actual;
        String expected;

        System.setProperty("webdriver.chrome.driver", "src/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.apple.com/mx/");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ac-gn-link-search")));

        driver.get("https://www.apple.com/mx/mac/");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".section-macbook-air .align-self-center div")));
        
        actual = driver.findElement(By.cssSelector(".section-macbook-air div.product-copy.column.large-4.medium-5.small-12.small-text-center.align-self-center div")).getText();
        expected = "Velocidad para llevar a todas partes.";

        System.out.println("Esto esta imprimiendo: " + actual);

        Assert.assertTrue(actual.contains(expected));

        driver.findElement(By.cssSelector("#ac-gn-link-search")).click();
        driver.findElement(By.cssSelector("#ac-gn-searchform-input")).sendKeys("iPhone XR");
        driver.findElement(By.cssSelector("#ac-gn-searchform-input")).submit();
        driver.findElement(By.cssSelector("div.as-relatedproduct.position-1 h2")).click();

        test = driver.getCurrentUrl();
        test = driver.getTitle();
        System.out.println(test);
        Assert.assertEquals(test, "iPhone XR - Apple (MX)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac-ln-actions.ac-ln-actions-center")));
        assert driver.findElement(By.cssSelector("#ac-localnav > div > div.ac-ln-content")).isEnabled();
        assert driver.findElement(By.cssSelector(".ac-ln-actions.ac-ln-actions-center")).isEnabled();
    }

}
