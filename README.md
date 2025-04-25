# kotlin-lotto-precourse

A simple lottery ticket machine written in Kotlin.  
This project is part of the Woowacourse Pre-course and follows strict process, functional, and programming requirements.

---

## Features

- [ ] Accept user input for purchase amount
  - [ ] Must be a positive number divisible by 1,000
  - [ ] Re-prompt on invalid input (`IllegalArgumentException`)
- [ ] Generate lottery tickets
  - [ ] Each ticket has 6 unique random numbers from 1 to 45
  - [ ] Number of tickets = purchase amount / 1,000
  - [ ] Print all tickets sorted in ascending order
- [ ] Accept user input for winning numbers (comma-separated)
  - [ ] Validate that 6 unique numbers are given, all between 1 and 45
- [ ] Accept user input for a bonus number
  - [ ] Must be between 1 and 45 and not duplicate a winning number
- [ ] Compare each ticket against the winning numbers
  - [ ] Determine prize rank based on match count and bonus match
  - [ ] Count how many tickets won each prize
- [ ] Calculate and display total profit rate
  - [ ] Profit rate = total prize money / purchase amount
  - [ ] Round to the nearest tenth
- [ ] Error handling
  - [ ] Throw `IllegalArgumentException` on invalid input
  - [ ] All error messages start with `[ERROR]`
  - [ ] Re-prompt user input after an error

## Structure

### Main Entry

- `Application.kt` – Runs the application and coordinates flow

### Domain Logic

- `Lotto.kt` – Represents a single valid lottery ticket
- `LottoMachine.kt` – Generates tickets based on amount
- `WinningLotto.kt` – Stores winning numbers and bonus number, checks matches
- `Rank.kt` – Enum for prize ranks and prize money
- `LottoResult.kt` – Aggregates match results, calculates profit rate

### View (UI)

- `InputView.kt` – Handles all user inputs
- `OutputView.kt` – Prints tickets, match results, and profit rate

### Support

- `Validator.kt` – Reusable input validation logic

## Testing

- [ ] All business logic is tested with JUnit 5 and AssertJ
- [ ] Tests located under `src/test/kotlin/`
- [ ] Run tests using:
  ```bash
  ./gradlew clean test  # macOS/Linux
  gradlew.bat clean test  # Windows