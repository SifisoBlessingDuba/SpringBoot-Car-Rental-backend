package za.co.cars.domain;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String carName;
    private String carModel;
    private String carColour;
    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;


    protected Car() {

    }
    private Car(Builder builder) {
        this.carId = builder.carId;
        this.carName = builder.carName;
        this.carModel = builder.carModel;
        this.carColour = builder.carColour;
        this.customer = builder.customer;
    }

    public Integer getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarColour() {
        return carColour;
    }
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carColour='" + carColour + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{
        private Integer carId;
        private String carName;
        private String carModel;
        private String carColour;
        private Customer customer;

        public Builder setCarId(Integer carId){
            this.carId = carId;
            return this;
        }
        public Builder setCarName(String carName){
            this.carName = carName;
            return this;
        }
        public Builder setCarModel(String carModel){
            this.carModel = carModel;
            return this;
        }
        public Builder setCarColour(String carColour){
            this.carColour = carColour;
            return this;
        }
        public Builder setCustomer(Customer customer){
            this.customer = customer;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }

}
