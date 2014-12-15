# Decoupling acceptance tests from the interface of solution implementations

This project demonstrates a strategy for decoupling acceptance tests from the interface of solution implementations
by fulfilling declarative acceptance tests with pluggable imperative testers.

## The strategy

With this strategy, the acceptance tests package provides declarative acceptance tests; that is,
acceptance tests that are written in business domain language and are agnostic to the implementation domain.
They define *what* to test without defining *how* to test it.

The acceptance test package provides a test suite that would be fully executable if it were not missing one key
component: an imperative tester. An imperative tester defines *how* to test a solution implementation.

Instead, the acceptance test package defines the *interface* of the imperative tester, and provides a
mechanism for an implementation of that interface to be injected into the acceptance tests.

Thus, each solution implementation incorporates the acceptance test package into its test suite, plugging in
an imperative tester that understands how to exercise its own implementation of the solution.

This strategy decouples the acceptance tests from the interface of the solution implementations, allowing them to be
varied independently. This allows for the safe exploration of multiple implementation domains (*where* will this be
implemented?) and multiple implementation interfaces (*how* will it be used?).

While the solution model is unproven, this provides maximum flexibility to explore safely, both the interface of the
solution and the implementation domain in which it is delivered.
This is ideal while we are still asking "Is this really the *what* we want?" and not just "Is this really *how* we
should deliver it?"

Note, however, that this does not protect the value of a consistent solution model interface.

As the interface of the solution model is explored and proven and increasingly becomes a dependency in the ecosystem,
the value of freedom to explore diminishes, while the value of guaranteed interface conformance increases.
This guarantee can be delivered in two steps, by

* extracting the solution model interface into a package that the test package and solution implementation packages
  depend on, and
* providing a single imperative tester in the test package, removing the freedom to define the solution model interface
  from implementation packages.

Thereafter, to enjoy the safety of the original strategy, changes to the model solution interface and implementation
domain require either interface versioning or interface adapters that abstract the changes.

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
(cucumber in this case). Although the acceptance tests package uses Spring to plug in the imperative testers from
the test suites of solution implementations, implementers are not required to use Spring to decorate their implementation
model components.

Thus, this strategy presents the following desirable dependency arrangements:

* The acceptance tests are decoupled from the test and model components of implementations.
* Implementation model components are decoupled from the acceptance tests.
* Implementation test components are decoupled from the dependencies of the acceptance tests.
* Implementation test components are only coupled to an interface defined by the acceptance tests.

That last arrangement highlights the major risk to realization of the value of the strategy: if acceptance tests are
not expressed exclusively in business domain language and agnostic to the implementation domain, the interface of
model components will bleed up into the interface of the imperative tester. Then solution implementations can
no longer be varied independently.

And so the Achilles heel of declarative acceptance tests remains the skill of the group defining the tests.

## Key files

The following key files are of interest in verifying the claims above:

* Declarative acceptance tests as human text:
  * [addition.feature](https://github.com/sheldonh/calculation/blob/master/calculation-acceptance-tests/src/main/resources/features/addition.feature)
  * [subtraction.feature](https://github.com/sheldonh/calculation/blob/master/calculation-acceptance-tests/src/main/resources/features/subtraction.feature)
* [Glue code](https://github.com/sheldonh/calculation/blob/master/calculation-acceptance-tests/src/main/java/net/starjuice/calculation/acceptance_tests/StepDefinitions.java) that maps the human text to pluggable imperative testers.
* Imperative tester components supplied by solution implementations:
  * [ImperativeApiTester](https://github.com/sheldonh/calculation/blob/master/calculation-api/src/test/java/net/starjuice/calculation/api/acceptance_tests/ImperativeApiTester.java) in `calculation-api`
  * [ImperativeCrazyIdeaTester](https://github.com/sheldonh/calculation/blob/master/calculation-crazy-api/src/test/java/net/starjuice/calculation/crazy/acceptance_tests/ImperativeCrazyIdeaTester.java) in `calculation-crazy-api`
* Model components of the solution implementations:
  * [Calculator](https://github.com/sheldonh/calculation/blob/master/calculation-api/src/main/java/net.starjuice.calculation.api/Calculator.java) in `calculation-api`
  * [CrazyCalculator](https://github.com/sheldonh/calculation/blob/master/calculation-crazy-api/src/main/java/net.starjuice.calculation.crazy/CrazyCalculator.java) in `calculation-crazy-api`
* Project Object Model files that describe package dependencies:
  * [calculation-acceptance-tests](https://github.com/sheldonh/calculation/blob/master/calculation-acceptance-tests/pom.xml)
  * [calculation-api](https://github.com/sheldonh/calculation/blob/master/calculation-api/pom.xml)
  * [calculation-crazy-api](https://github.com/sheldonh/calculation/blob/master/calculation-crazy-api/pom.xml)
* Solution implementation in which model components use Spring:
  * [Context aware imperative tester](https://github.com/sheldonh/calculation/blob/master/calculation-with-dependency-injection/src/test/java/net/starjuice/calculation/di/acceptance_tests/ImperativeSpringModelTester.java)
  * [Injectable solution model component](https://github.com/sheldonh/calculation/blob/master/calculation-with-dependency-injection/src/main/java/net.starjuice.calculation.di/CompositeCalculator.java)
  * [Injected solution model component](https://github.com/sheldonh/calculation/blob/master/calculation-with-dependency-injection/src/main/java/net.starjuice.calculation.di/Adder.java)
  * [acceptanceTestContext.xml](https://github.com/sheldonh/calculation/blob/master/calculation-with-dependency-injection/src/test/resources/acceptanceTestContext.xml) configures model component scan
  * [pom.xml](https://github.com/sheldonh/calculation/blob/master/calculation-with-dependency-injection/pom.xml) shows direct dependency on Spring
