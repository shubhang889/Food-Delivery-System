package com.example;

import com.example.services.DeliverySystem;

/*
Food delivery companies employ tens of thousands of delivery drivers who each submit hundreds of deliveries per week.
Delivery details are automatically sent to the system immediately after the delivery.

Delivery drivers have different hourly payment rates, depending on their performance.
Drivers can take on, and be paid for, multiple deliveries simultaneously.

If a driver is paid $10.00 per hour, and a delivery takes 1 hour and 30 minutes, the driver is paid $15.00 for that delivery.

We are building a dashboard to show a single number - the total cost of all deliveries - on screens in the accounting department offices.

At first, we want the following functions:

* `addDriver(driverId [integer], usdHourlyRate [double])`
   - The given driver will not already be in the system
   - The hourly rate applies per delivery, and a driver can be paid for simultaneous deliveries

* `recordDelivery(driverId [integer], startTime, endTime)`
   - Discuss the time format you choose
   - Times require minimum one-second precision
   - The given driver will already be in the system
   - All deliveries will be recorded immediately after the delivery is completed
   - No delivery will exceed 3 hours

* `getTotalCost()`
   - Return the total, aggregated cost of all drivers' deliveries recorded in the system
   - For example, return 135.30 if one driver is in the system and has a total cost of 100.30 USD and another driver is in the system and has a total cost of 35.00 USD.
   - This will be used for a live dashboard
   - Do not worry about exact formatting

All inputs will be valid.

If you do anything differently in this interview than you would in production, share that.

Before you get started coding, and before we start using the AI assistant, let's discuss how you will store the time data and why.

We want to see good OOP practices.
*/



/*
The accounting department now wants to use the live dashboard you built to see how much money is owed in total to all drivers.

Add the following functions:

* `payUpTo (payTime)`
   - Pay all drivers for recorded deliveries which ended up to and including the given time

* `getTotalCostUnpaid()`
   - Return the total, aggregated cost of all drivers' deliveries which have not been paid

The solution does not need to be thread-safe or handle concurrency.
*/

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
