package net.starjuice.calculation.acceptance_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:net/starjuice/calculation/acceptance_tests"},
        glue = {"net.starjuice.calculation.acceptance_tests"})
public abstract class AbstractAcceptanceTestRunner {
}
