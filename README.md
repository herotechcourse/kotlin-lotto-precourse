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
- [X] Accept user input for winning numbers (comma-separated)
  - [X] Validate that 6 unique numbers are given, all between 1 and 45
- [X] Accept user input for a bonus number
  - [X] Must be between 1 and 45 and not duplicate a winning number
- [ ] Compare each ticket against the winning numbers
  - [ ] Determine prize rank based on match count and bonus match
  - [ ] Count how many tickets won each prize
- [ ] Calculate and display total profit rate
  - [ ] Profit rate = total prize money / purchase amount
  - [ ] Round to the nearest tenth
- [X] Error handling
  - [X] Throw `IllegalArgumentException` on invalid input
  - [X] All error messages start with `[ERROR]`
  - [X] Re-prompt user input after an error

## Structure

### Main Entry

- `Application.kt` – Starts the program by calling the main controller

### Controller

- `InputHandler.kt` – Handles user prompts, input reading, validation, and retries
- `LottoController.kt` – Controls the overall game flow between input, domain logic, and output

### Domain Logic

- `Lotto.kt` – Represents a lottery ticket (6 sorted unique numbers)
- `LottoMachine.kt` – Creates multiple Lotto tickets based on purchase amount
- `LottoResult.kt` – (To be implemented) Analyzes match results and counts winning tickets
- `Rank.kt` – (To be implemented) Defines winning ranks and corresponding prize money
- `WinningLotto.kt` – Holds the winning ticket numbers and bonus number for comparison

### Support (Utils)

- `Constants.kt` – Defines constant values like ticket price and number limits
- `Message.kt` – Centralizes static text like error messages and prompts
- `Validator.kt` – Validates input values and Lotto rules (range, duplicates)

### View (UI)

- `InputView.kt` – Reads user input from the console (purchase amount, winning numbers, bonus number)
- `OutputView.kt` – Prints output to the console (tickets and result messages)

---

## Testing

- [ ] All business logic is tested with JUnit 5 and AssertJ
- [ ] Tests located under `src/test/kotlin/`
- [ ] Run tests using:
  ```bash
  ./gradlew clean test  # macOS/Linux
  gradlew.bat clean test  # Windows