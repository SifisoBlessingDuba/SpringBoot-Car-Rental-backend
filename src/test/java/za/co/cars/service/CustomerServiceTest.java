package za.co.cars.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.co.cars.domain.Customer;
import za.co.cars.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customer = new Customer.Builder()
                .setId(1)
                .setName("Sifiso")
                .setSurname("Duba")
                .setEmail("sifiso@example.com")
                .setPhone("0712345678")
                .setAddress("Cape Town")
                .build();
    }

    @Test
    void testSaveCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer saved = customerService.save(customer);

        assertNotNull(saved);
        assertEquals("Sifiso", saved.toString().contains("Sifiso") ? "Sifiso" : null);
        verify(customerRepository).save(customer);
    }

    @Test
    void testUpdateCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updated = customerService.update(customer);

        assertNotNull(updated);
        assertEquals("Duba", updated.toString().contains("Duba") ? "Duba" : null);
        verify(customerRepository).save(customer);
    }

    @Test
    void testDeleteCustomer() {
        Integer id = 1;
        doNothing().when(customerRepository).deleteById(id);

        customerService.delete(id);

        verify(customerRepository, times(1)).deleteById(id);
    }

    @Test
    void testFindById_Exists() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer found = customerService.findById(1);

        assertNotNull(found);
        assertEquals("sifiso@example.com", found.toString().contains("sifiso@example.com") ? "sifiso@example.com" : null);
        verify(customerRepository).findById(1);
    }

    @Test
    void testFindById_NotExists() {
        when(customerRepository.findById(2)).thenReturn(Optional.empty());

        Customer found = customerService.findById(2);

        assertNull(found);
        verify(customerRepository).findById(2);
    }

    @Test
    void testFindAll_ReturnsEmptyList() {
        List<Customer> result = customerService.findAll();
        assertTrue(result.isEmpty());
    }
}
