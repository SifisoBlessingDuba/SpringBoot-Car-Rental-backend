package za.co.cars.Factory;

import za.co.cars.Helper;
import za.co.cars.domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(Integer id,String name,String email,String phone,String address,String surname){
        if(!Helper.isValidErfNumber(id) ||
        Helper.isNullOrEmpty(name) ||
         Helper.isNullOrEmpty(email) ||
         Helper.isNullOrEmpty(phone) ||
         Helper.isNullOrEmpty(address) ||
         Helper.isNullOrEmpty(surname)){
            return null;
        }
        return new Customer.Builder()
                .setId(id)
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setAddress(address)
                .setSurname(surname)
                .build();
    }
}
