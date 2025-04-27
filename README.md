# kotlin-lotto-precourse
# Lotto Ticket Machine - Features

## 🎯 Functional Features

1. **Purchase Input Validation**
   - Accept purchase amount from user.
   - Must be divisible by 1,000 KRW.
   - Must throw `IllegalArgumentException` if invalid.

2. **Lotto Ticket Generation**
   - Issue 1 ticket per 1,000 KRW.
   - Each ticket must contain 6 **unique** random numbers (1–45).
   - Ticket numbers must be sorted in ascending order.

3. **Winning Numbers Input**
   - Accept 6 **unique** winning numbers from the user (1–45).
   - Accept 1 **bonus number** from the user (1–45, not in winning numbers).
   - Must validate all inputs and throw `IllegalArgumentException` if invalid.

4. **Rank Evaluation**
   - Compare each ticket to the winning numbers and determine rank:
     - Match 6: 1st Prize (2,000,000,000 KRW)
     - Match 5 + Bonus: 2nd Prize (30,000,000 KRW)
     - Match 5: 3rd Prize (1,500,000 KRW)
     - Match 4: 4th Prize (50,000 KRW)
     - Match 3: 5th Prize (5,000 KRW)
     - Otherwise: No prize

5. **Result Output**
   - Display each issued ticket (sorted).
   - Display number of wins per prize.
   - Calculate and show total return rate.

6. **Error Handling**
   - Input errors must show messages starting with `[ERROR]`.
   - Only `IllegalArgumentException` or `IllegalStateException` are allowed for handling.
   - Re-prompt user on invalid input (not crash or exit).

## 🧑‍💻 Technical Features

- Written in Kotlin `1.9.24`.
- Entry point: `main()` in `Application` class.
- Follows Kotlin coding conventions.
- Max 2 indentation levels.
- Functions < 10 lines.
- Avoid `else`, use early return.
- Use `Enum` for prize ranks.
- Separate UI logic (`InputView`, `OutputView`) from business logic.
- Use `Randoms.pickUniqueNumbersInRange()` for number generation.
- Use `Console.readLine()` for user input.
- Unit tests using JUnit5 + AssertJ for all logic except UI.
 
