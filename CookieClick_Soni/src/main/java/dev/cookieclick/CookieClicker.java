package dev.cookieclick;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;

public class CookieClicker {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loadCookieClicker();
        locateByXpath();
        locateById();
        locateByTagName();
        cookieClick(1);
        driver.quit();
    }
    // Load the cookie clicker site
    public static void loadCookieClicker(){
        driver.get("https://orteil.dashnet.org/cookieclicker/");
    }
    // Find element name by xpath
    public static void locateByXpath(){
        // Since explicit waits allow you to wait for a condition to occur,
        // they make a good fit for synchronising the state between the browser and its DOM,
        // and your WebDriver script.
        WebElement searchTag = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Deutsch')]")));
        System.out.println("Tag is: "+ searchTag.getTagName());
    }
    // Find the text by id
    public static void locateById(){
        WebElement searchId = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(By.id("langSelect-CS")));
        System.out.println("Text is : "+searchId.getText());
    }
    // Finding tag name location
    public static void locateByTagName(){
        WebElement searchTag = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(By.tagName("canvas")));
        System.out.println("Location is:"+searchTag.getLocation());
    }
    // Cookie clicking starting
    public static void cookieClick(int num) throws InterruptedException {
        // This english click is to remove the dive which is obstructing the cookie click
        WebElement english = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                ExpectedConditions.elementToBeClickable(By.id("langSelect-EN")));
        english.click();
        WebElement bigCookie = new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                ExpectedConditions.elementToBeClickable(By.id("bigCookie")));
        // The number of cookie click increases with the range of for loop
        int k;
        for(k=0;k<10000;k++) {
            bigCookie.click();
        }
        System.out.println("Number of cookie clicks: "+k);
    }
}
