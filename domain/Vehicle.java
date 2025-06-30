package com.sagarroy.machine_coding.uber.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String licenceNumber;
    private VehicleType type;
    String model;
}
