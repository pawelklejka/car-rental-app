package pl.jkan.carrental.rental;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Reservation {
    String clientFirstName;
    int days;
    double price;
    Payment payment;

    public static ReservationBuilder builder() {
        return new ReservationBuilder();
    }

    static class ReservationBuilder {
        String clientFirstName;
        int days;
        double price;

        public ReservationBuilder duration(int days) {
            this.days = days;
            return this;
        }

        public ReservationBuilder pricePerDay(double pricePerDay) {
            this.price = pricePerDay;
            return this;
        }

        public ReservationBuilder clientFirstName(String clientFirstName) {
            this.clientFirstName = clientFirstName;
            return this;
        }

        public Reservation build() {
            if (clientFirstName.equals("Jakub")) {
                throw new IllegalArgumentException("Tego zioma nie oblslugujemy");
            }
            return new Reservation(clientFirstName, days, price);
        }
    }
}
