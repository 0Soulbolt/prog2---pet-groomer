package strategy;

import java.util.List;

public class StrategySelector {
    private final List<PricingStrategy> strategies;

    public StrategySelector(List<PricingStrategy> strategies) {
        this.strategies = strategies;
    }

    public PricingStrategy select(int level) {
        for (PricingStrategy strategy : strategies) {
            if (strategy.appliesTo(level)) {
                return strategy;
            }
        }
        throw new IllegalArgumentException("Nincs megfelelő PricingStrategy az értékhez: " + level);
    }
}