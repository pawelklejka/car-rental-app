package pl.jkan.carrental.rental.carcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jkan.carrental.rental.carmodel.Car;
import pl.jkan.carrental.rental.carservice.CarService;

import java.util.List;

@RestController
class CarController {

    @Autowired
    CarService carService;

    //get all cars
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> list() {
        List<Car> list = carService.list();
        ResponseEntity allCars = ResponseEntity.ok().body(list);
        return allCars;
    }
    //save car
    @PostMapping("/cars")
    public ResponseEntity<?> save(@RequestBody Car car) {
        long id = carService.save(car);
        ResponseEntity savedCar = ResponseEntity.ok()
                                                .body("card with id: " + " has been saved");
        return savedCar;
    }
    //get single car record
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> get(@PathVariable("id") long id) {
        Car car = carService.get(id);
        ResponseEntity singleCarRecord = ResponseEntity.ok().body(car);

        return singleCarRecord;
                //.orElseThrow(() -> new RuntimeException("no such car"));
    }
    //delete single record
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        carService.delete(id);
        ResponseEntity deletedCar = ResponseEntity.ok()
                                                .body("car with id " + id + "has been deleted");                
        return deletedCar;
                //.orElseThrow(() -> new RuntimeException("no such car"));
        
    }
    //update single record
    @PutMapping("/cars/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Car car) {
        carService.update(id, car);
                //.orElseThrow(() -> new RuntimeException("no such car"));
        ResponseEntity updatedCard = ResponseEntity.ok().body("car has been updated");
        return updatedCard;
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














































