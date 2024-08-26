package co.com.test.screenplay.interactions;

import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

import java.util.List;

public class Select implements Task {

    private Reservation reservation;
    private Double minPrice;
    private Double bestPrice;
    private String hotelWithMinPrice;
    public int pageWithBestPrice;
    int currentPage = 1;

    public Select(Reservation reservation) {
        this.reservation = reservation;
        this.minPrice = null;
        this.bestPrice = null;
        this.hotelWithMinPrice = null;
        this.pageWithBestPrice = -1;
    }

    public static Select theBestOption(Reservation reservation) {
        return new Select(reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int maxPages = 3;
        Double rateMin = Double.valueOf(reservation.getRate_min());

        while (currentPage <= maxPages) {
            List<WebElementFacade> hotelRows = DxHotelsPage.HOTELS.resolveAllFor(actor);

            for (WebElementFacade row : hotelRows) {
                String hotelName = row.find(By.className("hotel-title")).getText();
                String priceText = row.find(By.className("price")).getText().replace("$", "").trim();

                try {
                    Double price = Double.parseDouble(priceText);

                    if (minPrice == null || price < minPrice ) {
                        minPrice = price;
                        if (minPrice >= rateMin){
                            bestPrice = minPrice;
                            hotelWithMinPrice = hotelName;
                            pageWithBestPrice = currentPage;
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (DxHotelsPage.NEXTPAGE.resolveFor(actor).isPresent()) {
                actor.attemptsTo(Click.on(DxHotelsPage.NEXTPAGE));
                actor.attemptsTo(WaitInteraction.waitClass(2000));
                if (currentPage == maxPages){
                    break;
                }
                currentPage++;
            } else {
                break;
            }

        }

        if (bestPrice != null) {
            System.out.println("Minimum Price: $" + bestPrice + " for " + hotelWithMinPrice);
            navigateToPage(actor, pageWithBestPrice);
        }
    }

    private <T extends Actor> void navigateToPage(T actor, int pageNumber) {
        while (pageNumber < currentPage) {
            if (DxHotelsPage.PREVIOUSPAGE.resolveFor(actor).isPresent()) {
                actor.attemptsTo(Click.on(DxHotelsPage.PREVIOUSPAGE));
                actor.attemptsTo(WaitInteraction.waitClass(2000));
                currentPage--;
            } else {
                break;
            }
        }
        List<WebElementFacade> hotelRows = DxHotelsPage.HOTELS.resolveAllFor(actor);
        for (WebElementFacade row : hotelRows) {
            int count = 0;
            String hotelName = row.find(By.className("hotel-title")).getText();
            String priceText = row.find(By.className("price")).getText().replace("$", "").trim();
            Double price = Double.parseDouble(priceText);

            if (hotelName.equals(hotelWithMinPrice) && Double.compare(price, bestPrice) == 0){
                reservation.setHotelName(hotelName);
                actor.attemptsTo(Click.on(DxHotelsPage.BOOKIT.of(String.valueOf(count))));
                actor.attemptsTo(WaitInteraction.waitClass(5000));
                break;
            }
            count++;
        }
    }
}
