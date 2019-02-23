package pl.jkan.carrental;

public interface OfferMaker {
    Offer generateOffer(String carId, int days);
}
