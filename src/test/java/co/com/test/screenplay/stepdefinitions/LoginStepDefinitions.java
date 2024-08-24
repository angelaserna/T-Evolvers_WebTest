package co.com.test.screenplay.stepdefinitions;

import co.com.test.screenplay.questions.Validate;
import co.com.test.screenplay.tasks.BannerTo;
import co.com.test.screenplay.tasks.Login;
import co.com.test.screenplay.ui.DxHotelsPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor actor = Actor.named("user");

    @Before
    public void configuracionInicial(){
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @When("^I authenticate in Demo DX Hotels with (.*) and (.*)$")
    public void iAuthenticateInDemoDXHotelsWithTestTestComAnd(String email, String password) {
        actor.attemptsTo(BannerTo.login());
        actor.attemptsTo(Login.user(email, password));
    }

    @Then("^I verify the result obtained from the authentication$")
    public void iVerifyTheResultObtainedFromTheAuthentication() {
        String expectedResult = "The submitted code is incorrect";
        actor.should(GivenWhenThen.seeThat(Validate.message(expectedResult, DxHotelsPage.FAILED_MESSAGE)));
    }
}
