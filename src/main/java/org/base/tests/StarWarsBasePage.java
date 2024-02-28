package org.base.tests;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class StarWarsBasePage extends BaseTest {
    static RemoteWebDriver localDriver;

    @Given("I navigate to website: {string} using browser: {string}")
    public void navigate_to_star_wars_browser(String website, String browser) throws IOException {
        localDriver = setUp(browser);
        localDriver.navigate().to(website);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table"))));
    }

    @After
    public void close() {
        driver.close();
    }
}