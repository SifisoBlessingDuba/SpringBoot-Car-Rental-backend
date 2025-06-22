package za.co.cars.service;

import za.co.cars.domain.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer, Integer> {

    List<Customer> findAll();
}
