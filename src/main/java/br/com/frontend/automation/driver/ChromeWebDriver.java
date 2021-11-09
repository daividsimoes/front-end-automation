package br.com.frontend.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver extends AbstractDriverLoader {

    public WebDriver webDriver() {

        String path = "src/main/resources/driver/" + resolveInternalSo() + "/chromedriver";

        System.setProperty("webdriver.chrome.driver", path);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
}
