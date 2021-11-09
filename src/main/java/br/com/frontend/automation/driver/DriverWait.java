package br.com.frontend.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {

    private static final int DEFAULT_WAIT_IN_SECONDS = 10;
    private WebDriver driver;

    public DriverWait(WebDriver driver) {

        this.driver = driver;
    }

    public WebDriverWait webDriverWait() {

        return new WebDriverWait(driver, DEFAULT_WAIT_IN_SECONDS);
    }
}
