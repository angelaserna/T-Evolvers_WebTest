package co.com.test.screenplay.stepdefinitions;


import co.com.test.screenplay.interactions.Select;
import co.com.test.screenplay.models.CreateReservation;
import co.com.test.screenplay.questions.Check;
import co.com.test.screenplay.tasks.Apply;
import co.com.test.screenplay.tasks.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ReservationHotelStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor actor = Actor.named("user");

    @Before
    public void configuracionInicial(){
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^The user enters the hotel reservation page$")
    public void theUserEntersTheHotelReservationPage() {
        actor.wasAbleTo(Open.url("https:/demos.devexpress.com/rwa/dxhotels/"));
    }


    @When("^Search for the hotel and specify the conditions$")
    public void searchForTheHotelAndSpecifyTheConditions(List<String> dataReservation) {
        CreateReservation.setReservation(dataReservation);
        actor.attemptsTo(Search.hotels(CreateReservation.getReservation()));
        actor.attemptsTo(Apply.filters(CreateReservation.getReservation()));
    }

    @When("^look for the best option and make the reservation$")
    public void lookForTheBestOptionAndMakeTheReservation() {
        actor.attemptsTo(Select.theBestOption(CreateReservation.getReservation()));
    }

    @Then("^validates the successful reservation$")
    public void validatesTheSuccessfulReservation() {
        String expectedHotelName = CreateReservation.getReservation().getHotelName();
        actor.should(GivenWhenThen.seeThat(Check.reservation(expectedHotelName)));
    }

}
