package za.co.cars.Factory;

import org.junit.jupiter.api.Test;
import za.co.cars.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createCustomer() {
        Customer customer = CustomerFactory.createCustomer(1,"Sifiso","Sifiso@gmail.com","0721234567","123456789","Sifiso");
        assertNotNull(customer);
        System.out.println(customer);
    }
}