# kotlin-lotto-precourse
## 🎱 Lotto

### 🧱 Project Structure

This project follows a layered structure to separate concerns and improve maintainability, 
adhering to the MVC pattern principles.

```
└── lotto
    ├── Application.kt          // Entry point of the program
    ├── Lotto.kt                // Represents a single lotto ticket
    ├── domain                  // Model (Business logic and data)
    │   ├── LottoTicket.kt      // Represents a purchased lotto ticket (utilizing Lotto)
    │   ├── LottoTickets.kt     // Manages a collection of purchased lotto tickets
    │   ├── WinningLotto.kt     // Manages the winning numbers and bonus number
    │   ├── LottoMatchResult.kt // Result for a single lotto ticket
    │   ├── LottoResults.kt     // Aggregates results for all tickets and calculates profit
    │   ├── PrizeRank.kt        // Information about prize ranks (Enum)
    │   └── LottoMachine.kt     // Handles core business logic like buying, calculation
    ├── view                    // View (Input and Output handling)
    │   ├── InputView.kt        // Handles user input
    │   └── OutputView.kt       // Handles displaying output
    ├── controller              // Controller (Connects Model and View, controls app flow)
    │   └── LottoController.kt  // Manages game rounds and progression
    └── util                    // Utility code
        ├── LottoNumberGenerator.kt // Generates lotto numbers (using Randoms)
        └── InputValidator.kt   // validate Inputs
        
```

### 🧪 Test Structure

```
└── test
    └── lotto
        ├── ApplicationTest.kt
        ├── LottoTest.kt
        ├── domain                  
        │   ├── WinningLottoTest.kt     // Unit tests for winning number matching logic
        │   ├── LottoResultsTest.kt     // Unit tests for result aggregation and profit calculation
        │   └── PrizeRankTest.kt        // Unit tests for PrizeRank Enum logic
        └── util
            └── InputValidatorTest.kt 
        
```


### ✅ Feature Requirements

- [x] **Receive purchase amout and issue tickets**
    - [x] Prompt the user to input purchase amount.
    - [x] Each ticket costs 1,000 KRW; the amount must be divisible by 1,000.
    - [x] Issue as many tickets as the budget allows.

- [x] **Generate Lotto numbers**
    - [x] Each tickets consists of 6 unique random numbers.
    - [x] Numbers must be in the range form 1 to 45.
    - [x] Print the numbers of the tickets sorted in ascending order.

- [x] **Receive winning and bonus numbers**
    - [x] Receive the 6 winning numbers, seperated by commas (`,`), from the user.
    - [x] Receive a single bonus number from the user
    - [x] Winning and bonus numbers must be in the range form 1 to 45.
    - [x] The bonus number must not be one of the 6 winning numbers.

- [x] **Calculate winning results and statistic**
    - [x] Compare purchased tickets against the winning numbers and bonus number.
    - [x] Determine the prize rank for each ticket.
    - [x] Aggregate the count of tickets for each prize rank.
    - [x] Calculate the total winnings and the total profit rate.

- [x] **Handle invalid input**
    - [x] Throw an `IllegalArgumentException` if the input is invalid.
    - [x] Re-prompt input from that step upon catching the exception.

    

### 🛠 Tech Stack
- Kotlin 1.9.24
- JUnit 5
- AssertJ



>### 🚫 Restrictions
>- Only Kotlin is allowed (no Java).
>- Do not modify `build.gradle.kts`.
>- Do not use any external libraries other than those provided.
>- Do not use `System.exit()` or `exitProcess()` to terminate the program.
>- Maximum indentation depth: 2 levels.
>- Entry point must be `main()` in the `Application` class.
>- Keep functions under 10 lines.
>- Avoid using `else`.
>- Use Enum classes where applicable.
>- Separate business logic from UI logic (Use `InputView`, `OutputView`, etc.).