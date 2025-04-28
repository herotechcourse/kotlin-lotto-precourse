# kotlin-lotto-precourse

### Purchase Amount

- Prompts the user to enter the purchase amount.
- Rejects invalid input such as:
    - Non-integer values
    - Negative or zero amounts
    - Amounts not divisible by 1,000
- Prints a corresponding error message for each invalid case.
- Calculates and prints the number of lotto tickets based on the valid amount.

### Lotto Ticket Generation

- Generates a single lotto ticket containing 6 unique random numbers between 1 and 45.
- Generates multiple tickets based on the purchase amount.
- Prints each ticket
- Ensures tickets are displayed in a readable format by overriding the Lotto class's toString() method.

### Winning Numbers Input

- Prompts the user to enter last week's winning numbers, separated by commas.
- Parses the input into a list of integers.
- Validates that:
    - Exactly 6 numbers are entered.
    - No duplicate numbers exist.
    - All numbers are between 1 and 45.
- Prints an error and re-prompts if the input is invalid.

### Bonus Number Input

- Prompts the user to enter the bonus number.
- Parses the input into an integer.
- Validates that:
    - The bonus number must be between 1 and 45.
    - The bonus number must not duplicate any of the winning numbers.
- Prints a corresponding error message if input is invalid and re-prompts the user.

### Improved Error Handling

- Improved winning numbers input:
    - Parses each number safely using `toIntOrNull()`.
    - Prints an error message if any input is not a valid integer.
- Improved bonus number input:
    - Parses bonus number safely using `toIntOrNull()`.
    - Prints an error message if input is not a valid integer.
- Ensures consistent error handling without program crashes.

### Helper Function for Input Validation

- Introduced `promptUntilValid` helper function:
    - Takes a block of input-reading and validation logic.
    - Automatically retries until valid input is entered.
    - Reduces duplication of `while (true) try-catch` logic across different inputs.

### Match Result Calculation

- For each purchased ticket:
    - Counts how many numbers match the winning numbers.
    - Checks whether the bonus number is matched.
- Aggregate the number of tickets for each prize rank
- Calculate the overall return rate

### Number Extensions

This project provides helper extensions for formatting and rounding numbers:

- `Number.formatWithComma()`
  Formats an Int, Long, Float, or Double with comma separators for better readability.
  Example:

```Kotlin
1234567.formatWithComma() // "1,234,567"
3333.3.formatWithComma()  // "3,333.3"
```

- `Float.roundToDecimalPlaces(places: Int)`
  Rounds a Float value to the specified number of decimal places.
  Example:

```Kotlin
3.14159f.roundToDecimalPlaces(2) // 3.14
9.99f.roundToDecimalPlaces(0)    // 10.0
```

