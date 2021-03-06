package net.starjuice.calculation.pojo.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTester;
import net.starjuice.calculation.pojo.Calculator;
import org.junit.Assert;

@AcceptanceTestComponent
public class ImperativePojoTester implements ImperativeTester {
    private Calculator calculator;
    private int actual;

    @Override
    public void make_a_calculator() {
        calculator = new Calculator();
    }

    @Override
    public void make_calculator_add_two_numbers(int a, int b) {
        actual = calculator.add(a, b);

    }

    @Override
    public void make_calculator_subtract_one_number_from_another(int subtrahend, int minuend) {
        actual = calculator.subtract(minuend, subtrahend);
    }

    @Override
    public void check_calculated_value(int expected) {
        Assert.assertEquals(expected, actual);
    }
}
