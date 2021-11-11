package br.com.frontend.automation;

import br.com.frontend.automation.util.StepUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

public class CucumberReport {

    private static ExtentReports extent;
    private static ExtentTest logger;

    private static FileReader fileReader;
    private static BufferedReader bufferedReader;
    private static String textStep;

    public CucumberReport(Scenario scenario, Status status) {

        if (scenario.isFailed()) {

            logger.fail("Status: " + status);
        }
        extent.flush();
    }

    public CucumberReport(Scenario scenario) {

        logger = extent.createTest(scenario.getName());
    }

    public static void init() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("target/report/report.html");
        reporter.config().setDocumentTitle("Cucumber Report");
        reporter.config().setReportName("Report");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("System Operation", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    public static void report(String stepType) {

        try {
            fileReader = new FileReader("target/step.txt");
            bufferedReader = new BufferedReader(fileReader);
            while ((textStep = bufferedReader.readLine()) != null) {

                if (textStep.contains(stepType)) {

                    logger.pass(StepUtil.gherking);
                }
            }
        }catch (IOException ex){

            throw new RuntimeException(ex.getMessage());
        }
    }
}
