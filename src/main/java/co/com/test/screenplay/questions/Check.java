package co.com.test.screenplay.questions;

import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Check implements Question<Boolean> {

    private final String bookingExpected;

    public Check(String bookingExpected) {
        this.bookingExpected = bookingExpected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String bookingObtained = DxHotelsPage.RESERVATION.resolveFor(actor).getText();
        return bookingObtained.equalsIgnoreCase(bookingExpected);
    }

    public static Check reservation(String expectedHotelName) {
        return new Check(expectedHotelName);
    }
}
