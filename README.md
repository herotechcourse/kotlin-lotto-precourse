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

# Game Instructions

## Objective

Buy lottery tickets, enter the winning numbers and bonus number, and determine the number of winning tickets and the overall profit rate.

## How to Play

1. Enter the purchase amount when prompted.
  - Each ticket costs 1,000 KRW.
  - The number of tickets issued equals the purchase amount divided by 1,000.
2. The program prints the purchased tickets.
  - Each ticket contains six unique numbers between 1 and 45.
  - Ticket numbers are sorted in ascending order.
3. Enter the six winning numbers separated by commas.
4. Enter the bonus number separately.

## Winning Criteria

| Match | Prize Rank | Prize Amount |
|------|------------|--------------|
| 6 numbers matched | 1st | 2,000,000,000 KRW |
| 5 numbers matched + bonus matched | 2nd | 30,000,000 KRW |
| 5 numbers matched | 3rd | 1,500,000 KRW |
| 4 numbers matched | 4th | 50,000 KRW |
| 3 numbers matched | 5th | 5,000 KRW |
| Fewer than 3 matches | No prize | 0 KRW |

## Result Output

- The number of winning tickets for each prize rank is displayed.
- The total return rate is calculated and displayed, rounded to one decimal place.
  - Return rate = (Total Prize Money ÷ Purchase Amount) × 100

## Error Handling

The program validates all inputs. If an invalid input is entered, an error message prefixed with `[ERROR]` is printed, and the input is requested again.

Validation cases include:
- Purchase amount must be divisible by 1,000.
- Winning numbers must be six unique integers between 1 and 45.
- Bonus number must be between 1 and 45 and must not duplicate any winning number.

## Example

```
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets

Total return rate is 62.5%.
```

---
