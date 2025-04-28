## Lotto

Lotto is a simple command-line application that simulates a lottery ticket system. Users can purchase tickets, check
them against winning numbers, and calculate their winnings.

---

### Implementation Requirements

| Requirement        | Description                                                                                                                 |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------|
| Code Style         | Keep functions under 10 lines to ensure they perform a single responsibility                                                |
| Control Flow       | Avoid using `else`                                                                                                          |
| Design Patterns    | Use `Enum` classes where applicable                                                                                         |
| Testing            | Implement unit tests for all logic, except for UI interactions                                                              |
| External APIs      | Use the Randoms and Console APIs provided by the `camp.nextstep.edu.missionutils package`                                   |
| Exception Handling | If the user inputs invalid data, the program must throw an `IllegalArgumentException` and re-prompt input from that step    |
| Exception Types    | Handle *only* specific exception types such as `IllegalArgumentException` or `IllegalStateException`, not generic Exception |

### Random Number Generation

To generate random values, use `Randoms.pickUniqueNumbersInRange()` from `camp.nextstep.edu.missionutils.Randoms`.

Example:

```kotlin
Randoms.pickUniqueNumbersInRange(1, 45, 6)
```

### User Input

To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`.

## Development Approach

Development Approach

- **Initial Approach**: Started with a C++-inspired structure, but shifted to Kotlin’s functional style and TDD for
  better modularity.
- **TDD Experience**: I initially followed Test-Driven Development (TDD) but found it challenging to maintain as the
  project progressed due to time constraints and complexity. Despite this, early TDD helped me focus on testable units.
- **Error Handling**: Focused on robust error handling using try-catch blocks for input validation and meaningful error
  messages.
- **Refactoring**: Refactored the code into modular components like Lotto, LottoIssuer, and GameResult, making it easier
  to maintain and test, though not all logic was fully covered by tests later on.

### System Flow

```
1. User Input
   │
2. InputView (parseAmountOrThrow, parseWinningNumbersOrThrow, parseBonusNumberOrThrow)
   │  └── validates input format
   │
3. Policy Validation (via PolicyExtensions)
   │  └── isAtLeastTicketPrice, hasValidSize, isInRange, doesNotOverlapWithWinningNumbers, etc.
   │      └── returns ErrorType
   │
4. Domain Processing
   │  ├── Lotto (validates and holds ticket numbers)
   │  ├── LottoIssuer (generates lottery tickets based on amount)
   │  └── LottoNumbers (generates random numbers)
   │
5. Service Orchestration (GameService)
   │  └── coordinates domain objects and view interactions
   │
6. Result Processing (GameResult)
   │  ├── LottoEvaluator (evaluates tickets against winning numbers)
   │  ├── Rank (determines prize tier based on match count)
   │  └── calculates profit rate
   │
7. Output Formatting (OutputView)
   │  └── formats results in user-friendly format
   │
8. User Display
```

### Architecture

```text
lotto/
├── domain/                     # Core business logic and entities
│   ├── Lotto.kt                # Represents a lottery ticket with validation logic
│   ├── LottoIssuer.kt          # Manages ticket issuance based on purchase amount
│   ├── LottoEvaluator.kt       # Evaluates tickets against winning numbers
│   ├── Rank.kt                 # Enum representing different prize tiers
│   └── LottoNumbers.kt         # Generates random lottery numbers
├── error/                      # Error handling framework
│   ├── ErrorTemplate.kt        # Templates for consistent error messages
│   ├── ErrorType.kt            # Sealed interface for all error types
│   ├── ErrorTypeExtensions.kt  # Extension functions for error processing
│   └── ExceptionHandler.kt     # Central exception handling logic
├── policy/                     # Business rules and validation logic
│   ├── GamePolicy.kt           # Constants and configuration for the lottery game
│   └── PolicyExtensions.kt     # Extension functions for validation rules
├── service/                    # Application services that orchestrate domain logic
│   ├── GameService.kt          # Controls the overall game flow
│   └── GameResult.kt           # Represents the result of a lottery game
├── util/                       # Common utilities
│   └── ValidationUtils.kt      # Helper functions for validation logic
├── view/                       # User interface components
│   ├── input/                  # User input handling
│   │   ├── FakeConsole.kt      # Mock console for testing purposes
│   │   ├── InputView.kt        # Handles user input with validation
│   │   ├── OutputView.kt       # Formats and displays results to users
│   │   └── ViewUtils.kt        # Common utilities for view handling
├── Application.kt              # Main entry point for the application
└── Lotto.kt                    # Main Lotto application logic
```

### Exception Handling

The application uses try-catch blocks at two crucial points in the flow:

1. In main function
   • Used to catch any unexpected errors that might arise during the execution of the lottery game, ensuring the
   application does not crash unexpectedly.
2. In repeatUntilValid function
   • Handles validation errors and provides users with clear error messages, allowing them to correct input and retry
   without restarting the application.

These two try-catch blocks ensure that errors are caught at the appropriate layers (controller and UI validation) and
that the user experience is smooth with continuous retries on invalid input.

---

### Feature List

#### Input Processing

- [x] Accept purchase amount
- [x] Accept winning numbers (6 unique numbers)
- [x] Accept bonus number

#### Validation

- [x] Validate purchase amount (must be divisible by 1,000)
- [x] Validate numbers are within range (1-45)
- [x] Validate numbers have no duplicates
- [x] Validate bonus number is not among winning numbers
- [x] Create error → message mapper for consistent `[ERROR]: ...` output

#### Error Handling

- [x] Create a sealed interface for error types
- [x] Develop a structured error handling mechanism
- [x] Support different error categories (ParseError, WinningError, BonusError, PurchaseError)
- [x] Provide clear, user-friendly error messages

#### Exception Handling

- [x] Handle invalid purchase amount
- [x] Handle invalid number range
- [x] Handle duplicate numbers
- [x] Handle incorrect number count
- [x] Display error messages with `[ERROR]:` prefix
- [x] Add error validation to `InputView` and loop on invalid input
- [x] Integrate error handling in full application flow (input → validate → retry)
- [x] Manage retry loops
- [x] Use try-catch blocks to catch exceptions and guide user through input correction

#### Lotto Generation

- [x] Generate lotto tickets based on purchase amount
- [x] Create random numbers for each ticket
- [x] Sort lotto numbers in ascending order
- [x] Display purchased tickets

#### Winner Calculation

- [x] Compare each ticket with winning numbers
- [x] Determine match count for each ticket
- [x] Check for bonus number match
- [x] Categorize winning tickets by rank
    - 1st: 6 matches
    - 2nd: 5 matches + bonus
    - 3rd: 5 matches
    - 4th: 4 matches
    - 5th: 3 matches

#### Result Output

- [x] Display winning statistics
- [x] Calculate total return rate
- [x] Format return rate to one decimal place

---

### Test

#### Domain Tests

- [x] Lotto Validation
- [x] Number count validation (Ensures the lotto has exactly 6 numbers)
- [x] Duplicate number detection (Ensures no duplicates in a single ticket)
- [x] Range validation (Ensures all numbers are within valid range)
- [x] LottoEvaluator Ranking Accuracy
- [x] Ensures that the LottoEvaluator correctly ranks tickets based on matching numbers.
- [x] Rank Determination Logic
- [x] Validates that rank is correctly determined based on the number of matching numbers and bonus number.

#### Integration Tests

- [x] End-to-End Application Flow
- [x] Validates the entire flow from user input to result display, ensuring that the system behaves correctly in the
  full cycle.
- [x] Random Number Generation Handling
- [x] Ensures that random number generation behaves as expected, with no duplicate numbers and all numbers within the
  valid range.
- [x] Error Scenarios and Error Messages
- [x] Ensures that all invalid inputs (e.g., invalid purchase amount, invalid lotto numbers) trigger the appropriate
  error messages.

#### Edge Cases

- [x] Invalid Inputs
- [x] Tests scenarios where the user inputs values out of the valid range or enters duplicates.
- [x] Ensures that input validation handles these gracefully.
- [x] Boundary Conditions for Winning Calculations
- [x] Validates winning calculations at the edges of the rules, ensuring that tickets with 3, 4, 5, or 6 matches (with
  and without the bonus) are handled correctly.
- [x] Exception Handling Verification
- [x] Ensures that exceptions are properly thrown for invalid inputs and unexpected scenarios, such as invalid lotto
  number format or exceeding the maximum ticket purchase limit.