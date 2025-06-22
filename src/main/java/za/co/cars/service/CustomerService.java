package za.co.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cars.domain.Customer;
import za.co.cars.repository.CustomerRepository;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer ID) {
        customerRepository.deleteById(ID);
    }

    @Override
    public Customer findById(Integer ID) {
        return customerRepository.findById(ID).orElse(null);
    }
}
