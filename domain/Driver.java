package com.sagarroy.machine_coding.uber.domain;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

@Data
public class Driver extends User implements RiderObserver{

    private static final Logger log = LoggerFactory.getLogger(Driver.class);
    private Vehicle vehicle;
    private Location currentLocation;
    private boolean isAvailable;
    private List<Trip> trips;
    Trip currentTrip;

    public Driver(String id, String name, String email, String phone){
        super(id, name, email, phone);
    }

    @Override
    public void notifyAboutRide(Trip trip) {
        log.info("New ride request from {}", trip.getRider().getName());
    }

    public void acceptRide(Trip trip){
        if(Objects.nonNull(currentTrip)){
            currentTrip.updateStatus(TripStatus.DRIVER_ASSIGNED);
            this.currentTrip = trip;
            this.isAvailable = false;
        }
    }

    public void startRide(){
        if(Objects.nonNull(currentTrip)){
            currentTrip.updateStatus(TripStatus.IN_PROGRESS);
        }
    }

    public void completeRide(){
        if(Objects.nonNull(currentTrip)){
            currentTrip.updateStatus(TripStatus.DRIVER_ASSIGNED);
            this.isAvailable = true;
            this.currentTrip = null;
        }
    }
}
