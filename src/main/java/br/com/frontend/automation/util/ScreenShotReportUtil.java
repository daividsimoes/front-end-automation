package br.com.frontend.automation.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ScreenShotReportUtil {

    public static String pathCapture;
    public static String methodName;

    public static String captureScreen(WebDriver driver) {
        String path;
        String reportPath;
        File source;
        try {
            source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            path = "./target/report/screenshots/" + source.getName();
            reportPath = "screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {

            log.info("Failed to capture screenshot: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return reportPath;
    }

    public static void takeScreenShotAndGetMethodName(WebDriver driver) {

        methodName = new Throwable()
                .getStackTrace()[1]
                .getMethodName();

        ScreenShotReportUtil.pathCapture = ScreenShotReportUtil.captureScreen(driver);
    }
}
