package net.starjuice.calculation.acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  Glue code used by the {@link AbstractAcceptanceTestRunner} to match the steps of the human readable acceptance tests
 *  to an imperative test provider.
 *
 *  The {@link AbstractAcceptanceTestRunner} is responsible for injecting an {@link ImperativeTestProvider} component
 *  scanned from the solution implementer's test suite.
 */
@Component
public class StepDefinitions {

    ImperativeTestProvider testProvider;

    @Autowired
    public void setTestProvider(ImperativeTestProvider testProvider) {
        this.testProvider = testProvider;
    }

    @Given("^I have a calculator$")
    public void I_have_a_calculator() throws Throwable {
        testProvider.make_a_calculator();
    }

    @When("^I make the calculator add two numbers (-?\\d+) and (-?\\d+)$")
    public void I_make_the_calculator_add_two_numbers_a_and_b(int a, int b) throws Throwable {
        testProvider.make_calculator_add_two_numbers(a, b);
    }

    @When("^I make the calculator subtract (-?\\d+) from (-?\\d+)$")
    public void I_make_the_calculator_subtract_b_from_a(int subtrahend, int minuend) throws Throwable {
        testProvider.make_calculator_subtract_one_number_from_another(subtrahend, minuend);
    }

    @Then("^the calculator gives me the answer (-?\\d+)$")
    public void the_calculator_gives_me_the_answer_sum(int expected) throws Throwable {
        testProvider.check_calculated_value(expected);
    }
}
