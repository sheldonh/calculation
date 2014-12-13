package net.starjuice.calculation.crazy.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTestProvider;
import net.starjuice.calculation.crazy.CrazyCalculator;
import org.junit.Assert;

@AcceptanceTestComponent
public class ImperativeCrazyIdeaTester implements ImperativeTestProvider {
    private CrazyCalculator calculator;

    @Override
    public void make_a_calculator() {
        calculator = new CrazyCalculator();
    }

    @Override
    public void add_numbers(int a, int b) {
        calculator.number(a);
        calculator.plus();
        calculator.number(b);
    }

    @Override
    public void subtract_subtrahend_from_minuend(int subtrahend, int minuend) {
        calculator.number(minuend);
        calculator.minus();
        calculator.number(subtrahend);
    }

    @Override
    public void check_result(int expected) {
        int actual = calculator.equal();
        Assert.assertEquals(expected, actual);
    }
}
