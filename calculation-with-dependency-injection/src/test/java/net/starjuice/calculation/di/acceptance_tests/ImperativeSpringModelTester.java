package net.starjuice.calculation.di.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTester;
import net.starjuice.calculation.di.Calculator;
import org.junit.Assert;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@AcceptanceTestComponent
public class ImperativeSpringModelTester implements ImperativeTester, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private Calculator calculator;
    private int actual;

    @Override
    public void make_a_calculator() {
        calculator = applicationContext.getBean(Calculator.class);
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
