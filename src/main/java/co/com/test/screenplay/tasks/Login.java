package co.com.test.screenplay.tasks;

/*
import co.com.test.screenplay.interactions.WaitInteraction;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.nio.channels.DatagramChannel;*/
import co.com.test.screenplay.interactions.WaitInteraction;
import co.com.test.screenplay.ui.DxHotelsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Login implements Task {

    private String email;
    private String password;
    //public WebDriver hisBrowser;
    //public Actor actor;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Performable user(String email, String password) {
        return Tasks.instrumented(Login.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(email).into(DxHotelsPage.EMAIL));
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("document.getElementById('HeaderControl_LogonControl_LoginFormLayout_txtPassword_I').value = arguments[0];", password);
        actor.attemptsTo(Click.on(DxHotelsPage.LOGIN_BTN));
        actor.attemptsTo(WaitInteraction.waitClass(5000));
    }
}
