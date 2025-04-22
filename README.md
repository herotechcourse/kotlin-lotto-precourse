# Lotto Ticket Machine - Kotlin Pre-course Mission 2

This project is a console-based Lotto ticket machine built in Kotlin as part of the Woowa Hero Tech Academy pre-course.  

---

## Features

The program includes the following features:

- Read purchase amount from the user
- Validate that the amount is a positive number and divisible by 1,000
- Generate N tickets (1 ticket = 1,000 KRW) with 6 unique random numbers each (1–45)
- Display the issued tickets sorted in ascending order
- Read last week's winning numbers from the user
- Validate that the winning numbers are 6 unique numbers in the 1–45 range
- Read and validate the bonus number
- Determine match count between purchased tickets and winning numbers
- Categorize each ticket into one of 5 winning ranks (or no prize)
- Count how many tickets match each rank
- Calculate and display the total winnings
- Calculate and display the profit rate (rounded to 1 decimal place)
- Throw `IllegalArgumentException` and re-prompt input for invalid user entries
- Ensure all error messages begin with `[ERROR]`

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

- Kotlin version: 1.9.24
- Must use `Randoms.pickUniqueNumbersInRange(1, 45, 6)`
- Input from user: `Console.readLine()`
- Entry point: `main()` in `Application.kt`
- Max indentation: 2 levels
- No `System.exit()` or `exitProcess()`
- Functions should be under 10 lines
- Avoid `else` (use early return)
- Business logic and UI logic must be separated
- Use `enum` classes where applicable
- Use `InputView` and `OutputView` to separate concerns
- All logic must be tested (except I/O)

---

## Notes

All commits follow the [AngularJS commit message convention](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#-commit-message-format).