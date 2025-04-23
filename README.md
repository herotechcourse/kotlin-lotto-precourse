# kotlin-lotto-precourse

# InputView
- User Input, purchase amount
    - The user is prompted to input the total amount of money they wish to spend.
    - The value must be a valid integer and divisible by 1,000.
    - This input determines how many lottery tickets will be issued.

- User Input, winning numbers
    - The user enters 6 comma-separated numbers.
    - Each number must be between 1 and 45, with no duplicates allowed.
    - These represent the official winning numbers.

- User Input, bonus number
    - A single number is entered by the user.
    - It must also be between 1 and 45.
    - It must not overlap with the previously entered winning numbers.
    - Used to determine 2nd place in ranking.


# Validator
- Define message
    - All error messages are predefined as constants for consistency.
    - These messages are used when validation fails to help the user understand the issue.

- Validate, user input amount
    - Ensures the entered amount is a positive number.
    - Must be divisible by 1,000 (i.e., ticket price).
    - Throws an `IllegalArgumentException` if invalid.

- Validate, user input winner numbers
    - Validates that exactly 6 numbers are entered.
    - Checks for duplicate entries.
    - Ensures all numbers are within the valid range (1~45).

- Validate, user input bonus number
    - Checks that the number is in the range of 1~45.
    - Ensures it does not match any of the 6 winning numbers.
    - Throws an exception on failure.


# OutputView
- Define constant, message
  - Defines all prompt and result messages for consistent output formatting.

- Print, purchase amount
  - Prints message prompting user for purchase amount.
  - Prints the total number of purchased tickets.

- Print, winning numbers
  - Prints message prompting user to enter winning numbers.
  - Prints the list of purchased tickets in sorted order.

- Print, bonus number
  - Prints message prompting user to enter the bonus number.

- Print, statistics
  - Prints match statistics by rank and number of winning tickets.

- Print, return rate
  - Prints the total return rate in percentage.