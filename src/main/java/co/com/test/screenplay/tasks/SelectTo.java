package co.com.test.screenplay.tasks;

import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectTo implements Task {

    private String score;

    public SelectTo(String score) {
        this.score = score;
    }

    public static SelectTo score(String score) {
        return Tasks.instrumented(SelectTo.class, score);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (score){
            case "1":
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("0")));
                break;
            case "2":
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("0")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("1")));
                break;
            case "3":
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("0")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("1")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("2")));
                break;
            case "4":
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("0")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("1")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("2")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("3")));
                break;
            case "5":
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("0")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("1")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("2")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("3")));
                actor.attemptsTo(Click.on(DxHotelsPage.SCORE_STAR.of("4")));
                break;
            default: throw new IllegalArgumentException("Option not recognized: " + score);
        }
    }
}
