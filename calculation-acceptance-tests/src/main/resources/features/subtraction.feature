Feature: Subtraction
  As a maths idiot
  I want the difference between any two numbers
  So that I don't feel stupid

  Scenario Outline: Subtract one number from another
    Given I have a calculator
    When I make the calculator subtract <b> from <a>
    Then the calculator gives me the answer <difference>

  Examples:
    |a|b|difference|
    |0|0|0|
    |0|1|-1|
    |1|0|1|
    |1|1|0|
    |-1|1|-2|
    |-1|-1|0|