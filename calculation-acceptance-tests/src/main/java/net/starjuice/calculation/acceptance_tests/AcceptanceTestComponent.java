package net.starjuice.calculation.acceptance_tests;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Tags an {@link ImperativeTestProvider} as a component suitable for injection into the acceptance test's glue code
 * (currently defined in {@link StepDefinitions}.
 *
 * Importantly, the lifecycle of the component will be bound to the scenario scope, avoiding problems arising from
 * state bleed across scenarios.
 */
@Component
@Scope("cucumber-glue")
public @interface AcceptanceTestComponent {
}
