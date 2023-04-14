package org.cvetok39;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    private final ChromeDriver driver;

    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver(getDesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    public final ChromeDriver getDriver() {
        return driver;
    }

    private ChromeOptions getDesiredCapabilities() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        return options;
    }

    public void run() {};
}
