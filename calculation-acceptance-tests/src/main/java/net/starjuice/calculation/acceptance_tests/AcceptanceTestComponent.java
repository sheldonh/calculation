package net.starjuice.calculation.acceptance_tests;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public @interface AcceptanceTestComponent {
}
