# Lotto Application

A Kotlin-based lottery ticket machine that allows users to purchase tickets, input winning numbers, and check their winnings.

## Features to Implement

### 1. Core Domain Models

- [ ] LottoNumber: Value object representing a single lotto number (1-45)
- [ ] LottoTicket: Class representing a single lotto ticket with 6 unique numbers
- [ ] LottoPurchase: Class handling the purchase of multiple tickets
- [ ] WinningNumbers: Class representing the winning numbers and bonus number
- [ ] LottoResult: Class representing the matching results and prize calculation

### 2. Input/Output Handling

- [ ] InputView: Class for handling user input
  - [ ] Purchase amount input validation
  - [ ] Winning numbers input validation
  - [ ] Bonus number input validation
- [ ] OutputView: Class for displaying results
  - [ ] Display purchased tickets
  - [ ] Display winning statistics
  - [ ] Display profit rate

### 3. Business Logic

- [ ] Purchase amount validation (must be divisible by 1000)
- [ ] Lotto number generation (6 unique numbers between 1-45)
- [ ] Winning number comparison logic
- [ ] Prize calculation based on matching numbers
- [ ] Profit rate calculation

### 4. Error Handling

- [ ] Input validation for purchase amount
- [ ] Input validation for lotto numbers
- [ ] Input validation for bonus number
- [ ] Custom exception classes for different error scenarios

### 5. Testing

- [ ] Unit tests for all domain models
- [ ] Unit tests for input validation
- [ ] Unit tests for winning number comparison
- [ ] Unit tests for prize calculation
- [ ] Integration tests for complete flow

## Implementation Plan

1. **Phase 1: Core Domain Models**

   - Implement LottoNumber and LottoTicket
   - Add validation logic
   - Write unit tests

2. **Phase 2: Purchase and Generation**

   - Implement LottoPurchase
   - Add random number generation
   - Write unit tests

3. **Phase 3: Winning Numbers and Results**

   - Implement WinningNumbers
   - Add comparison logic
   - Implement LottoResult
   - Write unit tests

4. **Phase 4: Input/Output**

   - Implement InputView
   - Implement OutputView
   - Add validation logic
   - Write unit tests

5. **Phase 5: Integration**
   - Connect all components
   - Add main application flow
   - Write integration tests
   - Final testing and refinement

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
            └── view/
```
