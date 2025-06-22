package za.co.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cars.domain.Car;
import za.co.cars.repository.CarRepository;

import java.util.List;

@Service
public class CarService implements ICarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Integer integer) {
        carRepository.deleteById(integer);
    }

    @Override
    public Car findById(Integer integer) {
        return carRepository.findById(integer).orElse(null);
    }
}
