package pl.jkan.carrental.rental;

import org.junit.Test;

public class ReservationTest {
    @Test
    public void createReservation() {
        Reservation r = new Reservation();
        r.setClientFirstName("Jakub");
        r.setDays(2);
        r.setPrice(200);

        Reservation r2 = Reservation.builder()
            .duration(2)
            .pricePerDay(200)
            .clientFirstName("Jakub")
            .build();


    }
}
