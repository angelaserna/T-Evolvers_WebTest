package co.com.test.screenplay.tasks;

import co.com.test.screenplay.interactions.SelectCalendar;
import co.com.test.screenplay.interactions.WaitInteraction;
import co.com.test.screenplay.models.Reservation;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Search implements Task {

    private Reservation reservation;

    public Search(Reservation reservation){
        this.reservation = reservation;
    }

    public static Search hotels(Reservation reservation) {
        return Tasks.instrumented(Search.class, reservation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(reservation.getLocation()).into(DxHotelsPage.LOCATION));
        actor.attemptsTo(Enter.theValue(reservation.getCheckin()).into(DxHotelsPage.CHECKIN));
        actor.attemptsTo(Enter.theValue(reservation.getCheckout()).into(DxHotelsPage.CHECKOUT));
        actor.attemptsTo(Enter.theValue(reservation.getRooms()).into(DxHotelsPage.ROOMS));
        actor.attemptsTo(Enter.theValue(reservation.getAdults()).into(DxHotelsPage.ADULTS));
        actor.attemptsTo(Enter.theValue(reservation.getChildren()).into(DxHotelsPage.CHILDREN));
        actor.attemptsTo(Click.on(DxHotelsPage.SEARCH));
        actor.attemptsTo(WaitInteraction.waitClass(5000));
        //Filters
        //actor.attemptsTo(AdjustSlider.range(reservation.getRate_min(), reservation.getRate_max()));
        //actor.attemptsTo(WaitInteraction.waitClass(5000));
        //actor.attemptsTo(SelectTo.score(reservation.getScore()));
        WebElement trackBarElement = (BrowseTheWeb.as(actor).getDriver()).findElement(By.id("MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_S"));

        Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
        actions.moveToElement(trackBarElement, 1, 0).click().perform();
        /*
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement elemento = driver.findElement(By.xpath("//div[@id='MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_S']"));

        // Coordenadas donde quieres hacer clic
        int x = 50; // Cambia esto según el punto deseado
        int y = 0; // Cambia esto según el punto deseado

        //document.querySelector("#MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_T")

        // Usar JavaScript para hacer clic en las coordenadas
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("var element = arguments[0]; var rect = element.getBoundingClientRect(); " +
                "var x = arguments[1] + rect.left; var y = arguments[2] + rect.top; " +
                "var evt = new MouseEvent('click', {clientX: x, clientY: y, bubbles: true}); " +
                "element.dispatchEvent(evt);", elemento,x,y);

         */
    }
}
