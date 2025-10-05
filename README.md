# Delivery Cost System

## Problem Description

Food delivery companies employ tens of thousands of delivery drivers who
each submit hundreds of deliveries per week.\
Delivery details are automatically sent to the system immediately after
the delivery.

Delivery drivers have different hourly payment rates, depending on their
performance.\
Drivers can take on, and be paid for, multiple deliveries
simultaneously.

If a driver is paid \$10.00 per hour, and a delivery takes 1 hour and 30
minutes, the driver is paid \$15.00 for that delivery.

We are building a dashboard to show a single number --- the total cost
of all deliveries --- on screens in the accounting department offices.

------------------------------------------------------------------------

## Functions (Phase 1)

### `addDriver(driverId: integer, usdHourlyRate: double)`

-   The given driver will not already be in the system.
-   The hourly rate applies per delivery, and a driver can be paid for
    simultaneous deliveries.

### `recordDelivery(driverId: integer, startTime, endTime)`

-   Discuss the time format you choose.
-   Times require minimum one-second precision.
-   The given driver will already be in the system.
-   All deliveries will be recorded immediately after the delivery is
    completed.
-   No delivery will exceed 3 hours.

### `getTotalCost()`

-   Return the total, aggregated cost of all drivers' deliveries
    recorded in the system.
-   Example: return `135.30` if one driver has a total cost of `100.30`
    and another `35.00`.
-   This will be used for a live dashboard.
-   Do not worry about exact formatting.

------------------------------------------------------------------------

## Note

All inputs will be valid.

If you do anything differently in this interview than you would in
production, share that.

We want to see **good OOP practices**.

------------------------------------------------------------------------

## Extended Requirement (Phase 2)

The accounting department now wants to use the live dashboard to see how
much money is owed in total to all drivers.

Add the following functions:

### `payUpTo(payTime)`

-   Pay all drivers for recorded deliveries which ended up to and
    including the given time.

### `getTotalCostUnpaid()`

-   Return the total, aggregated cost of all drivers' deliveries which
    have **not been paid**.

> The solution does not need to be thread-safe or handle concurrency.
