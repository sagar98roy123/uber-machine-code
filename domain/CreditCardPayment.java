package com.sagarroy.machine_coding.uber.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCardPayment implements PaymentMethod{
    private static final Logger log = LoggerFactory.getLogger(CreditCardPayment.class);
    private String cardNumber;
    private String expiry;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiry, String cvv) {
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        log.info("Processing of payment {} amount via credit-card", amount);
        return true;
    }
}
