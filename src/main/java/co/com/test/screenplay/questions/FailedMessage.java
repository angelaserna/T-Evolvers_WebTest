package co.com.test.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FailedMessage implements Question<Boolean> {

    private String expectedresult;
    private Target frontText;


    public FailedMessage(String expectedResult, Target frontText) {
        this.expectedresult = expectedResult;
        this.frontText = frontText;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(frontText, WebElementStateMatchers.isVisible()));
        String obtainedResult = frontText.resolveFor(actor).getText();
        return obtainedResult.contains(expectedresult);
    }
}
