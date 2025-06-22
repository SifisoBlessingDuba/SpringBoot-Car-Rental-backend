package za.co.cars.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cars.domain.Customer;
import za.co.cars.service.CustomerService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer.Builder()
                .setId(1)
                .setName("Sifiso")
                .setSurname("Duba")
                .setEmail("sifiso@example.com")
                .setPhone("0712345678")
                .setAddress("Cape Town")
                .build();
    }

    @Test
    void testSaveCustomer() throws Exception {
        when(customerService.save(any(Customer.class))).thenReturn(testCustomer);

        mockMvc.perform(post("/Customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sifiso"));
    }

    @Test
    void testUpdateCustomer() throws Exception {
        when(customerService.update(any(Customer.class))).thenReturn(testCustomer);

        mockMvc.perform(post("/Customer/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.surname").value("Duba"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        doNothing().when(customerService).delete(1);

        mockMvc.perform(delete("/Customer/deleteCustomer1"))
                .andExpect(status().isOk());

        verify(customerService).delete(1);
    }

    @Test
    void testReadCustomer() throws Exception {
        when(customerService.findById(1)).thenReturn(testCustomer);

        mockMvc.perform(get("/Customer/readCustomer1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("sifiso@example.com"));
    }

    @Test
    void testGetAllCustomers() throws Exception {
        when(customerService.findAll()).thenReturn(List.of(testCustomer));

        mockMvc.perform(get("/Customer/allCustomers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].phone").value("0712345678"));
    }
}
