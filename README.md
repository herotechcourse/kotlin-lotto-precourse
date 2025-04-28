# kotlin-lotto-precourse
- A Kotlin-based lottery ticket generator and winning result evaluator.  
- Users can purchase lotto tickets, input last week's winning numbers, and check the results.


## Features
- **Purchase Amount Input**: Must be a multiple of 1000 KRW.
- **Random Lotto Generation**: Each ticket contains 6 unique numbers between 1 and 45.
- **Winning Numbers Input**: Enter 6 numbers for last week's winning numbers.
- **Bonus Number Input**: Enter 1 bonus number.
- **Winning Results Statistics**:
  - Match 3 numbers: 5,000 KRW
  - Match 4 numbers: 50,000 KRW
  - Match 5 numbers: 1,500,000 KRW
  - Match 5 numbers + Bonus: 30,000,000 KRW
  - Match 6 numbers: 2,000,000,000 KRW
- **Profit Rate Display**: Calculates and displays the total profit rate based on purchase amount and winnings.


## Feature Commit List
- Write README.md file
- Implement Constants
- Implement Lotto class
- Implement Prize class
- Implement LottoResult class
- Implement Validator
- Implement InputView
- Implement LottoGenerator
- Implement LottoTicketCalculator
- Implement LottoEvaluation
- Implement OutputView
- Implement main code
- Implement TestCode


## VM Configuration
- '-Dfile.encoding=UTF-8'


## Project Structure
/lotto
├── Application.kt                # Main program flow
├── InputView.kt                  # Handles user input
├── OutputView.kt                 # Handles output display
├── Lotto.kt                      # Lotto ticket model
├── LottoGenerator.kt             # Random lotto ticket generator
├── LottoEvaluation.kt            # Winning evaluation logic
├── LottoResult.kt                # Winning result and statistics
├── LottoTicketCalculator.kt      # Calculates number of tickets based on purchase amount
├── Validator.kt                  # Input validation logic
├── Prize.kt                      # Prize model (matching count, bonus, prize money)
├── Constants.kt                  # Centralized constants
/test
├── ApplicationTest.kt            # Main program tests
├── OutputViewTest.kt             # Unit tests for OutputView
├── LottoTest.kt                  # Unit tests for Lotto
├── LottoGeneratorTest.kt         # Unit tests for LottoGenerator
├── LottoEvaluationTest.kt        # Unit tests for LottoEvaluation
├── LottoResultTest.kt            # Unit tests for LottoResult
├── LottoTicketCalculatorTest.kt  # Unit tests for LottoTicketCalculator
├── ValidatorTest.kt              # Unit tests for Validator
├── PrizeTest.kt                  # Unit tests for Prize


## Example Output
```
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.```