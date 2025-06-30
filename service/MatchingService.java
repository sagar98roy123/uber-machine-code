package com.sagarroy.machine_coding.uber.service;

import com.sagarroy.machine_coding.uber.domain.Driver;
import com.sagarroy.machine_coding.uber.domain.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MatchingService {
    private static MatchingService instance;

    private MatchingService(){

    }

    public static synchronized MatchingService getInstance(){
        if(Objects.isNull(instance)){
            instance = new MatchingService();
        }
        return instance;
    }

    public List<Driver> findNearByDrivers(Location pickup) {
        List<Driver> nearByDrivers = new ArrayList<>();
        List<Driver> allDrivers = DriverManager.getAvailableDriver();
        for (Driver driver : allDrivers) {
            if (driver.getCurrentLocation().distanceTo(pickup) <= 5.0) { // 5 miles radius
                nearByDrivers.add(driver);
            }
        }

        // Sort by distance (nearest first)
        nearByDrivers.sort(Comparator.comparingDouble(d -> d.getCurrentLocation().distanceTo(pickup)));
        return nearByDrivers;
    }
}
