package co.com.test.screenplay.questions;

import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Booking implements Question<Boolean> {

    private String expectedResult;
    private Target booking;

    public Booking(Reservation reservation, Target booking) {
        this.expectedResult = reservation.getHotelName();
        this.booking = DxHotelsPage.BOOKIT;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(booking, WebElementStateMatchers.isVisible()));
        String bookingFront = booking.resolveFor(actor).getText();
        return bookingFront.contains(expectedResult);
    }
}
