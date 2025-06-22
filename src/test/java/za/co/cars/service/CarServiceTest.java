package za.co.cars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.co.cars.domain.Car;
import za.co.cars.domain.Customer;
import za.co.cars.repository.CarRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    private Car testCar;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Customer customer = new Customer(); // You can add ID, name, etc., if needed
        testCar = new Car.Builder()
                .setCarId(1)
                .setCarName("VW")
                .setCarModel("Polo")
                .setCarColour("White")
                .setCustomer(customer)
                .build();
    }

    @Test
    void testFindAll() {
        List<Car> carList = List.of(testCar);
        when(carRepository.findAll()).thenReturn(carList);

        List<Car> result = carService.findAll();

        assertEquals(1, result.size());
        assertEquals("VW", result.get(0).getCarName());
        verify(carRepository).findAll();
    }

    @Test
    void testSaveCar() {
        when(carRepository.save(testCar)).thenReturn(testCar);

        Car saved = carService.save(testCar);

        assertNotNull(saved);
        assertEquals("Polo", saved.getCarModel());
        verify(carRepository).save(testCar);
    }

    @Test
    void testUpdateCar() {
        when(carRepository.save(testCar)).thenReturn(testCar);

        Car updated = carService.update(testCar);

        assertEquals("White", updated.getCarColour());
        verify(carRepository).save(testCar);
    }

    @Test
    void testDeleteCar() {
        Integer carId = 1;
        doNothing().when(carRepository).deleteById(carId);

        carService.delete(carId);

        verify(carRepository).deleteById(carId);
    }

    @Test
    void testFindCarByIdExists() {
        when(carRepository.findById(1)).thenReturn(Optional.of(testCar));

        Car found = carService.findById(1);

        assertNotNull(found);
        assertEquals("VW", found.getCarName());
        verify(carRepository).findById(1);
    }

    @Test
    void testFindCarByIdNotExists() {
        when(carRepository.findById(2)).thenReturn(Optional.empty());

        Car found = carService.findById(2);

        assertNull(found);
        verify(carRepository).findById(2);
    }
}
