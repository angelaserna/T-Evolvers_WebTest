package co.com.test.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Validate {

    private Validate(){}

    public static Question<Boolean> message(String expectedResult, Target frontText) {
        return new FailedMessage(expectedResult, frontText);
    }
}
