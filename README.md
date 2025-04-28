# kotlin-lotto-precourse

## Description
This project implements a Lotto game application following Clean Architecture principles, structured into Data, Domain, and Presentation layers. The user can purchase lotto tickets, input winning numbers, check results, and compute their profit rate.

## ✅ Feature List

### 1. Purchase Flow
- [x] Prompt user to input a purchase amount.
- [x] Validate that the amount is divisible by 1,000 KRW.
- [x] Calculate the number of tickets to be issued.
- [x] Generate the correct number of tickets.

### 2. Ticket Generation
- [x] Generate 6 **unique** random numbers per ticket.
- [x] Each number must be between 1 and 45.
- [x] Sort ticket numbers in ascending order.
- [x] Display all generated tickets after purchase.

### 3. Winning Numbers Input
- [x] Prompt user to input 6 unique winning numbers (comma-separated).
- [x] Validate numbers are in range [1, 45] and unique.
- [x] Prompt user to input 1 bonus number.
- [x] Validate bonus number is unique and in range.

### 4. Result Calculation
- [x] Compare each ticket to the winning numbers.
- [x] Count matched numbers and bonus match.
- [x] Determine prize rank:
  - 6 Matches → 🥇 1st Prize (2,000,000,000 KRW)
  - 5 Matches + Bonus → 🥈 2nd Prize (30,000,000 KRW)
  - 5 Matches → 🥉 3rd Prize (1,500,000 KRW)
  - 4 Matches → 🎖️ 4th Prize (50,000 KRW)
  - 3 Matches → 🏅 5th Prize (5,000 KRW)

### 5. Statistics and Profit Calculation
- [x] Count number of tickets per prize tier.
- [x] Calculate total earnings.
- [x] Calculate and display profit rate (rounded to 1 decimal place).

### 6. Input Validation & Error Handling
- [x] Throw `IllegalArgumentException` or `IllegalStateException` for invalid inputs.
- [x] Re-prompt user on invalid input.
- [x] Display all error messages with prefix `[ERROR]`.

### 7. Testing
- [x] Unit test all domain logic and use cases.
- [x] Validate ticket generation, matching logic, profit calculation.

---


## Project Structure
- **Data Layer**
  - `LottoNumberService`: Generates random lotto numbers.
  - `LottoRepositoryImpl`: Stores and retrieves lotto tickets.

- **Domain Layer**
  - `PurchaseLottoUseCase`: Handles purchasing lotto tickets.
  - `CalculateResultUseCase`: Calculates results based on winning numbers.
  - `ComputeProfitUseCase`: Calculates the profit rate.

- **Presentation Layer**
  - `InputView`: Handles user input with validation and re-prompting on invalid entries.
  - `OutputView`: Displays tickets, statistics, and profit rate.
  - `LottoController`: Manages the flow between user input, business logic, and output.

- **Entry Point**
  - `main.kt`: Initializes all components and starts the application.

## Features
- Purchase multiple lotto tickets based on the input purchase amount.
- Input winning numbers and a bonus number.
- Validate inputs for correctness (range, duplicates, format).
- Match purchased tickets against winning numbers and display results.
- Calculate and display the profit rate.
- Robust input handling: re-prompts on invalid inputs using specific exceptions only.

## Notes
- Error messages and magic numbers are extracted into constants for better maintainability.
- The application automatically re-prompts the user without crashing on invalid inputs.
