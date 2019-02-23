package pl.jkan.carrental.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jkan.carrental.carmodel.Car;
import pl.jkan.carrental.carrepository.CarRepository;

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

        return carRepo.findById(id).get();
    }

    @Override
    public List<Car> list() {

        List<Car> listOfCars = new ArrayList<>();
        carRepo.findAll().forEach(car -> listOfCars.add(car));
        return listOfCars;
    }

    @Override
    public void update(long id, Car car) {
       Car carToBeUpdated = carRepo.findById(id).get();
       carToBeUpdated = carRepo.save(car);
    }

    @Override
    public void delete(long id) {
        carRepo.delete(carRepo.findById(id).get());
    }
}
