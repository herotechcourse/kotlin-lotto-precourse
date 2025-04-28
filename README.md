# Lotto Mission Project

## Overview
Lotto is a console-based application where users:
1. Enter a purchase amount to buy lottery tickets.
2. Receive generated tickets with 6 unique numbers each.
3. Input last week's winning numbers and a bonus number.
4. View the match results, prize statistics, and return rate.

## Features
1. **Purchase Validation & Ticket Count**  
   - Checks that the purchase amount is a multiple of 1,000 KRW.  
   - Calculates how many tickets can be bought.
2. **Ticket Generation**  
   - Uses `Randoms.pickUniqueNumbersInRange(1, 45, 6)` to generate ticket numbers.  
   - `LottoGenerator` supports single and multiple ticket creation.
3. **Input Parsing**  
   - `LottoInput.parseWinningNumbers(raw)` parses and validates 6 winning numbers.  
   - `LottoInput.parseBonusNumber(raw, winning)` parses and validates the bonus number.
4. **Result Evaluation**  
   - `LottoResultEvaluator.evaluate()` determines each ticket's rank.  
   - `LottoRank` enum maps match criteria to prize values.
5. **Statistics & Return Rate**  
   - `LottoStatistics` tallies counts by rank.  
   - Calculates total prize and return rate (rounded to one decimal place).
6. **I/O Separation**  
   - `InputView`: handles all user prompts and input.  
   - `OutputView`: displays tickets and results.
7. **Error Handling**  
   - Prints `[ERROR]` messages on invalid input and either retries or exits.
8. **Application Orchestration**  
   - `Application.main()` coordinates the full flow: purchase → generation → input → evaluation → output.

## Directory Structure
```
src/main/kotlin/lotto/
├─ Application.kt       # Entry point with main()
├─ Purchase.kt          # Purchase validation and ticket count
├─ Lotto.kt             # Lotto domain class
├─ LottoGenerator.kt    # Ticket generation logic
├─ LottoExtensions.kt   # Extension functions (sorting, matching)
├─ LottoRank.kt         # Rank enum with prize mapping
├─ LottoResultEvaluator.kt # Ticket evaluation logic
├─ LottoStatistics.kt   # Rank tally and return rate calculation
├─ LottoInput.kt        # Winning & bonus number parsing
├─ InputView.kt         # Console input handling
└─ OutputView.kt        # Console output handling
```

## How to Run
1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd kotlin-lotto-precourse
   ```
2. **Run the application**
   ```bash
   ./gradlew run    # macOS/Linux
   gradlew.bat run  # Windows
   ```
3. Follow the prompts in the console.

## How to Test
```bash
./gradlew clean test    # macOS/Linux
gradlew.bat clean test  # Windows
```
All unit tests and the feature test (`ApplicationTest`) must pass.

## Commit Message Guidelines
- Follow AngularJS Git commit conventions.  
- Use prefixes like `feat:`, `fix:`, `refactor:`.  
- Example: `feat: add LottoStatistics for return rate calculation`

---

**Requirements:** Kotlin 1.9.24, JDK 11+, Gradle, JUnit 5, AssertJ.  
Uses `camp.nextstep.edu.missionutils` for Randoms, Console, and test utilities.

