package net.starjuice.calculation.acceptance_tests;

/**
 * Each solution implementer's test suite should provide an implementation of this interface, defining how to fulfill
 * steps of the acceptance test suite against its solution.
 *
 * @see DeclarativeAcceptanceTestRunner
 */
public interface ImperativeTestProvider {
    void make_a_calculator();

    void make_calculator_add_two_numbers(int a, int b);

    void make_calculator_subtract_one_number_from_another(int subtrahend, int minuend);

    void check_calculated_value(int expected);
}
