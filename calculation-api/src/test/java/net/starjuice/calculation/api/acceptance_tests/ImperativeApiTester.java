package net.starjuice.calculation.api.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.ImperativeTestProvider;
import net.starjuice.calculation.api.Calculator;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class ImperativeApiTester implements ImperativeTestProvider {
    private Calculator calculator;
    private int actual;

    @Override
    public void make_a_calculator() {
        calculator = new Calculator();
    }

    @Override
    public void add_numbers(int a, int b) {
        actual = calculator.add(a, b);

    }

    @Override
    public void check_result(int expected) {
        Assert.assertEquals(expected, actual);
    }
}
