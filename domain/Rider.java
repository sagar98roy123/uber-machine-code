package com.sagarroy.machine_coding.uber.domain;

import lombok.Data;

import java.util.List;

@Data
public class Rider extends User{
    private List<Trip> tripHistory;
    private PaymentMethod paymentMethod;

    public Rider(String id, String name, String email, String phone){
        super(id, name, email, phone);
    }
}
