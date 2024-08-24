package co.com.test.screenplay.models;

import java.util.List;

public class CreateReservation {

    private static Reservation reservation = new Reservation();

    private CreateReservation(){
    }

    public static Reservation getReservation(){
        return reservation;
    }

    public static void setReservation(List<String> dataReservation) {
        Reservation reservation = new Reservation();
        reservation.setLocation(dataReservation.get(0));
        reservation.setCheckin(dataReservation.get(1));
        reservation.setCheckout(dataReservation.get(2));
        reservation.setRooms(dataReservation.get(3));
        reservation.setAdults(dataReservation.get(4));
        reservation.setChildren(dataReservation.get(5));
        reservation.setRate_min(dataReservation.get(6));
        reservation.setRate_max(dataReservation.get(7));
        reservation.setScore(dataReservation.get(8));
        CreateReservation.reservation = reservation;
    }
}
