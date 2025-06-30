package com.sagarroy.machine_coding.uber.service;

import com.sagarroy.machine_coding.uber.domain.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {
    private static final List<Driver> drivers = new ArrayList<>();

    public static List<Driver> getAvailableDriver(){
       return drivers;
    }

    public static void addDriver(Driver driver){
        drivers.add(driver);
    }

}
