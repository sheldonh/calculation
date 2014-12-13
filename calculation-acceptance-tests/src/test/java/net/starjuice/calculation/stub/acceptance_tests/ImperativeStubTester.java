package net.starjuice.calculation.stub.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.AcceptanceTestComponent;
import net.starjuice.calculation.acceptance_tests.ImperativeTestProvider;

/**
 * Test that the acceptance tests are usable in the test suites of implementations.
 * Does not test an actual implementation!
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
