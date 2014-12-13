package net.starjuice.calculation.acceptance_tests;

public interface ImperativeTestProvider {
    void make_a_calculator();

    void add_numbers(int a, int b);

    void subtract_subtrahend_from_minuend(int subtrahend, int minuend);

    void check_result(int expected);
}
