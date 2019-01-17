package pl.jkan.carrental.rentalapp.carcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
class CarController {
    @Autowired
    CarRepository carRepository;

    //list
    @GetMapping("/cars")
    List<Car> list() {
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    void create(@RequestBody Car car) {
        carRepository.save(car);
    }

    @GetMapping("/cars/{id}")
    Car details(@PathVariable String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such car"));
    }

    @DeleteMapping("/cars/{id}")
    void delete(@PathVariable String id) {
        carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such car"));

        carRepository.deleteById(id);
    }

    @PutMapping("/cars/{id}")
    void update(@PathVariable String id, @RequestBody Car car) {
        Car loaded = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such car"));

        loaded.setCapacity(car.getCapacity());
        loaded.setModel(car.getModel());
        loaded.setManufactureYear(car.getManufactureYear());
        loaded.setSegemnt(car.getSegemnt());
        loaded.setName(car.getName());

        carRepository.save(loaded);
    }
}
