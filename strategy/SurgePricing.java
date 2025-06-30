package com.sagarroy.machine_coding.uber.strategy;

import com.sagarroy.machine_coding.uber.domain.Location;
import com.sagarroy.machine_coding.uber.domain.PricingDetails;
import com.sagarroy.machine_coding.uber.domain.Rider;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SurgePricing extends StandardPricing {
    private double surgeMultiplier;

    @Override
    public PricingDetails calculatePrice(Location pickup, Location drop, Rider rider) {
        PricingDetails basePrice = super.calculatePrice(pickup, drop, rider);
        basePrice.setFare(basePrice.getFare() * surgeMultiplier);
        return basePrice;
    }
}
