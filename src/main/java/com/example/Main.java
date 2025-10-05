package com.example;

import com.example.services.DeliverySystem;

public class Main {
    public static void main(String[] args) {
        DeliverySystem deliverySystem = new DeliverySystem();

        deliverySystem.addDriver(1, 35.10);
        deliverySystem.addDriver(2, 15.15);
        deliverySystem.addDriver(3, 8.55);
        deliverySystem.addDriver(4, 11.28);
        deliverySystem.addDriver(5, 0.1);

        System.out.println("Initial Total Cost: " + deliverySystem.getTotalCost());

        deliverySystem.recordDelivery(1, 0, 3600);
        deliverySystem.recordDelivery(5, 0, 3600);
        deliverySystem.recordDelivery(2, 0, 5400);
        deliverySystem.recordDelivery(2, 5400, 7200);
        deliverySystem.recordDelivery(5, 3600, 7200);
        deliverySystem.recordDelivery(5, 7200, 10800);
        deliverySystem.recordDelivery(5, 10800, 14400);
        deliverySystem.recordDelivery(5, 14400, 18000);

        System.out.println("Total Cost after deliveries: " + String.format("%.2f", deliverySystem.getTotalCost()));
        System.out.println("Total Unpaid Cost: " + String.format("%.2f", deliverySystem.getTotalCostUnpaid()));

        System.out.println("\nPaying deliveries up to 7200...");
        deliverySystem.payUpTo(7200);

        System.out.println("Total Cost after partial payment: " + String.format("%.2f", deliverySystem.getTotalCost()));
        System.out.println("Total Unpaid Cost after partial payment: " + String.format("%.2f", deliverySystem.getTotalCostUnpaid()));

        System.out.println("\nPaying all remaining deliveries...");
        deliverySystem.payUpTo(Long.MAX_VALUE);

        System.out.println("Total Cost after final payment: " + String.format("%.2f", deliverySystem.getTotalCost()));
        System.out.println("Total Unpaid Cost after final payment: " + String.format("%.2f", deliverySystem.getTotalCostUnpaid()));
    }
}
