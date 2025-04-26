# kotlin-lotto-precourse

## 1. Overview
A simple command-line Lotto application.
1. User enters a purchase amount (must be at least ₩1,000 and divisible by ₩1,000).
2. The app generates that many random tickets (6 unique numbers between 1–45).
3. User enters last week’s winning numbers (6 numbers) and a bonus number.
4. The app displays:
    - Each ticket’s numbers
    - A summary of how many tickets hit 3, 4, 5 (+bonus), or 6 matches
    - Total return rate (prize / purchase * 100%)

---

## 2. Role of each Dir/Files

### Application.kt (Entry Point)
> - Calls `LottoController.run()` to start the flow.

### controller/
#### `LottoController.kt`
> - Orchestrates: read input -> generate tickets -> read winning numbers -> compute results -> print output
> - Catches invalid input and re-prompts recursively.

### service/
#### `LottoService.kt`
> - `purchaseLottoTickets(amount: Int): List<Lotto>`
>   - Generates `amount / 1000` tickets with 6 unique random numbers.
> - `determineWinningResults(…)`: compares each ticket to winning numbers + bonus, tallies counts and total prize.

### model/
#### `Lotto.kt`
> - Represents a single ticket.
> - Validates numbers on init.
> - `countMatching(…)` and `contains(…)` helpers.
#### `WinningNumbers.kt`
> - Holds the 6 winning numbers + bonus.
#### `MatchResult.kt`
> - Stores counts per `PrizeRank`, total prize money, and purchase amount.
> - `calculateProfitRate()` returns a percentage.

### view/
#### `InputView.kt`
> - Prompts user via `Console.readLine()`.
> - Delegates parsing & validation to `Validator`.
#### `OutputView.kt`
> - Displays purchased tickets and formatted winning statistics (using commas, one decimal for rate).

### util/
#### `Rule.kt`
> - Central constants:
>   - `LOTTO_PRICE = 1000`
>   - `MIN_NUMBER = 1`, `MAX_NUMBER = 45`
>   - `NUMBERS_COUNT = 6`
#### `Validator.kt`
> - `validatePurchaseAmount`, `validateLottoNumbers`, `validateBonusNumber`
> - Throws `IllegalArgumentException` with a message from `ExceptionMessage`.
#### `PrizeRank.kt`
> - Enum of ranks (FIRST…FIFTH, NONE) with `matchCount`, `requiresBonus`, `prizeMoney`.
> - `determineRank(matchCount, hasBonus)` mapping logic.

### exception/
#### `ExceptionMessage.kt`
> - Enum of all error cases with consistent, localized messages.

# UML
> This image was generated using [PlantUML](https://www.planttext.com/) based on the contents of `docs/lotto.puml`.

![UML Diagram](docs/lotto_uml.png)