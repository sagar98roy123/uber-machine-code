package com.sagarroy.machine_coding.uber.strategy;

import com.sagarroy.machine_coding.uber.domain.Location;
import com.sagarroy.machine_coding.uber.domain.PricingDetails;
import com.sagarroy.machine_coding.uber.domain.Rider;

public class StandardPricing implements PricingStrategy {
    private static final double BASE_FARE = 2.0;
    private static final double PER_MILE_RATE = 1.5;
    private static final double PER_MINUTE_RATE = 0.3;

    @Override
    public PricingDetails calculatePrice(Location pickup, Location drop, Rider rider) {
        double distance = pickup.distanceTo(drop);
        double estimatedTime = distance * 2; // Simplified time estimation

        double fare = BASE_FARE + (distance * PER_MILE_RATE) + (estimatedTime * PER_MINUTE_RATE);

        return new PricingDetails(fare, distance, estimatedTime);
    }
}
