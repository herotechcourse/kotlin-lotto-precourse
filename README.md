# kotlin-lotto-precourse

A Kotlin console application that issues lottery tickets, checks winning results, and calculates profit rate — developed with **clean architecture**, **strict input validation**, and **small, single-responsibility functions and classes**.

---

## Features

- [x] Accept user input for purchase amount
  - [x] Must be a positive number divisible by 1,000
  - [x] Re-prompt on invalid input (`IllegalArgumentException`)
- [x] Generate lottery tickets
  - [x] Each ticket has 6 unique random numbers from 1 to 45
  - [x] Number of tickets = purchase amount / 1,000
  - [x] Print all tickets sorted in ascending order
- [x] Accept user input for winning numbers (comma-separated)
  - [x] Validate that 6 unique numbers are given, all between 1 and 45
- [x] Accept user input for bonus number
  - [x] Must be between 1 and 45 and not duplicate a winning number
- [x] Compare each ticket against the winning numbers
  - [x] Determine prize rank based on match count and bonus match
  - [x] Count how many tickets won each prize
- [x] Calculate and display total profit rate
  - [x] Profit rate = (total prize money / purchase amount) × 100
  - [x] Rounded to the nearest tenth
- [x] Error handling
  - [x] Throw `IllegalArgumentException` on invalid input
  - [x] All error messages start with `[ERROR]`
  - [x] Re-prompt user input after an error

---

## Structure

### Main Entry

- `Application.kt` — Starts the program by calling the main controller.

### Controller Layer

- `InputHandler.kt` — Handles input prompts, reading, validation retries.
- `LottoController.kt` — Controls the overall game flow: input → processing → output.

### Domain Layer

- `Lotto.kt` — Represents a lottery ticket (6 sorted unique numbers).
- `LottoMachine.kt` — Generates multiple Lotto tickets based on the purchase amount.
- `LottoResult.kt` — Compares tickets to winning numbers and summarizes results.
- `Rank.kt` — Defines prize ranks and associated prize money.
- `WinningLotto.kt` — Represents the winning numbers and bonus number.

### Support Layer (Utilities)

- `Constants.kt` — Defines constant values like ticket price and number limits.
- `Message.kt` — Centralizes static texts like prompts and error messages.
- `Validator.kt` — Validates input numbers and Lotto rules (range, duplicates).
- `RetryHelper.kt` — Utility for retrying input on exception.

### Util Layer (Pure Functions)

- `calcReturnRate.kt` — Calculates the profit rate percentage.
- `roundRate.kt` — Formats profit rate to one decimal place.
- `calculateAndFormatReturnRate.kt` — Full flow of calculating and formatting the profit.

### View Layer (Console I/O)

- `InputView.kt` — Reads user input (purchase amount, winning numbers, bonus number).
- `OutputView.kt` — Prints tickets, statistics, and error messages to the console.

---

## Testing

- [X] All business logic is tested with **JUnit 5** and **AssertJ**.
- [X] Tests are located under `src/test/kotlin/`.
- [x] Run all tests using:
  ```bash
  ./gradlew clean test      # macOS/Linux
  gradlew.bat clean test     # Windows
  ```