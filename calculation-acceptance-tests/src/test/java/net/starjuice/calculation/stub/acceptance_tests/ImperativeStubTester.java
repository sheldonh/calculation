package net.starjuice.calculation.stub.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTestProvider;

/**
 * Define how to apply the acceptance tests to a null solution.
 *
 * In other words, test that the acceptance tests are usable in the test suites of implementations.
 * Does not test an actual implementation!
 *
 * @see net.starjuice.calculation.acceptance_tests.AbstractAcceptanceTestRunner
 */
@AcceptanceTestComponent
public class ImperativeStubTester implements ImperativeTestProvider {
    @Override
    public void make_a_calculator() {
    }

    @Override
    public void make_calculator_add_two_numbers(int a, int b) {
    }

    @Override
    public void make_calculator_subtract_one_number_from_another(int subtrahend, int minuend) {
    }

    @Override
    public void check_calculated_value(int expected) {
    }
}
