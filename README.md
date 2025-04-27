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
