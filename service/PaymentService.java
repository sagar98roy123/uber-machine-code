package com.sagarroy.machine_coding.uber.service;

import com.sagarroy.machine_coding.uber.domain.PaymentMethod;
import com.sagarroy.machine_coding.uber.domain.Trip;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentService {
    public boolean processPayment(Trip trip) {
        PaymentMethod paymentMethod = trip.getRider().getPaymentMethod();
        log.info("Processing payment");
        return paymentMethod.pay(trip.getPricingDetails().getFare());
    }
}
