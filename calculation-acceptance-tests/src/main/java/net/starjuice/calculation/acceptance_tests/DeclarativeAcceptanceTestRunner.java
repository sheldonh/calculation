package net.starjuice.calculation.acceptance_tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Inheritable test runner entry point for the acceptance test suite. Solution implementers are expected to place
 * a concrete subclass in their test source path, in a subpackage of <code>net.starjuice.calculation</code>
 * named <code>acceptance_tests</code>
 * (as per the <code>component-scan</code> element of this package's <code>cucumber.xml</code>).
 *
 * Human readable acceptance tests are read from files ending in the <code>.feature</code> extension under
 * the <code>features</code> resource path.
 *
 * Glue code that matches the steps of the human readable acceptance tests to an imperative test provider is scanned
 * from <code>net.starjuice.calculation.acceptance_tests</code>.
 *
 * Imperative test provider components are scanned from any subpackage of <code>net.starjuice.calculation</code> named
 * <code>acceptance_tests</code>, (as above). They must implement the {@link ImperativeTester} interface and
 * should be tagged with the {@link AcceptanceTestComponent} annotation.
 *
 * Imperative test provider components are not required to be be <code>ApplicationContextAware</code>. However, if
 * they are (for example if they test a solution that makes use of Spring dependency injection),
 * and they use XML configuration, their configuration is expected to reside in <code>/acceptanceTextContext.xml</code>
 * in the classpath (as per the <code>import</code> element of this package's <code>cucumber.xml</code>).
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"net.starjuice.calculation.acceptance_tests"})
public abstract class DeclarativeAcceptanceTestRunner {
}
