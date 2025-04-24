### Lotto - Lottery Ticket Generator

This is a simple lottery ticket generation and result evaluation program.  
Based on the user’s input budget, it issues tickets and compares them with the winning numbers to print the results and profit rate.

### Features

1. **InputView & InputParser**
   - `InputView` handles prompting and reading input from the console.
   - `InputParser` is responsible for validating and parsing user input.
      - **Purchase Amount**
         - Must be numeric and not blank.
         - Must be divisible by 1,000.
         - Must be at least 1,000 KRW.
      - **Winning Numbers**
         - Must be 6 values separated by 5 commas.
         - Each number must be between 1 and 45.
         - All numbers must be unique.
      - **Bonus Number**
         - Must be a single numeric input.
         - Must be between 1 and 45.
         - Must not overlap with the winning numbers.
        
2. **LottoTicketMachine**
    - Issues 1 ticket per 1,000 KRW.
    - Each ticket is a `Lotto` object containing 6 unique random numbers.

3. **Lotto**
    - Contains 6 unique random numbers from 1 to 45 (no duplicates).
    - Validate has 6 numbers
    - Validates for range and uniqueness.
    - Can calculate how many numbers match the winning ticket.

4. **WinningLotto**
    - Stores 6 winning numbers and 1 bonus number.
    - Validate has 6 numbers
    - Validates for range and uniqueness.
    - Bonus Number not overlap with the winning numbers.
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

---

### ❗ Exceptions

| Case                                            | Error Message |
|-------------------------------------------------|---------------|
| Input is not a number or is blank               | `[ERROR] Invalid input.` |
| Purchase amount is not divisible by 1,000       | `[ERROR] Amount must be divisible by 1,000.` |
| Purchase amount is less than 1,000              | `[ERROR] Amount must be at least 1000.` |
| Winning numbers input cannot convert to integer | `[ERROR] Invalid WinningNumber.` |
| Winning numbers count is not exactly 6          | `[ERROR] You must input exactly 6 WinningNumber.` |
| Winning numbers contain duplicates              | `[ERROR] Numbers must be unique.` |
| Winning numbers contain a value outside 1–45    | `[ERROR] Lotto number X is out of the valid range (1–45).` |
| Bonus number input cannot convert to integer    | `[ERROR] Invalid BonusNumber.` |
| Bonus number is outside range 1–45              | `[ERROR] BonusNumber must be between 1 and 45.` |
| Bonus number is included in winning numbers     | `[ERROR] Bonus number must not be in the winning numbers.` |
| Lotto object does not contain exactly 6 numbers | `[ERROR] Lotto must contain exactly 6 numbers.` |