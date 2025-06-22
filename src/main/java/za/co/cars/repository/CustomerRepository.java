package za.co.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cars.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Override
    Customer save (Customer customer);
    @Override
    void deleteById(Integer id);
    @Override
    Optional<Customer> findById(Integer id);
    @Override
    List<Customer> findAll();
}
