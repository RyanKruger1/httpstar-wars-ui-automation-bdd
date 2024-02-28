package org.base.tests;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.List;

public class StarWarsLandingPage extends BaseTest {

    static RemoteWebDriver localDriver;

    public StarWarsLandingPage() {
        localDriver = driver;
    }

    @When("I sort movie table by {string}")
    public void sortTableBy(String criteria) {
        WebElement element = localDriver.findElement(By.xpath("//th[text()='" + criteria + "']"));
        element.click();
    }

    @Then("I validate the last movie is {string}")
    public void validate_first_movie(String criteria) {
        List<WebElement> titleColumn = driver.findElements(By.xpath("//td//a"));
        Assert.assertTrue(titleColumn.get(titleColumn.size() - 1).getText().equals(criteria));
    }

    @When("I inspect movie {string}")
    public void inspect_movie(String criteria) {
        WebElement element = driver.findElement(By.xpath("//a[text()='" + criteria + "']"));
        element.click();
        driver = localDriver;
    }
}