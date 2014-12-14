package net.starjuice.calculation.di;

import org.springframework.stereotype.Component;

@Component
public class Subtracter implements Subtraction {
    @Override
    public int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }
}
