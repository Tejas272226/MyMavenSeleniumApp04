package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {

    public static void main(String[] args) throws Exception {

        System.setProperty("MOZ_DISABLE_CONTENT_SANDBOX", "1");

        FirefoxOptions options = new FirefoxOptions();

        // Jenkins/Linux compatible options
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Fix marionette/profile issues
        options.addArguments("-profile");
        options.addArguments("/tmp/firefox-profile");

        WebDriver driver = new FirefoxDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Open new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Practice Test Automation
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        // Open another tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Automation Exercise
        driver.get("https://automationexercise.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/products']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("search_product"))).sendKeys("Tshirt");

        driver.findElement(By.id("submit_search")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[contains(text(),'Add to cart')])[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//u[contains(text(),'View Cart')]"))).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
