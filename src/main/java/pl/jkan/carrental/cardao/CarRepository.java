package pl.jkan.carrental.cardao;


import org.springframework.data.repository.CrudRepository;
import pl.jkan.carrental.carmodel.Car;


public interface CarRepository extends CrudRepository<Car, Long> {

}
