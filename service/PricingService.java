package com.sagarroy.machine_coding.uber.service;

import com.sagarroy.machine_coding.uber.domain.Location;
import com.sagarroy.machine_coding.uber.domain.PricingDetails;
import com.sagarroy.machine_coding.uber.domain.Rider;
import com.sagarroy.machine_coding.uber.strategy.PricingStrategy;
import com.sagarroy.machine_coding.uber.strategy.PricingStrategyFactory;

public class PricingService {
    private static PricingService instance;

    private PricingService() {}

    public static synchronized PricingService getInstance() {
        if (instance == null) {
            instance = new PricingService();
        }
        return instance;
    }

    public PricingDetails calculatePrice(Location pickup, Location drop, Rider rider) {
        boolean isSurge = checkSurgePricing(pickup);
        double surgeMultiplier = getSurgeMultiplier(pickup);
        PricingStrategy pricingStrategy =
                PricingStrategyFactory.getPricingStrategy(isSurge, surgeMultiplier);
        return pricingStrategy.calculatePrice(pickup, drop, rider);
    }

    private double getSurgeMultiplier(Location pickup) {
        return 1.5; // hardcoded but should be dynamic
    }

    private boolean checkSurgePricing(Location pickup) {
        // This should be calculated by another service or microservice
        return Math.random() > 0.7; // hardcoded chance of surge is 30%
    }
}