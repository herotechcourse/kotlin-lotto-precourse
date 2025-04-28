# Lotto – Pre-course Mission

## Feature List

### Ticket Purchase
- The user can enter the amount of money to purchase lottery tickets.
- The program issues as many tickets as the amount allows (₩1,000 per ticket).
- The amount must be divisible by 1,000.

### Ticket Generation
- Each ticket consists of 6 unique numbers.
- Numbers are randomly selected from 1 to 45.
- Generated ticket numbers are sorted in ascending order.
- The program displays the generated ticket numbers.

### Winning Numbers Input
- The user enters last week’s 6 winning numbers (comma-separated).
- Each number must be unique and within the range 1–45.

### Bonus Number Input
- The user enters a single bonus number.
- The bonus number must not duplicate any of the winning numbers.
- The bonus number must be within the range 1–45.

### Result Analysis
- The program compares each purchased ticket against the winning numbers.
- It determines the rank based on the count of matching numbers and whether the bonus number matches.
- It aggregates and displays the counts for ranks 1 through 5.

### Yield Calculation
- The program calculates the return rate using total prize money and the purchase amount.
- The return rate is rounded to one decimal place.

## Error Handling
- If the user inputs invalid data, the program prints an `[ERROR]` message and prompts again.
  - Purchase amount errors (non-numeric input, not a multiple of 1,000)
  - Winning numbers input errors (non-numeric input, out of range, duplicates, wrong count)
  - Bonus number input errors (out of range, duplicates with winning numbers)

---

## Development Rules

- Use Kotlin 1.9.24 (Java is not allowed).
- Write commit messages in **AngularJS style**, one feature per commit.
- The program entry point is the `main()` function in the **Application** class.
- No external libraries, only use `Randoms` and `Console` APIs.
- Keep functions under 10 lines.
- Allow a maximum nesting depth of 2 levels.
- Avoid using `else` (prefer early return).
- Make active use of `enum` classes.
- Separate business logic from UI logic (use `InputView` and `OutputView`).
- Write unit tests for all business logic (use JUnit 5 and AssertJ).
- Exclude UI code (`System.in`, `System.out`) from unit tests.
- Generate random numbers with `Randoms.pickUniqueNumbersInRange(1, 45, 6)`.
- Read user input with `Console.readLine()`.

---

## Additional Notes

- The feature list was completed in `README.md` before implementation.
- Commit frequently, one feature per commit.
- If a requirement is not explicitly stated, use reasonable judgment.