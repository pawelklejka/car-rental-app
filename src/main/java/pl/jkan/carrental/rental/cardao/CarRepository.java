package pl.jkan.carrental.rental.cardao;


import pl.jkan.carrental.rental.carmodel.Car;

import java.util.List;

public interface CarRepository {
    //Save the record
    long save(Car car);

    //Get a single record
    Car get(long id);

    //Get all the records
    List<Car> list();

    //Update the record
    void update(long id, Car car);

    //Delete a record
    void delete(long id);
}
