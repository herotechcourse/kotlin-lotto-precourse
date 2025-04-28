## Feature List

### 1. Input Validation
- **Purchase Amount**
    - Check if the input is a number.
    - Check if the number is a positive multiple of 1,000.
    - Show error messages like `[ERROR] Purchase amount must be a number.` or `[ERROR] Purchase amount must be a positive multiple of 1000.`

- **Winning Numbers**
    - Check if there are exactly 6 numbers.
    - Check if all numbers are unique.
    - Check if each number is between 1 and 45.
    - Show error messages like `[ERROR] Winning numbers must be 6 unique numbers.` or `[ERROR] Lotto numbers must be between 1 and 45.`

- **Bonus Number**
    - Check if input is a number.
    - Check if number is between 1 and 45 and not in the winning numbers.
    - Show error message `[ERROR] Bonus number must be between 1 and 45 and must be other than the winning numbers.`

### 2. Domain Logic
- **LottoTicket**
    - Store a list of 6 numbers.
    - Sort and keep only unique numbers.
    - Create random ticket with `createRandom()` using `Randoms.pickUniqueNumbersInRange(1, 45, 6)`.

- **LottoResult**
    - Enum of results: NONE, FIFTH, FOURTH, THIRD, SECOND, FIRST.
    - Match count and prize amount for each rank.
    - `LottoResult.of(ticket, winning, bonus)` chooses the right rank.

- **LottoStatistics**
    - Calculate how many tickets match each rank.
    - Sum total prize money.
    - Compute profit rate as `(totalPrize / purchaseAmount) * 100`.

- **LottoGame**
    - Read purchase amount, winning numbers and bonus number.
    - `createTickets()` makes all tickets.
    - `calculateResults()` gives a `LottoStatistics` object.
    - `calculateResults()` maps tickets to `LottoResult` and builds `LottoStatistics`.

### 3. User Interaction (View)
- **InputView**
    - Ask user: “Please enter purchase amount.”
    - Ask user: “Please enter last week’s winning numbers.”
    - Ask user: “Please enter the bonus number.”
    - Loop until valid input.

- **OutputView**
    - Print each ticket as a sorted list, e.g. `[1, 3, 5, 17, 30, 42]`.
    - Print statistics: how many tickets in each prize rank and profit rate.

### 4. Application
- **Application.kt**
    - Call InputView to read data.
    - Use `LottoGame` to make tickets and results.
    - Call OutputView to show tickets and final statistics.

### 5. Testing
- **Unit Tests** with JUnit5 & AssertJ:
    - Validator tests for purchase amount, winning numbers, bonus number.
    - Domain tests for `LottoTicket`, `LottoResult`, `LottoStatistics`, `LottoGame`.
    - View tests for `InputView` and `OutputView`.
    - Application test to check full program output.

All tests pass with `./gradlew clean test` and the program runs on Kotlin 1.9.24 in IntelliJ IDEA.  

