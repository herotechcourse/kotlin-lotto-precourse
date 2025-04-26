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
- [x] Check if the winning numbers are valid.

  - [x] Each number must be between 1 and 45.
  - [x] There must be 6 unique numbers.

- [x] Get the bonus number from the user.
- [x] Check if the bonus number is valid.
  - [x] It must be a single number between 1 and 45.
  - [x] It must not match any of the winning numbers.

#### Error Handling

- [x] Handle invalid user input by throwing an `IllegalArgumentException`.
  - [x] Re-prompt the user for input after an error.
- [x] Ensure error messages follow the format: `[ERROR] <message>`.

### Ticket Generation

- [x] Calculate how many lottery tickets the user can buy.
- [x] Create lottery tickets for the user.
  - [x] Each ticket must have 6 unique random numbers between 1 and 45.
- [x] Display the generated tickets as required.

### Prize Calculation

- [x] Calculate results for the user's tickets.
  - [x] Check if the user's tickets match the winning numbers.
  - [x] Check if the user's tickets match the bonus number.

- [x] Define the prize amounts for the five prize ranks.
- [x] Calculate the user's winnings, if any.
- [x] Calculate the profit rate.

### Result Display

- [x] Print the winning statistics.
  - [x] Print the profit rate rounded to the nearest tenth.

## Learnings

- In Kotlin, we can use `try` as an expression to directly return a result. If the `try` block executes successfully, its result is returned.
- We need to use unsigned integer literals for comparisons with unsigned integers.
- The IntelliJ IDEA debugger provides an intuitive display of current values in the editor, which helps to understand program flow.
- We should declare methods as `internal` instead of `private` when we need to test them.
- `map` takes each item in a collection, applies a function to it, and returns a new collection with the transformed items.
- `toSet` converts a collection into a `Set`, which removes duplicate elements and keeps only unique values.
- `all` checks if all elements in a collection satisfy a given condition. It returns `true` if every element meets the condition, and `false` otherwise.
- `in` checks if an element exists in a collection and returns a boolean result.
- In IntelliJ IDEA, enabling "Reformat code on save" for all file types except Markdown ensures consistent formatting of source code.
- Kotlin automatically generates setters for `var` properties. This simplifies code and reduces boilerplate.

## Considerations

- I decided not to allow a purchase amount of 0. The program should not run if no tickets can be bought.
- Regarding number ranges, I intend to use "between" for user-facing messages and "in the range of" for developer-facing messages to ensure clarity and correctness.
- I am using `UInt` for the purchase amount to handle larger numbers without additional memory costs.
- I considered using `UByte` for lottery numbers between 1 and 45 to reduce memory costs.
  However, since the `Lotto` class uses a `<List>Int` to store numbers, I chose to use `Int` to avoid unnecessary type conversions.
  The performance impact is minimal.

## Sources

- [South Korean Lotto 6/45 Explanation](https://en.namu.wiki/w/%EB%A1%9C%EB%98%90%206/45)
- [Kotlin documentation on unsigned integers](https://kotlinlang.org/docs/unsigned-integer-types.html#unsigned-integers-literals)
- [The `map` function from Kotlin's standard library](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/map.html)
- [Parameterized Tests in JUnit 5](https://www.baeldung.com/parameterized-tests-junit-5)
