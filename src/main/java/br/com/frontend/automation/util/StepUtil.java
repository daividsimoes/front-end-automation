package br.com.frontend.automation.util;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStepStarted;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class StepUtil implements ConcurrentEventListener {

    private static String stepName;
    private static String keyGherking;
    public static String gherking;

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {

        eventPublisher.registerHandlerFor(TestStepStarted.class, stepHandler);
    }

    public EventHandler<TestStepStarted> stepHandler = this::handleStepStarted;

    public void handleStepStarted(TestStepStarted event) {

        if (event.getTestStep() instanceof PickleStepTestStep) {

            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            stepName = testStep.getStep().getText();
            keyGherking = testStep.getStep().getKeyword();
            gherking = keyGherking.concat(stepName);

            createFile(gherking);
        }
    }

    public void createFile(String file) {

        try {

            FileWriter writer = new FileWriter("target/step.txt");
            writer.write(file);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    private void deleteFile(String path) {

        log.info("Delete file from path: {}", path);
        File folder = new File(path);

        if(folder.isDirectory()) {

            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }
}
