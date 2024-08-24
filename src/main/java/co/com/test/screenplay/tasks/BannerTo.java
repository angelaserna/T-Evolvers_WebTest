package co.com.test.screenplay.tasks;

import co.com.test.screenplay.interactions.WaitInteraction;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class BannerTo implements Task {

    public static BannerTo login() {
        return Tasks.instrumented(BannerTo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DxHotelsPage.LOGIN));
        actor.attemptsTo(WaitInteraction.waitClass(1000));
    }
}
