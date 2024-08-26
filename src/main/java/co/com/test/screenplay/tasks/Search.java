package co.com.test.screenplay.tasks;

import co.com.test.screenplay.interactions.WaitInteraction;
import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import co.com.test.screenplay.utils.DateUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Search implements Task {

    private Reservation reservation;
    private final String dateFrom;
    private final String dateTo;

    public Search(Reservation reservation){
        this.reservation = reservation;
        int daysFrom = Integer.parseInt(reservation.getCheckin());
        int daysTo = Integer.parseInt(reservation.getCheckout());
        this.dateFrom = DateUtils.getFormattedDateFrom(daysFrom);
        this.dateTo = DateUtils.getFormattedDateTo(daysTo);
    }

    public static Search hotels(Reservation reservation) {
        return Tasks.instrumented(Search.class, reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(reservation.getLocation()).into(DxHotelsPage.LOCATION));
        actor.attemptsTo(
                Clear.field(DxHotelsPage.CHECKIN),
                Enter.theValue(dateFrom).into(DxHotelsPage.CHECKIN)
        );
        actor.attemptsTo(
                Clear.field(DxHotelsPage.CHECKOUT),
                Enter.theValue(dateTo).into(DxHotelsPage.CHECKOUT)
        );
        actor.attemptsTo(Enter.theValue(reservation.getRooms()).into(DxHotelsPage.ROOMS));
        actor.attemptsTo(Enter.theValue(reservation.getAdults()).into(DxHotelsPage.ADULTS));
        actor.attemptsTo(Enter.theValue(reservation.getChildren()).into(DxHotelsPage.CHILDREN));
        actor.attemptsTo(Click.on(DxHotelsPage.SEARCH));
        actor.attemptsTo(WaitInteraction.waitClass(2000));
    }

}
