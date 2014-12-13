package net.starjuice.calculation.acceptance_tests;

public interface ImperativeTestProvider {
    void make_a_calculator();

    void add_numbers(int a, int b);

    void check_result(int expected);
}
