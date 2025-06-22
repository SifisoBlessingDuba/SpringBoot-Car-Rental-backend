package za.co.cars.Factory;

import org.junit.jupiter.api.Test;
import za.co.cars.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void createCar() {
        Car car = CarFactory.createCar(1,"Toyota","Corolla","Blue",null);
        assertNotNull(car);
        System.out.println(car);
    }
}