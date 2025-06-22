package za.co.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cars.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Override
    Car save (Car car);

    @Override
    void deleteById(Integer id);

    @Override
    Optional<Car> findById(Integer id);

    @Override
    List<Car> findAll();

}
