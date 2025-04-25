# kotlin-lotto-precourse

Introduction: tbd

## Feature List

The features will be implemented in the following order:

### Input Handling

- [x] Get the purchase amount from the user.
- [x] Check if the purchase amount is valid.
  - [x] It must be a positive integer.
  - [x] It must be divisible by 1,000.

- [x] Get the winning numbers from the user.
- [ ] Check if the winning numbers are valid.
  - [ ] Each number must be between 1 and 45.
  - [ ] There must be 6 unique numbers.

- [ ] Get the bonus number from the user.
- [ ] Check if the bonus number is valid.
  - [ ] It must be a single number between 1 and 45.
  - [ ] It must not match any of the winning numbers.

#### Error Handling

- [ ] Handle invalid user input by throwing an `IllegalArgumentException`.
  - [ ] Re-prompt the user for input after an error.
- [ ] Ensure error messages follow the format: `[ERROR] <message>`.

### Ticket Generation

- [ ] Calculate how many lottery tickets the user can buy.
- [ ] Create lottery tickets for the user.
  - [ ] Each ticket must have 6 unique random numbers between 1 and 45.

### Prize Calculation

- [ ] Check if the user's tickets match the winning numbers.
- [ ] Check if the user's tickets match the bonus number.

- [ ] Define the criteria and prize amounts for the five prize ranks.
- [ ] Calculate the user's winnings, if any.
- [ ] Calculate the profit rate.

### Result Display

- [ ] Print the winning statistics.

## Learnings

- In Kotlin, we can use `try` as an expression to directly return a result. If the `try` block executes successfully, its result is returned.
- We need to use unsigned integer literals for comparisons with unsigned integers.
- The IntelliJ IDEA debugger provides an intuitive display of current values in the editor, which helps to understand program flow.
- We should declare methods as `internal` instead of `private` when we need to test them.
- `map` takes each item in a collection, applies a function to it, and returns a new collection with the transformed items.

## Considerations

- I decided not to allow a purchase amount of 0. The program should not run if no tickets can be bought.
- Regarding number ranges, I intend to use "between" for user-facing messages and "in the range of" for developer-facing messages to ensure clarity and correctness.
- I am using `UInt` for the purchase amount to handle larger numbers without additional memory costs.
- I might use `UByte` instead of larger integer types for the lottery numbers between 1 and 45 to keep memory usage minimal.

## Sources

- [South Korean Lotto 6/45 Explanation](https://en.namu.wiki/w/%EB%A1%9C%EB%98%90%206/45)
- [Kotlin documentation on unsigned integers](https://kotlinlang.org/docs/unsigned-integer-types.html#unsigned-integers-literals)
- [The `map` function from Kotlin's  standard library](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/map.html)
- [Parameterized Tests in JUnit 5](https://www.baeldung.com/parameterized-tests-junit-5)
