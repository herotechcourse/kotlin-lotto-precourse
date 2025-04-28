# Lotto Application

A Kotlin-based lottery ticket machine that allows users to purchase tickets, input winning numbers, and check their winnings.

## Features Implemented

### 1. Core Domain Models

- [x] LottoNumber: Value object representing a single lotto number (1-45)
  - Validation for number range (1-45)
  - Immutable value object
  - Proper equals/hashCode implementation
- [x] LottoTicket: Class representing a single lotto ticket with 6 unique numbers
  - Validation for 6 unique numbers
  - Match counting functionality
  - Bonus number checking
- [x] LottoPurchase: Class handling the purchase of multiple tickets
  - Purchase amount validation (divisible by 1000)
  - Automatic ticket generation
- [x] WinningNumbers: Class representing the winning numbers and bonus number
  - Validation for winning numbers and bonus number
  - Duplicate checking
- [x] LottoResult: Class representing the matching results and prize calculation
  - Prize calculation based on matches
  - Return rate calculation with proper formatting

### 2. Input/Output Handling

- [x] InputView: Class for handling user input
  - [x] Purchase amount input validation
  - [x] Winning numbers input validation
  - [x] Bonus number input validation
- [x] OutputView: Class for displaying results
  - [x] Display purchased tickets
  - [x] Display winning statistics
  - [x] Display return rate

### 3. Business Logic

- [x] Purchase amount validation (must be divisible by 1000)
- [x] Lotto number generation (6 unique numbers between 1-45)
- [x] Winning number comparison logic
- [x] Prize calculation based on matching numbers
- [x] Return rate calculation with proper formatting

### 4. Error Handling

- [x] Input validation for purchase amount
- [x] Input validation for lotto numbers
- [x] Input validation for bonus number
- [x] Custom exception messages for different error scenarios

### 5. Testing

- [x] Unit tests for all domain models
  - [x] LottoNumberTest
  - [x] LottoTicketTest
  - [x] LottoPurchaseTest
  - [x] LottoResultTest
- [x] Unit tests for input validation
- [x] Unit tests for winning number comparison
- [x] Unit tests for prize calculation
- [x] Integration tests for complete flow

## Technical Requirements

- Kotlin 1.9.24
- JUnit 5 for testing
- AssertJ for assertions
- camp.nextstep.edu.missionutils for Randoms and Console APIs

## Project Structure

```
src/
├── main/
│   └── kotlin/
│       └── lotto/
│           ├── domain/
│           │   ├── LottoNumber.kt
│           │   ├── LottoTicket.kt
│           │   ├── LottoPurchase.kt
│           │   ├── WinningNumbers.kt
│           │   └── LottoResult.kt
│           ├── view/
│           │   ├── InputView.kt
│           │   └── OutputView.kt
│           ├── Application.kt
│           └── Lotto.kt
└── test/
    └── kotlin/
        └── lotto/
            ├── domain/
            │   ├── LottoNumberTest.kt
            │   ├── LottoTicketTest.kt
            │   ├── LottoPurchaseTest.kt
            │   └── LottoResultTest.kt
            └── view/
                └── InputViewTest.kt
```
