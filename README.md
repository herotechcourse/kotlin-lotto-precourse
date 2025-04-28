# Lotto Game

## Feature List

### 1. Lotto Purchase
- Read purchase amount from user input
- Validate that purchase amount is divisible by 1,000
- Issue lottery tickets based on the purchase amount (1,000 KRW per ticket)
- Display the number of tickets purchased and their numbers

### 2. Lotto Generation
- Generate 6 unique random numbers between 1 and 45 for each ticket
- Sort numbers in ascending order
- Validate lottery numbers (no duplicates, within range 1-45)

### 3. Winning Numbers Management
- Read 6 winning numbers as comma-separated input
- Read a bonus number
- Validate winning numbers (no duplicates, within range 1-45)
- Validate bonus number (not duplicate with winning numbers, within range 1-45)

### 4. Result Calculation
- Compare each lottery ticket with winning numbers
- Calculate prize rank for each ticket based on match count and bonus number
- Generate statistics for each rank
- Calculate profit rate (total winnings / purchase amount * 100)

### 5. Output Display
- Display all purchased lottery tickets
- Display winning statistics for each rank
- Display total profit rate (rounded to the nearest tenth)

### 6. Exception Handling
- Throw IllegalArgumentException for invalid inputs
- Display user-friendly error messages with [ERROR] prefix
- Re-prompt input from the step where error occurred

### 7. Testing
- Write unit tests for the Lotto class
- Write unit tests for winning number validation
- Write unit tests for result calculation
- Ensure all tests pass with the Gradle test command

## Development Rules
- Use Kotlin 1.9.24
- Indentation depth must not exceed 2 levels
- Each function must not exceed 10 lines
- Follow the Kotlin Coding Conventions
- Use JUnit 5 and AssertJ for testing
- Use the provided Randoms and Console APIs for random values and user input
- Avoid using else statements where possible

## Architecture and Design Patterns

This project implements the Model-Service-View (MSV) architecture pattern to separate concerns and improve maintainability:

### Model
- Lotto: Represents a lottery ticket with 6 unique numbers
- WinningLotto: Contains winning numbers and bonus number
- Rank: Enum representing prize ranks with prize amounts
- LottoResult: Manages statistics for lottery results

### Service
- LottoMachine: Handles lottery ticket generation and issuance
- LottoGame: Coordinates the overall game flow

### View
- InputView: Handles user input collection through the console
- OutputView: Manages the display of lottery tickets and results

### Key Design Principles Applied

1. Single Responsibility Principle: Each class has a single responsibility and reason to change.
2. Encapsulation: Internal state of objects is hidden and accessed through well-defined interfaces.
3. Immutability: Where appropriate, objects are designed to be immutable to prevent unexpected state changes.
4. Separation of Concerns: Input/output, business logic, and data management are separated.

The implementation follows object-oriented design practices while leveraging Kotlin's language features for clean, concise code.