# Lotto Application

## Overview
A Kotlin-based lottery ticket application that allows users to purchase lottery tickets, input winning numbers, and view their results. The application follows clean code principles and implements proper error handling.

## Features

### 1. Lottery Ticket Purchase
- **Input Validation**
  - Purchase amount must be divisible by 1,000 KRW
  - Amount must be a positive number
  - Invalid inputs are rejected with clear error messages

- **Ticket Generation**
  - Automatically generates the correct number of tickets based on purchase amount
  - Each ticket contains 6 unique random numbers between 1 and 45
  - Numbers are displayed in sorted order

### 2. Winning Numbers Input
- **Winning Numbers**
  - Accepts 6 unique numbers between 1 and 45
  - Numbers must be comma-separated
  - Validates for duplicates and range

- **Bonus Number**
  - Accepts a single number between 1 and 45
  - Must not be included in winning numbers
  - Used for determining second prize

### 3. Results and Statistics
- **Prize Ranks**
  - 1st Prize: 6 matches (2,000,000,000 KRW)
  - 2nd Prize: 5 matches + bonus (30,000,000 KRW)
  - 3rd Prize: 5 matches (1,500,000 KRW)
  - 4th Prize: 4 matches (50,000 KRW)
  - 5th Prize: 3 matches (5,000 KRW)

- **Statistics Display**
  - Shows number of tickets for each prize rank
  - Displays total return rate
  - Formats numbers with proper comma separators

## Implementation Details

### Class Structure
- **Lotto**: Core data class representing a lottery ticket
- **LottoRank**: Enum class defining prize ranks and criteria
- **LottoMachine**: Business logic for ticket generation and result calculation
- **InputView**: Handles user input with validation
- **OutputView**: Manages formatted output display

### Error Handling
- All error messages start with "[ERROR]"
- Uses IllegalArgumentException for invalid inputs
- Provides clear, specific error messages
- Re-prompts for input after errors

### Testing
- **Unit Tests**
  - LottoTest: Tests core ticket functionality
  - ApplicationTest: Tests complete program flow
- **Test Coverage**
  - Input validation
  - Ticket generation
  - Result calculation
  - Error handling
  - Edge cases

## Technical Requirements
- Kotlin 1.9.24
- JUnit 5 for testing
- Mission Utils library for random number generation and console input
- No external dependencies

## Code Style
- Maximum indentation depth of 2
- Functions limited to 10 lines
- No else statements (using early returns)
- Clear separation of UI and business logic
- Proper error handling and validation