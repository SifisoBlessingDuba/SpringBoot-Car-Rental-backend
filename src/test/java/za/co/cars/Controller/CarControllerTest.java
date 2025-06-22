package za.co.cars.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import za.co.cars.domain.Car;
import za.co.cars.domain.Customer;
import za.co.cars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    private Car testCar;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer.Builder()
                .setId(1)
                .setName("Sifiso")
                .setSurname("Duba")
                .setEmail("sifiso@example.com")
                .setPhone("0712345678")
                .setAddress("Cape Town")
                .build();

        testCar = new Car.Builder()
                .setCarId(1)
                .setCarName("Toyota")
                .setCarModel("Corolla")
                .setCarColour("White")
                .setCustomer(customer)
                .build();
    }

    @Test
    void testAddCar() throws Exception {
        when(carService.save(any(Car.class))).thenReturn(testCar);

        mockMvc.perform(post("/Car/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carName").value("Toyota"));
    }

    @Test
    void testDeleteCar() throws Exception {
        doNothing().when(carService).delete(1);

        mockMvc.perform(delete("/Car/deleteCar1"))
                .andExpect(status().isOk());

        verify(carService).delete(1);
    }

    @Test
    void testUpdateCar() throws Exception {
        when(carService.update(any(Car.class))).thenReturn(testCar);

        mockMvc.perform(post("/Car/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carModel").value("Corolla"));
    }

    @Test
    void testReadCar() throws Exception {
        when(carService.findById(1)).thenReturn(testCar);

        mockMvc.perform(get("/Car/readCar1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carColour").value("White"));
    }

    @Test
    void testGetAllCars() throws Exception {
        when(carService.findAll()).thenReturn(List.of(testCar));

        mockMvc.perform(get("/Car/allCars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].carName").value("Toyota"));
    }
}
