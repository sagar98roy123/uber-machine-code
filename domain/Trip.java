package com.sagarroy.machine_coding.uber.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@AllArgsConstructor
public class Trip {
    private String id;
    private Rider rider;
    private Driver driver;
    private Location startLocation;
    private Location endLocation;
    private TripStatus status;
    private PricingDetails pricingDetails;
    private Date startTime;
    private Date endTime;

    public Trip(Rider rider, Driver driver, Location pickup, Location drop, TripStatus status, PricingDetails pricingDetails){
        this.rider = rider;
        this.driver = driver;
        this.startLocation = pickup;
        this.endLocation = drop;
        this.status = status;
        this.pricingDetails = pricingDetails;
    }

    public void updateStatus(TripStatus newStatus){
        this.status = newStatus;
        if(newStatus == TripStatus.COMPLETED){
            this.endTime = new Date();
        }
    }
}
