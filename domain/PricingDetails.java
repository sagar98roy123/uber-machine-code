package com.sagarroy.machine_coding.uber.domain;

import lombok.Data;

@Data
public class PricingDetails {
    private double fare;
    private double distance;
    private double surgeMultiplier;
    private String currency;

    public PricingDetails(double fare, double distance, double duration){
        this.fare = fare;
        this.distance = distance;
        this.surgeMultiplier = 1.0;
        this.currency = "INR";
    }
}
