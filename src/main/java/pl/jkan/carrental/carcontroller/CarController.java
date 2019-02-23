package pl.jkan.carrental.carcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jkan.carrental.carservice.CarService;
import pl.jkan.carrental.carmodel.Car;

import java.util.List;

@RestController
class CarController {

    @Autowired
    CarService carService;

    //get all cars
    @GetMapping("/cars")
    public Iterable list() {
        List<Car> list = carService.list();
        return list;
    }
    //save car
    @PostMapping("/cars")
    public void save(@RequestBody Car car) {
        carService.save(car);


    }
    //get single car record
    @GetMapping("/cars/{id}")
    public Car get(@PathVariable("id") long id) {
        return carService.get(id);
                //.orElseThrow(() -> new RuntimeException("no such car"));
    }
    //delete single record
    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable("id") long id) {
        carService.delete(id);
                //.orElseThrow(() -> new RuntimeException("no such car"));
        
    }
    //update single record
    @PutMapping("/cars/{id}")
    public void update(@PathVariable long id, @RequestBody Car car) {
        Car loaded = carService.get(id);
                //orElseThrow(() -> new RuntimeException("no such car"));

        loaded.setCapacity(car.getCapacity());
        loaded.setModel(car.getModel());
        loaded.setManufactureYear(car.getManufactureYear());
        loaded.setSegment(car.getSegment());
        loaded.setName(car.getName());

        carService.save(loaded);
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














































