package za.co.cars.Factory;

import za.co.cars.Helper;
import za.co.cars.domain.Car;
import za.co.cars.domain.Customer;

public class CarFactory {
    public static Car createCar(Integer carId, String carName, String carModel, String carColour, Customer customer){
        if(!Helper.isValidErfNumber(carId) ||
        Helper.isNullOrEmpty(carName) ||
        Helper.isNullOrEmpty(carModel) ||
        Helper.isNullOrEmpty(carColour)){
            return null;
        }

        return new Car.Builder()
                .setCarId(carId)
                .setCarName(carName)
                .setCarModel(carModel)
                .setCarColour(carColour)
                .setCustomer(customer)
                .build();
    }
}
