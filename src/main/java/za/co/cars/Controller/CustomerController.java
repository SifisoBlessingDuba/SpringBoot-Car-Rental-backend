package za.co.cars.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.cars.domain.Customer;
import za.co.cars.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @PostMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.update(customer);
    }
    @DeleteMapping("/deleteCustomer{ID}")
    public void deleteCustomer(@PathVariable Integer ID){
        customerService.delete(ID);
    }
    @GetMapping("/readCustomer{ID}")
    public Customer readCustomer(@PathVariable Integer ID){
        return customerService.findById(ID);
    }
    @GetMapping("/allCustomers")
    public Iterable<Customer> getAllCustomers(){
        return customerService.findAll();
    }
}
