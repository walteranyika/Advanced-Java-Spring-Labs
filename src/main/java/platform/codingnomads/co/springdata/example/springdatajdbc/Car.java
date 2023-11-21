package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Car {
    private Long id;
    private String make;
    private String model;
    private int price;

    public Car(Long id, String make, String model, int price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public Car(String make, String model, int price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }
}
