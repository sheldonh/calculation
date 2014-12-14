package net.starjuice.calculation.acceptance_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Inheritable test runner entry point for the acceptance test suite. Solution implementers are expected to place
 * a concrete subclass in their test source path, in a package name that ends in <code>acceptance_tests</code>
 * (as per the <code>component-scan</code> element of this package's <code>cucumber.xml</code>).
 *
 * Human readable acceptance tests are read from files ending in the <code>.feature</code> extension under
 * the <code>net/starjuice/calculation/acceptance_tests</code> resource path.
 *
 * Glue code that matches the steps of the human readable acceptance tests to an imperative test provider is scanned
 * from <code>net.starjuice.calculation.acceptance_tests</code>.
 *
 * Imperative test provider components are scanned from any package in the classpath that ends in
 * <code>acceptance_tests</code>, (as above). They must implement the {@link ImperativeTestProvider} interface and
 * should be tagged with the {@link AcceptanceTestComponent} annotation.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:net/starjuice/calculation/acceptance_tests"},
        glue = {"net.starjuice.calculation.acceptance_tests"})
public abstract class AbstractAcceptanceTestRunner {
}
