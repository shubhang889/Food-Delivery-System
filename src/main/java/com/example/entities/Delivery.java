package com.example.entities;

public class Delivery {
    private double earnedCost;
    private long deliveryEndTime;
    private boolean isPaid;

    public Delivery(double earnedCost, long deliveryEndTime) {
        this.earnedCost = earnedCost;
        this.deliveryEndTime = deliveryEndTime;
        this.isPaid = false;
    }

    public long getDeliveryEndTime() {
        return this.deliveryEndTime;
    }

    public double getEarnedCost() {
        return this.earnedCost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
