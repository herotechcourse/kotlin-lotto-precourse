### Lotto - Lottery Ticket Generator

This is a simple lottery ticket generation and result evaluation program.  
Based on the user’s input budget, it issues tickets and compares them with the winning numbers to print the results and profit rate.

### Features

1. **InputView**
    - Prompts the user for the purchase amount (must be divisible by 1,000 KRW).
    - Prompts for 6 comma-separated winning numbers (must be between 1–45, no duplicates).
    - Prompts for 1 bonus number (must be between 1–45, and not among winning numbers).
    - Re-prompts with `[ERROR]` messages on invalid input.

2. **LottoTicketMachine**
    - Issues 1 ticket per 1,000 KRW.
    - Each ticket is a `Lotto` object containing 6 unique random numbers.

3. **Lotto**
    - Contains 6 unique random numbers from 1 to 45 (no duplicates).
    - Numbers are automatically sorted in ascending order.
    - Validates for range and uniqueness.
    - Can calculate how many numbers match the winning ticket.

4. **WinningLotto**
    - Stores 6 winning numbers and 1 bonus number.
    - Evaluates rank of each ticket according to:
        -  1st Prize: Match 6 numbers (2,000,000,000 KRW)
        -  2nd Prize: Match 5 + bonus (30,000,000 KRW)
        -  3rd Prize: Match 5 (1,500,000 KRW)
        - ️ 4th Prize: Match 4 (50,000 KRW)
        - ️ 5th Prize: Match 3 (5,000 KRW)

5. **OutputView**
    - Prints purchased ticket numbers.
    - Prints result statistics and rank count.
    - Prints total return rate as a percentage (rounded to 1 decimal place).
    - Displays error messages prefixed with `[ERROR]`.

---

### ❗ Exceptions

| Case | Error Message |
|------|---------------|
| Amount not divisible by 1,000 | `[ERROR] Amount must be divisible by 1,000.` |
| Less or more than 6 winning numbers | `[ERROR] You must input exactly 6 numbers.` |
| Winning numbers contain duplicates | `[ERROR] Numbers must be unique.` |
| Number not in range 1–45 | `[ERROR] Numbers must be between 1 and 45.` |
| Bonus number overlaps with winning numbers | `[ERROR] Bonus number must not be in the winning numbers.` |
| Invalid input (non-numeric or empty) | `[ERROR] Invalid input.` |
