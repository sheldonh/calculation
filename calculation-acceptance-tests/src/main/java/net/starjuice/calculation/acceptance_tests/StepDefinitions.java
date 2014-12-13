package net.starjuice.calculation.acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath*:net/starjuice/calculation/acceptance_tests/cucumber.xml")
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
        testProvider.add_numbers(a, b);
    }

    @When("^I make the calculator subtract (-?\\d+) from (-?\\d+)$")
    public void I_make_the_calculator_subtract_b_from_a(int subtrahend, int minuend) throws Throwable {
        testProvider.subtract_subtrahend_from_minuend(subtrahend, minuend);
    }

    @Then("^the calculator gives me the answer (-?\\d+)$")
    public void the_calculator_gives_me_the_answer_sum(int expected) throws Throwable {
        testProvider.check_result(expected);
    }
}
