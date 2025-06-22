package za.co.cars.service;

import za.co.cars.domain.Car;

import java.util.List;

public interface ICarService extends IService<Car, Integer> {
    List<Car> findAll();
}
