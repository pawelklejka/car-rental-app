package pl.jkan.carrental.rental.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jkan.carrental.rental.cardao.CarRepository;
import pl.jkan.carrental.rental.carmodel.Car;

import java.util.List;

public class CarServiceImplementation implements CarService {

    @Autowired
    CarRepository carRepo;

    @Override
    public long save(Car car) {

        return carRepo.save(car);
    }

    @Override
    public Car get(long id) {

        return carRepo.get(id);
    }

    @Override
    public List<Car> list() {
        return carRepo.list();
    }

    @Override
    public void update(long id, Car car) {

        carRepo.update(id, car);
    }

    @Override
    public void delete(long id) {
        carRepo.delete(id);
    }
}
