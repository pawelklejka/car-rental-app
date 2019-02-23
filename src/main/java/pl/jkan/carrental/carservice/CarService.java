package pl.jkan.carrental.carservice;

import pl.jkan.carrental.carmodel.Car;

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
