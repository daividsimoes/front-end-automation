package br.com.frontend.automation;

import br.com.frontend.automation.util.ScreenShotReportUtil;
import br.com.frontend.automation.util.StringUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class CucumberReport {

    private static ExtentReports extent;
    private static ExtentTest logger;

    public CucumberReport(Scenario scenario) {

        if (scenario.isFailed()) {

            logger.fail(StringUtil.normalizeText("Method Failed: {0}", ScreenShotReportUtil.methodName),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotReportUtil.pathCapture).build());
        }

        extent.flush();
    }

    public CucumberReport(String scenarioName) {

        logger = extent.createTest(scenarioName);
    }

    public static void setup() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("target/report/report.html");
        reporter.config().setDocumentTitle("Cucumber Report");
        reporter.config().setReportName("Report");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("System Operation", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    public static void report(String message) {

        logger.pass(StringUtil.normalizeText("Step executed: {0}", message),
                MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotReportUtil.pathCapture).build());
        extent.flush();
    }

    public static void remove(File file) {

        if (file.isDirectory()) {

            log.info("Deleting files on folder: {}", file);
            File[] sun = file.listFiles();
            for (File toDelete : sun) {

                remove(toDelete);
            }
        } else {

            log.info("Deleting file: {}", file);
            file.delete();
        }
    }
}
