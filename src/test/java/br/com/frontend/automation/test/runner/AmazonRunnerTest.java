package br.com.frontend.automation.test.runner;

import br.com.frontend.automation.CucumberReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:/features"},
        glue = {"br.com.frontend.automation.test.step"}
//        plugin = {"br.com.frontend.automation.util.StepUtil"}
)
public class AmazonRunnerTest {

    @BeforeClass
    public static void init(){
        CucumberReport.remove(new File("target/report"));
        CucumberReport.setup();
    }
}
