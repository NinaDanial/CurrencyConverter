package impl;

import interfaces.ICalculate;

public abstract class Coin implements ICalculate {
    @Override
    public double calculate(double amount) {
        return getValue() * amount;
    }

    abstract double getValue();
}

