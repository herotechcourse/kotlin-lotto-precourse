# kotlin-lotto-precourse

---

## Features

### Input Handling
- Prompt user to enter purchase amount (must be divisible by 1,000)
- Accept 6 unique winning numbers (each between 1–45)
- Accept 1 bonus number (must not duplicate any winning number)
- Show `[ERROR]` messages and re-prompt input automatically using a retry mechanism

### Lotto Ticket Generation
- Issue one ticket per 1,000 KRW
- Each ticket contains 6 unique random numbers between 1 and 45
- Ticket numbers are sorted in ascending order
- Random numbers generated using `Randoms.pickUniqueNumbersInRange`

### Result Evaluation
- Compare each ticket's numbers to the winning numbers and bonus number
- Determine prize ranks:
  - 1st: 6 matches → 2,000,000,000 KRW
  - 2nd: 5 matches + bonus → 30,000,000 KRW
  - 3rd: 5 matches → 1,500,000 KRW
  - 4th: 4 matches → 50,000 KRW
  - 5th: 3 matches → 5,000 KRW

### Statistics & Profit Rate Calculation
- Ticket results aggregated and counted using `LottoStatistics.kt`
- Profit rate (return rate) calculated separately from the output logic
- Printed as a formatted percentage

### Output Display
- Print the number of purchased tickets
- Display all generated ticket numbers
- Show winning statistics grouped by prize tier
- Show total return rate (formatted as a percentage)
- All output handled cleanly by `OutputView.kt`

---

## Project Structure and Responsibilities

| File/Package | Responsibility |
|--------------|----------------|
| `Application.kt` | Entry point. Runs the whole application by calling `LottoResult.run()`. |
| `lotto/Lotto.kt` | Represents a lottery ticket. Validates 6 unique numbers (1–45) on creation. |
| `lotto/WinningNumbers.kt` | Manages winning numbers and bonus number. Provides ticket matching logic. |
| `lotto/Rank.kt` | Enum class defining lottery prize tiers based on match results. |
| `lotto/LottoGenerator.kt` | Generates random Lotto tickets based on purchase amount. |
| `lotto/LottoStatistics.kt` | Aggregates ranks of tickets and calculates profit rate. |
| `lotto/LottoResult.kt` | Main orchestrator of game flow: reading input, ticket generation, result calculation, and output display. |
| `lotto/view/InputView.kt` | Handles user inputs. Applies retry mechanism on invalid inputs. |
| `lotto/view/OutputView.kt` | Manages console output for purchased tickets, statistics, and return rate. |
| `lotto/utils/Validator.kt` | Provides input validation utilities (numbers, purchase amount, winning numbers). Throws exceptions for invalid input. |
| `lotto/utils/Retrier.kt` | Centralized retry mechanism for input-related actions. Repeats input reading until valid. |

---

## Testing

- Full unit tests for all business logic using **JUnit 5** and **AssertJ**
- Test coverage includes:
  - Ticket generation and validation (`LottoTest.kt`)
  - Winning numbers validation and matching (`WinningNumbersTest.kt`)
  - Rank evaluation logic (`RankTest.kt`)
  - Statistics and profit calculation (`LottoStatisticsTest.kt`)
  - Retry mechanism (`RetrierTest.kt`)
  - Input validation (`ValidatorTest.kt`)
- Input/Output (Console/Print) is excluded from unit testing
- Exception handling and retry mechanism fully tested
- 100% test coverage for all critical logic.



