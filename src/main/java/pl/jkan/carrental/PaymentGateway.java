package pl.jkan.carrental;

public interface PaymentGateway {
    Payment registerPayment(String reservationId, ClientData clientData, double offerValue);
}
