package co.com.test.screenplay.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class WaitInteraction implements Interaction {

    private int var;

    protected WaitInteraction(int var){
        this.var = var;
    }

    public static WaitInteraction waitClass(int var) {
        return Tasks.instrumented(WaitInteraction.class, var);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(var);
    }
}
