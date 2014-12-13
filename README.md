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

The strategy is demonstrated in an easy problem domain (arithmetic), with solutions implemented in a simple
implementation domain (plain Java objects). This runs the risk of having the strategy labelled as over-engineering.
Indeed, for this problem, it is!
