package pl.jkan.carrental.rental;

public interface OfferMaker {
    Offer generateOffer(String carId, int days);
}
