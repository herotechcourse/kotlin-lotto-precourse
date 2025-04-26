# Lotto Program

This project simulates a lottery ticket system where users can purchase tickets, enter winning numbers, and check their winnings.

## Feature Implementation Plan

This feature list is organized in implementation order, following a test-driven development approach.

### 1. Domain Models

- [x] **Lotto (Core Model)**
  - Validate that lottery numbers are exactly 6 unique numbers
  - Validate that all numbers are between 1 and 45
  - Provide functionality to compare with winning numbers
  - Unit tests for validation and comparison logic

- [x] **Rank (Enum)**
  - Define prize ranks (1st through 5th) with associated conditions and prize amounts
  - Implement method to determine rank based on match count and bonus match
  - Unit tests for each rank determination scenario

### 2. Service Layer

- [ ] **LottoService**
  - Generate random lotto tickets based on purchase amount
  - Calculate match statistics across multiple tickets
  - Determine ranks and calculate win statistics
  - Coordinate business logic operations
  - Unit tests for ticket generation and rank determination

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

- [ ] **LottoApplication**
  - Coordinate between UI and service layers
  - Manage overall program flow
  - Error handling for application-level exceptions

- [ ] **Application**
  - Main program entry point
 
## Design Principles

- Single Responsibility Principle: Each class and method does one thing (10 lines max)
- No hardcoded values: Use constants with meaningful names
- Clear naming conventions: Names that reveal intent without abbreviations
- Clean code formatting: Follow Kotlin coding conventions
- Minimal comments: Express intent through code, not comments

## File Structure
```
src
├── main
│   └── kotlin
│       └── lotto
│           ├── Application.kt
│           ├── LottoApplication.kt
│           ├── Lotto.kt
│           ├── Rank.kt              
│           ├── LottoService.kt      
│           ├── InputView.kt         
│           └── OutputView.kt        
└── test
    └── kotlin
        └── lotto
            ├── LottoTest.kt
            ├── RankTest.kt          
            └── LottoServiceTest.kt   
```
## REASON FOR DESISIONS?
I decided to merge the LottoGenerator and LottoStatistics into just a single LottoService for simplicity. Having too many classes felt like overengineering for such a straightforward application. The service handles both ticket generation and statistics calculation, which made the data flow more direct and the code easier to follow.

As for the bonus number, I chose not to include it in the Lotto class since it's really a separate concept from the main 6 numbers. The bonus only matters when comparing winning numbers, and it felt cleaner to handle it separately during that specific process rather than forcing it into the Lotto model where it doesn't really belong. This keeps the Lotto class focused on just representing a valid lottery ticket.

Overall, I went with a simpler approach that still satisfies all the requirements without unnecessary complexity.