package com.sagarroy.machine_coding.uber.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private double latitude;
    private double logitude;

    public double distanceTo(Location other){
        double lat1Rad = Math.toRadians(this.latitude);
        double lon1Rad = Math.toRadians(this.logitude);
        double lat2Rad = Math.toRadians(other.latitude);
        double lon2Rad = Math.toRadians(other.logitude);

        double latDiff = lat2Rad - lat1Rad;
        double lonDiff = lon2Rad - lon1Rad;

        double a = Math.pow(Math.sin(latDiff/2), 2)
                    + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(lonDiff/2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return 6371.0 * c;
    }
}
