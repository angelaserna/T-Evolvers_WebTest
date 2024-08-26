package co.com.test.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectCalendar implements Interaction {

    private String date;

    public SelectCalendar(String date){
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Date fecha;

        try {
            Format formatter = new SimpleDateFormat("dd/MMMM/yyyy");
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(this.date);
            this.date = formatter.format(fecha);
            this.date = this.date.replaceFirst(this.date.substring(3,4),this.date.substring(3,4).toUpperCase());

            if("0".equals(this.date.substring(0,1))){
                this.date = this.date.substring(1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Performable enterDate(String date) {
        return Tasks.instrumented(SelectCalendar.class, date);
    }
}
