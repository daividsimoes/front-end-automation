package br.com.frontend.automation.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:/features"},
        glue = {"br.com.frontend.automation.test.step"},
        plugin = {"pretty", "json:target/cucumber/logs/log.json"}
)
public class AmazonRunnerTest {

}
