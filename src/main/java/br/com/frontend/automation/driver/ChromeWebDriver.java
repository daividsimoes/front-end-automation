package br.com.frontend.automation.driver;

import br.com.frontend.automation.enums.SO;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class ChromeWebDriver extends AbstractDriverLoader {

    public WebDriver webDriver() {

        String systemOperation = resolveInternalSo();
        String path = "src/main/resources/driver/" + systemOperation + "/chromedriver";

        if(systemOperation.equals(SO.WINDOWS.getSo())){
            path = path.concat(".exe");
        }

        System.setProperty("webdriver.chrome.driver", path);

        log.info("Getting chromedriver in the path: {}", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
}
