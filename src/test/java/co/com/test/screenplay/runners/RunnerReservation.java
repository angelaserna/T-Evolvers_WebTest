package co.com.test.screenplay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/reservationhotel.feature",
        tags= "@reservation",
        glue="co.com.test.screenplay.stepdefinitions",
        snippets=SnippetType.CAMELCASE		)

public class RunnerReservation {
}
