package pl.jkan.carrental;

import org.junit.Assert;
import org.junit.Test;

public class OrderingTest {
    @Test
    public void rentTheCarBasedOnOrderingData() {
        ReservationRequest reservationInfo = clientProvidedRentalInformation();

        OrderingApi api = thereIsOrderingApi();

        ReservationConfirmation confirmation = api.handleReservation(reservationInfo);

        Assert.assertTrue(
                confirmation.getPaymentUrl()
                        .startsWith("https://sandbox.przelewy24.pl"));
    }

    private OrderingApi thereIsOrderingApi() {
        return new OrderingApi(
                (a, b, c) -> new Payment("fake-payment", "https://sandbox.przelewy24.pl"),
                (a, b) -> new Offer(2000),
                new ReservationRepository() {
                    @Override
                    public void save(Reservation r) {

                    }
                }
        );
    }

    private ReservationRequest clientProvidedRentalInformation() {
        return ReservationRequest.builder()
                .carId("volvo-xc60-1")
                .clientData(ClientData.builder()
                    .email("jakub.kanclerz@gmail.com")
                    .firstName("Jakub")
                    .lastName("Kanclerz")
                    .build())
                .days(7)
                .build();
    }
}
