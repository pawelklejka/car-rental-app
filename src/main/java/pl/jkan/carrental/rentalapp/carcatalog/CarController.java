package pl.jkan.carrental.rentalapp.carcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
class CarController {
    @Autowired
    CarRepository carRepository;

    //list
    @GetMapping("/cars")
    Iterable<Car> list() {
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

@FunctionalInterface
interface DiscountPolicy {
    public double applyDiscount(double input);
}


class Handler {

    public Handler(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    DiscountPolicy discountPolicy;

    public void handle() {
        double price = 200;

        double toBePaid = discountPolicy.applyDiscount(price);
    }
}


class App {
    public static void main(String[] args) {
        Handler handler = new Handler((price) -> price - price * 0.2);
        handler.handle();
    }
}














































