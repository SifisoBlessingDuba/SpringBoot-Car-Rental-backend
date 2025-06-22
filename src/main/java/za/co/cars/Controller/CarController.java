package za.co.cars.Controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.cars.domain.Car;
import za.co.cars.domain.Customer;
import za.co.cars.service.CarService;

@RestController
@RequestMapping("/Car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }
    @PostMapping("/add")
    public Car getCars(@RequestBody Car car){
        return carService.save(car);
    }
    @DeleteMapping("/deleteCar{carId}")
    public void deleteCar(@PathVariable Integer carId){
        carService.delete(carId);
    }
    @PostMapping("/update")
    public Car updateCar(@RequestBody Car car){
        return carService.update(car);
    }
    @GetMapping("/readCar{carId}")
    public Car read(@PathVariable Integer carId){
        return carService.findById(carId);
    }
    @GetMapping("/allCars")
    public Iterable<Car> getAllCars(){
        return carService.findAll();
    }

}
