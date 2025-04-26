#  Lotto Game

This project implements a simple lottery ticket simulator that generates tickets based on user input, compares them with winning numbers, and calculates the result and profit rate.

---

##  Feature Checklist

###  Input Requirements

- [x] User inputs the **purchase amount**:
    -  Each ticket costs 1,000 KRW
    -  Amount must be divisible by 1,000
    -  If invalid, display error: `[ERROR]` and re-prompt

- [x] User inputs **winning numbers**:
    -  Exactly 6 unique numbers
    -  Each number must be between 1 and 45
    -  If invalid, display error: `[ERROR]` and re-prompt

- [x] User inputs **bonus number**:
    -  Exactly one number
    -  Must be between 1 and 45
    -  Must not overlap with the winning numbers
    -  If invalid, display error: `[ERROR]` and re-prompt

---

###  Output Requirements

-  Display the list of purchased l`otto tickets
    - [x] Tickets must be sorted in ascending order

-  Display the lotto result statistics
    - [x] Number of tickets for each match count
    - [x] Corresponding prize amount

-  Display the profit rate
    - [x] Rounded to the nearest tenth (e.g., `62.5%`)

---

##  Programming Requirements

-  Use Kotlin 1.9.24 only
-  No external libraries or changes to `build.gradle.kts`
-  No use of `System.exit()` or `exitProcess()`
-  Maximum indentation depth: 2
-  Functions must be under 10 lines and do only one thing
-  Avoid `else` where possible using early return
-  Separate UI logic from business logic
-  Implement unit tests for all logic except UI
-  Use enums to represent prize ranks if applicable
-  Use `Randoms.pickUniqueNumbersInRange(1, 45, 6)` for ticket generation
-  Use `Console.readLine()` for user input

---
##  Architecture - MVC Pattern

###  Model (Domain Logic)

-  `Lotto`: Represents one ticket
    -  Validates 6 unique numbers between 1 and 45
- `Lottoes`: Holds multiple tickets
- `LottoesGenerator`: Generate tickets based on purchase amount
-  `WinningLotto`: Holds winning numbers + bonus number
-  `LottoResult`: Compares ticket vs. WinningLotto and calculates ranks and profit
-  `Rank`: Enum representing prize ranks

###  View (Input/Output)

-  `InputView`
    -  Read purchase amount
    -  Read winning numbers
    -  Read bonus number
-  `OutputView`
    -  Print tickets
    -  Print result summary
    -  Print profit rate

###  Controller

-  `LottoGameController`
    -  Orchestrates game flow: input → generate tickets → calculate result → output

### Util
- `InputValidator`: Validate input
  - Purchase amount is a positive integer and divisible by 1,000
  - Winning numbers: 6 unique numbers between 1 and 45
  - Bonus number is not in winning numbers

###  Entry Point

-  `Application.kt` with `main()` function to start the game

---

##  Test Coverage

- [ ] `ApplicationTest.kt`:  Simulates full game flow
### test(domain)

- [ ] `LottoTest.kt`: Validates input numbers and matching logic
- [ ] `LottoesTest.kt`: Confirms collection behavior of multiple tickets
- [ ] `LottoesGeneratorTest.kt`:Ensures correct number of `Lotto` instances are generated
- [ ] `WinningLottoTest.kt`: Validates bonus number and comparison
- [ ] `LottoResultTest.kt`: Validates prize calculation and profit rate
- [ ] `RankTest.kt`: Validate prize rank 

### test(view)
- [ ] `InputViewTest.kt`: Validates input parsing and error handling
- [ ] `OutputViewTest.kt`: Verifies console output format


### test(util)
- [ ] `InputValidatorTest.kt`: Validates numeric input, range, duplicates, and bonus constraints

---


##  Example Execution

```plaintext
Enter purchase amount:
8000

You have purchased 8 tickets.
[3, 5, 11, 16, 32, 38]
...

Enter winning numbers:
1,2,3,4,5,6

Enter bonus number:
7

Winning Statistics
3 Matches (5,000 KRW) - 1 ticket
...
Total return rate is 62.5%
