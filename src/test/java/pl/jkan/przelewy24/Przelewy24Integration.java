package pl.jkan.przelewy24;

import org.junit.Test;
import pl.jkan.przelewy24.Model.ApiResponse;
import pl.jkan.przelewy24.Model.RegisterPaymentData;
import pl.jkan.support.http.NativeHttpClient;

public class Przelewy24Integration {

    @Test
    public void registerTransaction() {
        Przelewy24Api api = new Przelewy24Api(Przelewy24Properties.ofEnvironment(), new NativeHttpClient());

        ApiResponse r = api.registerPayment(new RegisterPaymentData(
                "exampleSessionId",
                1000,
                "kanclerj@uek.krakow.pl",
                "http://jkan.pl",
                "some description",
                "http://jkan.pl/payment/verify"));

        String token = r.getValue("token");
        System.out.println(
                String.format("continue transaction here: https://sandbox.przelewy24.pl/trnRequest/%s", token));
    }
}
