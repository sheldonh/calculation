package net.starjuice.calculation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompositeCalculator implements Calculator {

    Addition adder;
    Subtraction subtracter;

    @Autowired
    public void setAdder(Addition adder) {
        this.adder = adder;
    }

    @Autowired
    public void setSubtracter(Subtraction subtracter) {
        this.subtracter = subtracter;
    }

    @Override
    public int add(int a, int b) {
        return adder.add(a, b);
    }

    @Override
    public int subtract(int minuend, int subtrahend) {
        return subtracter.subtract(minuend, subtrahend);
    }
}
