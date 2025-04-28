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

- [x] testing

- [x] **Rank (Enum)**
  - Define prize ranks (1st through 5th) with associated conditions and prize amounts
  - Implement method to determine rank based on match count and bonus match
  - Unit tests for each rank determination scenario

- [x] testing

### 2. Service Layer

- [x] **LottoService**
  - Generate random lotto tickets based on purchase amount
  - Calculate match statistics across multiple tickets
  - Determine ranks and calculate win statistics
  - Coordinate business logic operations
  - Unit tests for ticket generation and rank determination

- [x] testing

### 3. UI Layer

- [x] **InputView**
  - Get purchase amount from user with validation
  - Get winning numbers from user with validation
  - Get bonus number from user with validation
  - Error handling with appropriate messages

- [x] testing

- [x] **OutputView**
  - Display purchased tickets in required format
  - Display winning statistics in required format
  - Display return rate in required format

- [x] testing
- 
### 4. Application Layer

- [x] **Application**
  - Main program entry point
- [x] testing
 
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

## Impressions on the progress of the project

I decided to merge the LottoGenerator and LottoStatistics into a single LottoService class for simplicity. Having too many classes felt like overengineering for such a straightforward application. The service now handles both ticket generation and statistics calculation, which made the data flow more direct and the code easier to follow.

Regarding the bonus number, I chose not to include it in the Lotto class since it is a separate concept from the main six numbers. The bonus number only matters when comparing winning numbers, so it felt cleaner to handle it separately during that process, rather than forcing it into the Lotto model where it doesn't truly belong. This keeps the Lotto class focused solely on representing a valid lottery ticket.

Overall, I pursued a simpler approach that satisfies all the requirements without adding unnecessary complexity.

I also decided to include validation both in the input handling and within the Lotto class. Even though this may seem somewhat redundant, it provides an extra layer of safety — following a "defensive programming" mindset — instead of fully trusting the input to always be valid.

Regarding the interpretation of divisibility: I inferred that "divisible" should mean "no remainder." For example, 1234 is not divisible by 1000 because 1234 ÷ 1000 = 1.234, which leaves a remainder of 234. Numbers like 1000, 2000, and 3000 are divisible by 1000 because they divide exactly with no remainder. If the instruction had meant "greater than or equal to 1000," I would have used >= 1000 instead.

During development, I noticed that the input-related code could be refactored using generic functions and learned how to use lambda expressions and flexible return types. I also cleanly separated the input and output responsibilities into InputView and OutputView classes. InputView focuses solely on collecting and validating user input, while delegating all console output to OutputView. This separation improves maintainability and aligns with the Single Responsibility Principle.

Finally, for consistent UI spacing, I implemented a standardized approach to section breaks within the application interface. Rather than inserting newlines randomly, OutputView now handles all spacing through a dedicated method. This results in a more consistent user experience and makes the UI logic more modular.

Throughout this project, I realized that there is always room for more refactoring and optimization. However, part of good software development is knowing when the code is clean, functional, and maintainable enough to meet the project's goals. Sometimes, it's better to accept the current state rather than endlessly chasing "perfect" code. I am satisfied with the balance I achieved between simplicity, clarity, and fulfilling all the requirements.