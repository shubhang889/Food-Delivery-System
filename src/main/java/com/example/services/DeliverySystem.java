package com.example.services;

import com.example.entities.Delivery;
import com.example.entities.Driver;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DeliverySystem {
    private Map<Integer, Driver> drivers = new HashMap<>();
    private double totalCost = 0.0;
    private double totalUnpaidCost = 0.0;
    private PriorityQueue<Delivery> unpaidDeliveries = 
                        new PriorityQueue<>(Comparator.comparingLong(Delivery::getDeliveryEndTime));

    public void addDriver(int driverId, double hourlyRate)  {
        if (!drivers.containsKey(driverId)) {
            drivers.put(driverId, new Driver(driverId, hourlyRate));
        }
    }

    public void recordDelivery(int driverId, long startTime, long endTime)  {
        Driver driver = drivers.get(driverId);
        if (driver != null) {
            long totalTime = endTime - startTime;
            double cost = totalTime * driver.getHourlyRate() / 3600.0;
            Delivery delivery = new Delivery(cost, endTime);
            driver.addDelivery(delivery);
            totalCost += cost;
            totalUnpaidCost += cost;
            unpaidDeliveries.add(delivery);
        }
    }

    public double getTotalCost() {
        return Math.round(totalCost * 100.0) / 100.0;
    }

    public void payUpTo(long payTime) {
        while (!unpaidDeliveries.isEmpty() && unpaidDeliveries.peek().getDeliveryEndTime() <= payTime) {
            Delivery deliveryToPay = unpaidDeliveries.poll();
            if (!deliveryToPay.isPaid()) {
                deliveryToPay.setPaid(true);
                totalUnpaidCost -= deliveryToPay.getEarnedCost();
            }
        }
    }

    public double getTotalCostUnpaid() {
        return Math.round(totalUnpaidCost * 100.0) / 100.0;
    }
}
