package com.sagarroy.machine_coding.uber.strategy;

public class PricingStrategyFactory {
    public static PricingStrategy getPricingStrategy(boolean isSurge, double surgeMultiplier) {
        if (isSurge) {
            return new SurgePricing(surgeMultiplier);
        }
        return new StandardPricing();
    }
}

