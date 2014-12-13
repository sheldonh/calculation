# Calculation

This project demonstrates the strategy of providing acceptance tests as a separate package that can be used by multiple
implementers.

## The strategy

With this strategy, the acceptance tests package provides declarative acceptance tests; that is,
acceptance tests that are written in business domain language and are agnostic to the implementation domain.
They define *what* to test without defining *how* to test it.

The acceptance test package provides a test suite that would be fully executable if it were not missing one key
component: an imperative test provider. An imperative test provider defines *how* to test a solution implementation.

Instead, the acceptance test package defines the *interface* of the imperative test provider, and provides a
mechanism for an implementation of that interface to be injected into the acceptance tests.

Thus, each solution implementation incorporates the acceptance test package into its test suite, plugging in
an imperative test provider that understands how to exercise its own implementation of the solution.

This strategy decouples the acceptance tests from the interface of the solution implementations, allowing them to be
varied independently. This allows for the safe exploration of multiple implementation domains (*where* will this be
implemented?) and multiple implementation interfaces (*how* will it be used?).

## The demonstration

The strategy is demonstrated in a well understood problem domain (arithmetic), with solutions implemented in a simple
implementation domain (plain Java objects). This runs the risk of having the strategy labelled as over-engineering.
Indeed, for two solutions in the same implementation domain and in this particular problem domain, it is!

Even so, the demonstration project shows how two very different APIs can be explored independently without disruption
of the acceptance tests, because the acceptance tests are decoupled from the interface of the solution implementations.
Surely, nobody designing the acceptance tests could have predicted that a developer would try to implement the
`calculation-crazy-api` solution, which incurs all the complexity of a state machine without any of the benefit of
a reverse polish calculator. Nevertheless, it serves to highlight the extent to which completely different and highly
incompatible solution implementation interfaces can be safely explored completely independently of each other.

The demonstration project is a multi-module Maven build, which serves to clarify that implementations depend on the
acceptance tests, not the other way around. Even that dependency is only in the test context.

It is worth noticing that implementations are not even aware of the test framework used by the acceptance tests package
(cucumber in this case). Although the acceptance tests package uses Spring to plug in the imperative test providers from
the test suites of solution implementations, implementers are not required to use Spring to decorate their implementation
model components.

Thus, this strategy presents the following desirable dependency arrangements:

* The acceptance tests are decoupled from the test and model components of implementations.
* Implementation model components are decoupled from the acceptance tests.
* Implementation test components are decoupled from the dependencies of the acceptance tests.
* Implementation test components are only coupled to an interface defined by the acceptance tests.

That last arrangement highlights the major risk to realization of the value of the strategy: if acceptance tests are
not expressed exclusively in business domain language and agnostic to the implementation domain, the interface of
model components will bleed up into the interface of the imperative test provider. Then solution implementations can
no longer be varied independently.

And so the Achilles heel of declarative acceptance tests remains the skill of the group defining the tests.