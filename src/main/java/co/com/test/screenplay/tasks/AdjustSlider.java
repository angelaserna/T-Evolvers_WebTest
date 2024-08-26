package co.com.test.screenplay.tasks;

import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.interactions.Actions;

public class AdjustSlider implements Task {

    private Reservation reservation;
    private String rate_min;
    private String rate_max;

    public AdjustSlider(String rate_min, String rate_max){
        this.rate_min = reservation.getRate_min();
        this.rate_max = reservation.getRate_max();
    }


    public static AdjustSlider range(String rate_min, String rate_max) {
        return Tasks.instrumented(AdjustSlider.class, rate_min, rate_max);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade slider = DxHotelsPage.SLIDER.resolveFor(actor);
        int width = slider.getSize().getWidth();
        int xCoord = (int) (width * ((Integer.parseInt(rate_min) - 208.0) / (999.0 - Integer.parseInt(rate_max))));

        Actions actions = new Actions(actor.abilityTo(BrowseTheWeb.class).getDriver());
        actions.dragAndDropBy(slider, xCoord, 0).perform();

    }
}
