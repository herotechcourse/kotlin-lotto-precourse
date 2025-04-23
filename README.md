# Lotto Program

This project simulates a lottery ticket system where users can purchase tickets, enter winning numbers, and check their winnings.

## Feature Implementation Plan

This feature list is organized in implementation order, following a test-driven development approach.

### 1. Domain Models

- [ ] **Lotto (Core Model)**
  - Validate that lottery numbers are exactly 6 unique numbers
  - Validate that all numbers are between 1 and 45
  - Provide functionality to compare with winning numbers
  - Unit tests for validation and comparison logic

- [ ] **Rank (Enum)**
  - Define prize ranks (1st through 5th) with associated conditions and prize amounts
  - Implement method to determine rank based on match count and bonus match
  - Unit tests for each rank determination scenario

- [ ] **WinningNumbers**
  - Store 6 winning numbers and 1 bonus number
  - Validate input numbers meet requirements
  - Provide method to calculate match results
  - Unit tests for validation and matching logic

### 2. Service Layer

- [ ] **LottoGenerator**
  - Generate random lotto tickets based on purchase amount
  - Calculate how many tickets can be purchased with given amount
  - Unit tests with mocked random generator for predictable results

- [ ] **LottoStatistics**
  - Calculate match statistics across multiple tickets
  - Calculate total prize money and return rate
  - Unit tests for different winning scenarios

### 3. UI Layer

- [ ] **InputView**
  - Get purchase amount from user with validation
  - Get winning numbers from user with validation
  - Get bonus number from user with validation
  - Error handling with appropriate messages

- [ ] **OutputView**
  - Display purchased tickets in required format
  - Display winning statistics in required format
  - Display return rate in required format

### 4. Application Layer

- [ ] **LottoService**
  - Coordinate between UI and domain layers
  - Manage overall program flow
  - Integration tests for full program flow

- [ ] **Application**
  - Main program entry point
  - Error handling for unexpected exceptions
 
## Design Principles

- Single Responsibility Principle: Each class and method does one thing (10 lines max)
- No hardcoded values: Use constants with meaningful names
- Clear naming conventions: Names that reveal intent without abbreviations
- Clean code formatting: Follow Kotlin coding conventions
- Minimal comments: Express intent through code, not comments
