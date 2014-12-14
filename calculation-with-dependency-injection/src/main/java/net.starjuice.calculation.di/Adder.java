package net.starjuice.calculation.di;

import org.springframework.stereotype.Component;

@Component
public class Adder implements Addition {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
