package co.com.test.screenplay.models;

public class Reservation {
    private String location;
    private String checkin;
    private String checkout;
    private String rooms;
    private String adults;
    private String children;
    private String rate_min;
    private String rate_max;
    private String score;

    private String hotelName;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getRate_min() {
        return rate_min;
    }

    public void setRate_min(String rate_min) {
        this.rate_min = rate_min;
    }

    public String getRate_max() {
        return rate_max;
    }

    public void setRate_max(String rate_max) {
        this.rate_max = rate_max;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
