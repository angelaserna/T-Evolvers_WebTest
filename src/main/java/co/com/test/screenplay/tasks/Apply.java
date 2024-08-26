package co.com.test.screenplay.tasks;

import co.com.test.screenplay.interactions.WaitInteraction;
import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Apply implements Task {

    private Reservation reservation;

    public Apply(Reservation reservation) {
        this.reservation = reservation;
    }

    public static Apply filters(Reservation reservation) {
        return Tasks.instrumented(Apply.class, reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //Slider Nightly Rate
        WebElement trackBarElement = (BrowseTheWeb.as(actor).getDriver())
                .findElement(By.id("MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_S"));

        Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
        actions.moveToElement(trackBarElement, -30, 0).click().perform();

        if (reservation.getScore() != null){
            actor.attemptsTo(SelectTo.score(reservation.getScore()));
            actor.attemptsTo(WaitInteraction.waitClass(3000));
        }

        actor.attemptsTo(Click.on(DxHotelsPage.APPLY));
        actor.attemptsTo(WaitInteraction.waitClass(3000));
    }
}
