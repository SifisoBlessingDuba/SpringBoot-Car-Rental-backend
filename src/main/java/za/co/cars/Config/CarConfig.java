package za.co.cars.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.cars.domain.Car;
import za.co.cars.domain.Customer;
import za.co.cars.repository.CarRepository;
import za.co.cars.repository.CustomerRepository;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner run(CarRepository carRepository, CustomerRepository customerRepository) {
        return args -> {

            // Create a sample Customer (replace with your actual customer or get from DB)
            Customer customer = new Customer.Builder()
                    //.setId(2)  // assuming this ID exists or null if new
                    .setName("Sifiso")
                    .setSurname("Duba")
                    .setEmail("sifiso@example.com")
                    .setPhone("0712345678")
                    .setAddress("Cape Town")
                    .build();

            Customer savedCustomer = customerRepository.save(customer);
            // Create a Car using Builder pattern
            Car car = new Car.Builder()
                   // .setCarId(1)           // if you want to set ID manually, or omit for auto-generated
                    .setCarName("Toyota")
                    .setCarModel("Corolla")
                    .setCarColour("White")
                    .setCustomer(customer)
                    .build();

            // Save the car to repository
            carRepository.save(car);

            System.out.println("Test car saved: " + car);
        };
    }
}
