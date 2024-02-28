package org.base.tests;

import io.cucumber.java.en.Then;
import org.base.BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class StarWarsMoviePage extends BaseTest {

    static RemoteWebDriver localDriver;

    public StarWarsMoviePage() {
        localDriver = driver;
    }

    @Then("I validate {string} contain {string}")
    public void validate_list_contains(String list, String item) {
        Assert.assertTrue(validateItemInList(createMovieCategoryList(localDriver, list), item));
    }

    @Then("I validate {string} does not contain {string}")
    public void validate_list_does_not_contain(String list, String item) {
        Assert.assertFalse(validateItemInList(createMovieCategoryList(localDriver, list), item));
    }
}