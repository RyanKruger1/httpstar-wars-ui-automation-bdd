package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.base.core.Core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTest extends Core {

    public static RemoteWebDriver driver;
    public static WebDriverWait wait;

    public RemoteWebDriver setUp(String browser) throws IOException {
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "chrome-headless":
                options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return driver;
    }

    public boolean validateItemInList(List<WebElement> listUnderTest, String itemUnderTest) {
        for (WebElement critItem : listUnderTest) {
            if (critItem.getText().equals(itemUnderTest)) {
                return true;
            }
        }
        return false;
    }

    public List<WebElement> createMovieCategoryList(RemoteWebDriver driver, String listCriteria) {
        return driver.findElements(By.xpath("//h1[text()='" + listCriteria + "']//..//..//li"));
    }
}