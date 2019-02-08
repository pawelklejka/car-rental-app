package pl.jkan.carrental.rental.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jkan.carrental.rental.cardao.CarRepository;
import pl.jkan.carrental.rental.carmodel.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImplementation implements CarService {

    @Autowired
    CarRepository carRepo;

    @Override
    public void save(Car car) {

        carRepo.save(car);
    }

    @Override
    public Car get(long id) {

        return carRepo.findById(String.valueOf(id)).get();
    }

    @Override
    public List<Car> list() {

        List<Car> listOfCars = new ArrayList<>();
        carRepo.findAll().forEach(car -> listOfCars.add(car));
        return listOfCars;
    }

    @Override
    public void update(long id, Car car) {
       Car carToBeUpdated = carRepo.findById(String.valueOf(id)).get();
       carToBeUpdated = carRepo.save(car);
    }

    @Override
    public void delete(long id) {
        Car carToBeDeleted = carRepo.findById(String.valueOf(id)).get();
        carRepo.delete(carToBeDeleted);
    }
}
