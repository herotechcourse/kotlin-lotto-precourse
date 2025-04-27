# kotlin-lotto-precourse

This is a simple lottery ticket machine implemented in **Kotlin** as part of the **Hero Tech Course Pre-Course Mission**.

---

## Features

### Purchase and Ticket Issuance
- [ ] Prompt user for the purchase amount.
- [ ] Validate that the amount is divisible by 1,000.
- [ ] Calculate the number of tickets based on the amount.
- [ ] Generate lottery tickets with 6 unique random numbers (1-45).

### Winning Numbers Input
- [ ] Prompt user to input last week's winning numbers.
- [ ] Validate winning numbers (6 unique numbers, range 1–45).
- [ ] Prompt user to input a bonus number.
- [ ] Validate bonus number (range 1–45, not duplicated).

### Lotto Matching and Prize Calculation
- [ ] Compare each issued ticket with winning numbers.
- [ ] Determine the prize rank for each ticket.
- [ ] Calculate total winnings.
- [ ] Calculate and print the profit rate, rounded to one decimal place.

### Output
- [ ] Print all issued lottery tickets (numbers sorted ascending).
- [ ] Print winning statistics (matches and corresponding prizes).
- [ ] Display total profit rate.

### Error Handling
- [ ] Throw `IllegalArgumentException` with `[ERROR]` message prefix on invalid input.
- [ ] Re-prompt user for invalid inputs (purchase amount, winning numbers, bonus number).

### Testing
- [ ] Unit tests using JUnit 5 and AssertJ.
- [ ] Test ticket generation, validation, and result calculation logic.
- [ ] Exclude UI-related functions from unit tests.

---

## Tech Stack & Constraints
- Kotlin 1.9.24
- JUnit 5
- AssertJ
- `camp.nextstep.edu.missionutils` (`Randoms`, `Console`)

## Special Requirements
- Use `Randoms.pickUniqueNumbersInRange()` for generating tickets.
- Separate business logic from UI using `InputView`, `OutputView`, and `domain classes`.
- Follow Kotlin coding conventions (max 2 levels of indentation, avoid else, small focused functions).