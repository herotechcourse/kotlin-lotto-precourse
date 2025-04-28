# kotlin-lotto-precourse

A console-based Lotto application that issues tickets, compares them against winning numbers, and calculates the profit rate.

## Feature List

### Purchase Amount Input
- [x] The user must be able to enter the purchase amount.
- [x] The amount must be divisible by 1,000.
- [x] If invalid input is provided (e.g., non-numeric input, zero, or not a multiple of 1,000), an exception must be thrown and the user must be re-prompted.

### Lotto Ticket Issuance
- [x] Lotto tickets are issued based on the purchase amount.
- [x] Each ticket must contain 6 unique numbers.
- [x] Numbers must be in the range of 1 to 45.
- [x] The numbers in each ticket must be sorted in ascending order.

### Winning Numbers Input
- [x] The user must enter the last week's winning numbers (6 unique numbers).
- [x] Each number must be between 1 and 45, and no duplicates are allowed.
- [x] If invalid input is provided, an exception must be thrown and the user must be re-prompted.

### Bonus Number Input
- [x] The user must enter a bonus number.
- [x] The bonus number must be different from the winning numbers and must be between 1 and 45.

### Winning Statistics Calculation
- [x] The program must compare each ticket against the winning numbers.
- [x] The prize ranks are determined as follows:
  - 1st Prize: Match 6 numbers (2,000,000,000 KRW)
  - 2nd Prize: Match 5 numbers + bonus number (30,000,000 KRW)
  - 3rd Prize: Match 5 numbers (1,500,000 KRW)
  - 4th Prize: Match 4 numbers (50,000 KRW)
  - 5th Prize: Match 3 numbers (5,000 KRW)

### Profit Rate Calculation
- [x] The program must calculate the total return rate.
- [x] The return rate must be rounded to one decimal place.
- [x] The formula is: (Total Winnings / Purchase Amount) × 100

###  Consistent Error Message Format
- [x] All error messages must start with [ERROR].

### Separation of Input and Output Logic
- [x] All input operations must be handled in the InputView class.
- [x] All output operations must be handled in the OutputView class.

### Unit Test Implementation
- [x] Unit tests must be written using JUnit5 and AssertJ.
- [x] All core logic must be tested.
- [x] UI-related code (System.in/System.out) must not be included in unit tests.
