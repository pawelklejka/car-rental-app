package pl.jkan.carrental.rental.cardao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jkan.carrental.rental.carmodel.Car;

import java.util.List;


public interface CarRepository extends CrudRepository<Car, Long> {

}
