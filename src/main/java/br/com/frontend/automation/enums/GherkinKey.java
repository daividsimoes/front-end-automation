package br.com.frontend.automation.enums;

import com.aventstack.extentreports.gherkin.model.But;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import lombok.Getter;

@Getter
public enum GherkinKey {

    GIVEN(Given.getGherkinName()),
    WHEN(When.getGherkinName()),
    THEN(Then.getGherkinName()),
    BUT(But.getGherkinName());

    private String key;

    GherkinKey(String key) {

        this.key = key;
    }
}
