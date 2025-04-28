# Kotlin Pre-course Mission 2- Lottery Ticket Machine

## Project Overview

This project is a simple command-line lottery ticket machine written in Kotlin.  
The application allows the user to purchase lottery tickets, enter winning numbers, and view statistics on winnings and profit rate.

The goal is to practice clean code principles, Kotlin basics, small function decomposition, meaningful naming, Git practices, and testing.

---

## ✅ Planned Feature List

Each of the following features will be implemented in a separate, small commit.

### 1. User Input
- [x] Prompt user to enter purchase amount.
- [x] Prompt user to enter the winning numbers.
- [x] Prompt user for bonus number.

### 2. Input Validation
- Validator
  - [x] validateNotBlank
  - [x] validateDivisibleByThousand
  - [x] validateNumberCount
  - [x] validateNumberRange
  - [x] validateUniqueNumbers
  - [x] validateBonusNotDuplicate
  - [x] validateNumberSeparatedWithCommas
- [x] Validate purchase amount (validateNotBlank, validateDivisibleByThousand).
- [x] Validate winning numbers (validateNotBlank, validateNumberSeparatedWithCommas, validateNumberCount, validateNumberRange, validateUniqueNumbers).
- [x] Validate bonus number (validateNotBlank, validateNumberCount, validateNumberRange, validateBonusNotDuplicate).

### 3. Error Handling
- [x] All error messages must start with "[ERROR]".
- [x] Handle only specific exceptions like `IllegalArgumentException`.
- [x] Re-prompt user input after an invalid input without terminating the program.

### 4. Lotto Ticket Generation
- Lotto class
  - [x] Numbers must be sorted in ascending order.
  - [x] getNumbers() -> ex) returns [1, 5, 12, 23, 34, 42]
  - [x] countMatchingNumbers(winningTicket) -> ex) returns 4
  - [x] contains(7) -> ex) returns false
- Lotto Factory
  - [x] Each ticket has 6 unique random numbers (1–45).
  - [x] Generate correct number of tickets based on purchase amount.

### 5. Matching and Prize Determination
- [x] Determine prize ranks based on matches:
    - 3 matches → 5th prize
    - 4 matches → 4th prize
    - 5 matches → 3rd prize
    - 5 matches + bonus → 2nd prize
    - 6 matches → 1st prize
- [x] Compare each ticket with winning numbers.
- [x] Calculate number of winners for each rank.

### 6. Calculating Profit Rate 
- [x] Calculate total return rate rounded to the nearest tenth (e.g., 100.0%, 51.5%)

### 6. Output Results
- [x] Print all purchased tickets clearly.
- [x] Print match statistics (how many tickets won each prize).
- [x] Print total return rate.
- [x] Check the format of execution(to match the output format with functional requirements).

### 7. Testing
- [x] Unit test core business logic (ticket generation, matching, ranking).
- [x] No testing of input/output (UI) code.

---

## 🛠️ Tech Stack

- **Language**: Kotlin 1.9.24
- **Build Tool**: Gradle (Kotlin DSL)
- **Testing**: JUnit 5, AssertJ
- **Utilities**: `camp.nextstep.edu.missionutils.Randoms` and `Console`

---

## 🎯 Project Constraints

- Only Kotlin (no Java).
- Must use provided `Lotto` class.
- Cannot modify `build.gradle.kts`.
- Entry point must be the `main()` function inside the `Application` class.
- No use of `System.exit()` or `exitProcess()`.
- Follow functional and programming requirements strictly.

---

### Check List
- [ ] Follow Kotlin Coding Conventions (2-level indentation max).
- [ ] Keep functions under 10 lines and ensure they do only one thing.
- [ ] Avoid using else statements where early return is possible.
- [ ] Use `const val` for hardcoded values (like 1,000 KRW per ticket).
- [ ] Use Enum classes for prize rankings.
- [ ] Separate UI (InputView, OutputView) from core functionality.