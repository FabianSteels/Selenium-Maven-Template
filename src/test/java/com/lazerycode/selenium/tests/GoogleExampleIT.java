package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.GoogleHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GoogleExampleIT extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    @Test
    public void googleCheeseExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = DriverBase.getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        googleHomePage.enterSearchTerm("Cheese")
                .submitSearch();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith("Cheese"));

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void googleMilkExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = DriverBase.getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        googleHomePage.enterSearchTerm("Milk")
                .submitSearch();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith("Milk"));

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }


    @Test
    public void googleCalcExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();
        //WebDriver driver = new ChromeDriver();
        Map<String, Object> vars = new HashMap<String, Object>();
        driver.get("https://www.google.be/");
        driver.manage().window().setSize(new Dimension(1319, 876));
        driver.findElement(By.name("q")).sendKeys("50+20");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("cwos")).click();
        vars.put("result", driver.findElement(By.id("cwos")).getText());
        System.out.println(vars.get("result").toString());
    }


}