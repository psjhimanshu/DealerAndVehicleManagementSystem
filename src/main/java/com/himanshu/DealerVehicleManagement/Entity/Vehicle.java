package com.himanshu.DealerVehicleManagement.Entity;

import com.himanshu.DealerVehicleManagement.Enum.VehicleStatus;
import jakarta.persistence.*;

import java.util.concurrent.Delayed;

@Entity
public class Vehicle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Double price;

    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    @ManyToOne
    @JoinColumn(name = "dealer_id",nullable = false)
    private Dealer dealer;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", vehicleStatus=" + vehicleStatus +
                ", dealer=" + dealer +
                '}';
    }

    public Vehicle(Long id, String model, Double price, VehicleStatus vehicleStatus, Dealer dealer) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.vehicleStatus = vehicleStatus;
        this.dealer = dealer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
