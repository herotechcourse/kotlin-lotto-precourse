# kotlin-lotto-precourse

A console-based Lotto application that issues tickets, compares them against winning numbers, and calculates the profit rate.

## Feature List

### Purchase Amount Input
- [ ] The user must be able to enter the purchase amount.
- [ ] The amount must be divisible by 1,000.
- [ ] If invalid input is provided (e.g., non-numeric input, zero, or not a multiple of 1,000), an exception must be thrown and the user must be re-prompted.

### Lotto Ticket Issuance
- [ ] Lotto tickets are issued based on the purchase amount.
- [ ] Each ticket must contain 6 unique numbers.
- [ ] Numbers must be in the range of 1 to 45.
- [ ] The numbers in each ticket must be sorted in ascending order.

### Winning Numbers Input
- [ ] The user must enter the last week's winning numbers (6 unique numbers).
- [ ] Each number must be between 1 and 45, and no duplicates are allowed.
- [ ] If invalid input is provided, an exception must be thrown and the user must be re-prompted.

### Bonus Number Input
- [ ] The user must enter a bonus number.
- [ ] The bonus number must be different from the winning numbers and must be between 1 and 45.

### Winning Statistics Calculation
- [ ] The program must compare each ticket against the winning numbers.
- [ ] The prize ranks are determined as follows:
    - 1st Prize: Match 6 numbers (2,000,000,000 KRW)
    - 2nd Prize: Match 5 numbers + bonus number (30,000,000 KRW)
    - 3rd Prize: Match 5 numbers (1,500,000 KRW)
    - 4th Prize: Match 4 numbers (50,000 KRW)
    - 5th Prize: Match 3 numbers (5,000 KRW)

### Profit Rate Calculation
- [ ] The program must calculate the total return rate.
- [ ] The return rate must be rounded to one decimal place.
- [ ] The formula is: (Total Winnings / Purchase Amount) × 100

###  Consistent Error Message Format
- [ ] All error messages must start with [ERROR].

### Separation of Input and Output Logic
- [ ] All input operations must be handled in the InputView class.
- [ ] All output operations must be handled in the OutputView class.

### Unit Test Implementation
- [ ] Unit tests must be written using JUnit5 and AssertJ.
- [ ] All core logic must be tested.
- [ ] UI-related code (System.in/System.out) must not be included in unit tests.