package net.starjuice.calculation.stub.acceptance_tests;

import net.starjuice.calculation.acceptance_tests.ImperativeTestProvider;
import org.springframework.stereotype.Component;

@Component
public class ImperativeStubTester implements ImperativeTestProvider {
    @Override
    public void make_a_calculator() {
    }

    @Override
    public void add_numbers(int a, int b) {
    }

    @Override
    public void check_result(int expected) {
    }
}
