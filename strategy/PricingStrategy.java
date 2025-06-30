package com.sagarroy.machine_coding.uber.strategy;

import com.sagarroy.machine_coding.uber.domain.Location;
import com.sagarroy.machine_coding.uber.domain.PricingDetails;
import com.sagarroy.machine_coding.uber.domain.Rider;

public interface PricingStrategy {
    PricingDetails calculatePrice(Location pickup, Location drop, Rider rider);
}
