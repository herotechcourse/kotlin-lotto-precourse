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

- apply validator and retry or throw Exception

# Validator
- Define message
    - All error messages are predefined as constants for consistency.
    - These messages are used when validation fails to help the user understand the issue.

- Validate, user input amount
    - Ensures the entered amount is a positive number.
    - Must be divisible by 1,000 (i.e., ticket price).
    - Throws an `IllegalArgumentException` if invalid.

- Validate, user input winning numbers
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

## LottoGenerator
- generate Lotto with random numbers

## Lotto Rank (Enum)
- matchCount, isBonus, prize, description
- factory method

## Lotte Rank Formatter
- format, description
- format, KRW currency

# Lotto
- Lotto numbers initialization
    - Ensures the Lotto object is always created with exactly 6 numbers.
    - All numbers must be unique and within the range 1 to 45.
    - Throws an `IllegalArgumentException` if invalid.

- Provide sorted numbers
    - Returns the Lotto numbers sorted in ascending order.
    - Useful for consistent display formatting.

- Count matched winning numbers
    - Compares this Lotto with the winning numbers.
    - Returns the number of matched numbers.

- Check bonus number
    - Checks whether the bonus number exists in this Lotto.
    - Used to determine 2nd place ranking (5 matches + bonus).

# Lotto Result
- Analyze results
  - Evaluates all tickets based on winning numbers and bonus number.
  - Stores the result ranks internally.

- Generate statistics
  - Provides the count of tickets for each winning rank.

- Calculate return rate
  - Calculates the profit rate based on the total prize and purchase amount.