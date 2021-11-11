package br.com.frontend.automation.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class ChromeWebDriver extends AbstractDriverLoader {

    public WebDriver webDriver() {

        String path = "src/main/resources/driver/" + resolveInternalSo() + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        log.info("Getting chromedriver in the path: {}", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
}
