package net.starjuice.calculation.crazy.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTester;
import net.starjuice.calculation.crazy.CrazyCalculator;
import org.junit.Assert;

@AcceptanceTestComponent
public class ImperativeCrazyIdeaTester implements ImperativeTester {
    private CrazyCalculator calculator;

    @Override
    public void make_a_calculator() {
        calculator = new CrazyCalculator();
    }

    @Override
    public void make_calculator_add_two_numbers(int a, int b) {
        calculator.number(a);
        calculator.plus();
        calculator.number(b);
    }

    @Override
    public void make_calculator_subtract_one_number_from_another(int subtrahend, int minuend) {
        calculator.number(minuend);
        calculator.minus();
        calculator.number(subtrahend);
    }

    @Override
    public void check_calculated_value(int expected) {
        int actual = calculator.equal();
        Assert.assertEquals(expected, actual);
    }
}
