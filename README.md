# kotlin-lotto-precourse

A Kotlin console application that issues lottery tickets, checks winning results, and calculates profit rate with clean architecture and strict input validation.

---

## Features

- [X] Accept user input for purchase amount
  - [X] Must be a positive number divisible by 1,000
  - [X] Re-prompt on invalid input (`IllegalArgumentException`)
- [X] Generate lottery tickets
  - [X] Each ticket has 6 unique random numbers from 1 to 45
  - [X] Number of tickets = purchase amount / 1,000
  - [X] Print all tickets sorted in ascending order
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
- `LottoMachine.kt` – Generates tickets based on purchase amount

### View (UI)

- `InputView.kt` – Handles user inputs (purchase amount)
- `OutputView.kt` – Prints purchased tickets

## Testing

- [ ] All business logic is tested with JUnit 5 and AssertJ
- [ ] Tests located under `src/test/kotlin/`
- [ ] Run tests using:
  ```bash
  ./gradlew clean test  # macOS/Linux
  gradlew.bat clean test  # Windows