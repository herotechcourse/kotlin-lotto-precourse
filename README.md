# Lotto Ticket Machine - Kotlin Pre-course Mission 2

This project is a console-based Lotto ticket machine built in Kotlin as part of the Woowa Hero Tech Academy pre-course.  

---

## Features

The program includes the following features:

- Reads purchase amount from the user
- Validates that the amount is a positive integer and divisible by 1,000
- Issues tickets (1,000 KRW per ticket) with 6 **unique random numbers** (range: 1–45)
- Sorts and displays each ticket's numbers in ascending order
- Reads last week's winning numbers and a bonus number
- Validates all numbers for uniqueness and range
- Calculates match counts between purchased tickets and winning numbers
- Categorizes each ticket into 1 of 5 winning ranks (or no prize)
- Calculate how many tickets fall into each rank
- Calculates and displays:
    - Total winnings
    - Profit rate (rounded to 1 decimal place)
- Handles invalid inputs by throwing `IllegalArgumentException` and re-prompting
- Displays all error messages beginning with `[ERROR]`

---

## How to Run

You can run the program from your terminal using Gradle:

#### macOS/Linux
```bash
./gradlew run            
```

#### Windows
```bash
gradlew.bat run          
```

> This runs the `main()` function in the `Application.kt` file.
> Make sure your terminal is in the root directory of the project.

Alternatively, you can run it through IntelliJ IDEA:
```
Run → Application.kt
```

---

## How to Test

To run the tests, use the following command:

#### macOS/Linux
```bash
./gradlew test            
```

#### Windows
```bash
gradlew.bat test          
```

> If you're unsure what tasks are available, run:

```bash
./gradlew tasks
```

Expected output when all tests pass:
```
BUILD SUCCESSFUL
```

---

## Tools & Constraints

- Kotlin version: **1.9.24**
- Uses:
    - `Randoms.pickUniqueNumbersInRange(1, 45, 6)`
    - `Console.readLine()` for input
- Entry point: `main()` in `Application.kt`
- UI and business logic are cleanly separated:
    - `InputView` for input
    - `OutputView` for output
- Complies with all pre-course constraints:
    - No `System.exit()` or `exitProcess()`
    - Max 2 levels of indentation
    - No generic `Exception` handling
    - Functions are concise (under 10 lines where possible)
    - Avoids `else` via early returns
    - Uses `enum` for prize ranks
    - Logic is fully covered by unit tests (excluding I/O)

---

## Testing Philosophy

- All business logic (e.g. ranking, validation, result aggregation) is unit tested
- Input/output logic (`System.out`, `System.in`) is not tested, in accordance with the mission rules
- Validation logic is tested independently using pure functions
- Tests are organized in files corresponding to the classes they test
- Assertions are written using AssertJ
- Exceptions are verified using JUnit 5's `assertThrows`
---

## Notes

All commits follow the [AngularJS commit message convention](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#-commit-message-format).