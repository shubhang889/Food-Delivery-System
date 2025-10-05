package com.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private int driverId;
    private double hourlyRate;
    private List<Delivery> deliveries;

    public Driver(int driverId, double hourlyRate) {
        this.driverId = driverId;
        this.hourlyRate = hourlyRate;
        this.deliveries = new ArrayList<>();
    }

    public int getDriverId() {
        return driverId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }
}
