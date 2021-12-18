# Koombea Testing Challenge: Rick & Morty API

This project was designed based on Screenplay Pattern, using Serenity BDD and Cucumber as main testing framework, the language used is Java. Serenity-rest library is based on Rest-Assured, so it has some similities in the calling of some methods and assertions.

The test were choosen based on a very short smoke test. There are 5 scenarios for Character API, there the headers, body fields and status code are tested.

The principal idea of the API testing is to get the expected answers and notice when there is any error ocurring.

## Installation

Clone the project from [GitHub](https://github.com/JuanyOrozco/KbRick-MortyApiScreenplay).

## Execution

Run the 'Runner Class', to change or run an specific test change the @Tag placed, currently there are 2, Smoke and Regression.

To run all testes in maven use

```
mvn clean verify test -D"cucumber.filter.tags=@Smoke or @Regression"
```
For a single suite use one Tag

```
mvn clean verify test -D"cucumber.filter.tags=@Smoke"
```
