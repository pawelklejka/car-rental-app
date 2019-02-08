package pl.jkan.carrental.rental.carservice;

import pl.jkan.carrental.rental.carmodel.Car;

import java.util.List;

public interface CarService {
    //get all cars
    List<Car> list();
    //get specific car
    Car get(long carId);
    //save
    void save(Car car);
    //update
    void update(long id, Car car);
    //delete
    void delete(long id);

}
