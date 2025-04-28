# kotlin-lotto-precourse

This is a simple lottery ticket machine implemented in **Kotlin** as part of the **Hero Tech Course Pre-Course Mission**.

---

## Features

### Purchase and Ticket Issuance
- [x] Prompt user for the purchase amount.
- [x] Validate that the amount is divisible by 1,000.
- [x] Calculate the number of tickets based on the amount.
- [x] Generate lottery tickets with 6 unique random numbers (1-45).

### Winning Numbers Input
- [x] Prompt user to input last week's winning numbers.
- [x] Validate winning numbers (6 unique numbers, range 1–45).
- [x] Prompt user to input a bonus number.
- [x] Validate bonus number (range 1–45, not duplicated).

### Lotto Matching and Prize Calculation
- [x] Compare each issued ticket with winning numbers.
- [x] Determine the prize rank for each ticket.
- [x] Calculate total winnings.
- [x] Calculate and print the profit rate, rounded to one decimal place.

### Output
- [x] Print all issued lottery tickets (numbers sorted ascending).
- [x] Print winning statistics (matches and corresponding prizes).
- [x] Display total profit rate.

### Error Handling
- [x] Throw `IllegalArgumentException` with `[ERROR]` message prefix on invalid input.
- [x] Re-prompt user for invalid inputs (purchase amount, winning numbers, bonus number).

### Testing
- [x] Unit tests using JUnit 5 and AssertJ.
- [x] Test ticket generation, validation, and result calculation logic.
- [x] Exclude UI-related functions from unit tests.

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

---

## Project Structures
```
src
└── main
    └── kotlin
        └── lotto
            ├── Application.kt (Entry Point)
            ├── Lotto.kt (Given)
            ├── view
            │   ├── InputView.kt (Handles all user input)
            │   └── OutputView.kt (Handles all console output)
            ├── domain
            │   ├── LottoTicket.kt (Represents a single ticket)
            │   ├── WinningNumbers.kt (Stores winning numbers and bonus number)
            │   ├── Rank.kt (Enum class for prize ranks)
            │   └── Result.kt (Handles calculating final results)
```

---
## Project Status
- [x] Full feature set implemented and passing all tests.