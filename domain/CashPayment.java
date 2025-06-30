package com.sagarroy.machine_coding.uber.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CashPayment implements PaymentMethod{
    private static final Logger log = LoggerFactory.getLogger(CashPayment.class);

    @Override
    public boolean pay(double amount) {
        log.info("Cash payment of {} amount is to be collected", amount);
        return true;
    }
}
