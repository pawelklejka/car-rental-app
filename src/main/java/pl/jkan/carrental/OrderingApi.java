package pl.jkan.carrental;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
class OrderingApi {

    PaymentGateway paymentGateway;
    OfferMaker offerMaker;
    ReservationRepository reservationRepository;

    public OrderingApi(PaymentGateway paymentGateway, OfferMaker offerMaker, ReservationRepository reservationRepository) {
        this.paymentGateway = paymentGateway;
        this.offerMaker = offerMaker;
        this.reservationRepository = reservationRepository;
    }

    public ReservationConfirmation handleReservation(ReservationRequest reservationInfo) {

        Offer offer = this.offerMaker.generateOffer(
                reservationInfo.getCarId(),
                reservationInfo.days);


        String reservationId = UUID.randomUUID().toString();
        Reservation r = Reservation.builder()
            .id(reservationId)
            .payment(this.paymentGateway.registerPayment(
                    reservationId,
                    reservationInfo.getClientData(),
                    offer.getValue()
            ))
            .carId(reservationInfo.carId)
            .build();

        reservationRepository.save(r);

        return ReservationConfirmation.builder()
                .paymentUrl(r.getPayment().getFinalizationUrl())
                .build();
    }
}
