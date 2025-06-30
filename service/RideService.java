package com.sagarroy.machine_coding.uber.service;

import com.sagarroy.machine_coding.uber.domain.*;

import java.util.List;
import java.util.Objects;

public class RideService {
    private static RideService instance;

    private RideService() {}
    ;

    public static synchronized RideService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new RideService();
        }
        return instance;
    }

    private MatchingService matchingService = MatchingService.getInstance();
    private PricingService pricingService = PricingService.getInstance();

    public Trip requestRide(Rider rider, Location pickup, Location drop) {
        PricingDetails pricingDetails = pricingService.calculatePrice(pickup, drop, rider);
        List<Driver> availableDrivers = matchingService.findNearByDrivers(pickup);
        Driver assignedDriver = availableDrivers.get(0);
        Trip trip = new Trip(rider, assignedDriver, pickup, drop, TripStatus.REQUESTED, pricingDetails);
        assignedDriver.notifyAboutRide(trip);
        return trip;
    }
}
