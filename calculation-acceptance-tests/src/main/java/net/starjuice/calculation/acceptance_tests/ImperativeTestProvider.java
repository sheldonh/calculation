package net.starjuice.calculation.acceptance_tests;

public interface ImperativeTestProvider {
    void make_a_calculator();

    void make_calculator_add_two_numbers(int a, int b);

    void make_calculator_subtract_one_number_from_another(int subtrahend, int minuend);

    void check_calculated_value(int expected);
}
