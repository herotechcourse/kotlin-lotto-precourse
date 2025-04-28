# kotlin-lotto-precourse

# Lotto Program

This is a simple **Lotto Ticket Machine** that generates lottery tickets, accepts winning numbers, compares them, and calculates the result and return rate.

Built with **Kotlin 1.9.24** following strict coding conventions, with business logic separated from UI interaction, full input validation, and complete unit test coverage (except for UI).

---

## Feature List

### Lotto Ticket Purchase

- User inputs the purchase amount.
- Each ticket costs 1,000 KRW.
- Number of tickets issued = (purchase amount / 1,000).

### Lotto Ticket Generation

- Each ticket has **6 unique random numbers**.
- Numbers range between **1 and 45**.
- Numbers on each ticket are displayed **sorted in ascending order**.

### Winning Numbers Input

- Input 6 **comma-separated** winning numbers.
- Input 1 **bonus number** separately.

### Input Validation

- [ERROR] if:
  - Purchase amount is not divisible by 1,000.
  - Lottery ticket numbers are not 6 unique numbers between 1 and 45.
  - Bonus number duplicates a winning number.
- Only specific exceptions (`IllegalArgumentException`, `IllegalStateException`) are thrown.
- The program re-prompts for correct input after an error.

### Result Calculation

- Compare user tickets with winning numbers.
- Prize determination:
  - 1st Prize: Match 6 numbers → 2,000,000,000 KRW
  - 2nd Prize: Match 5 numbers + bonus → 30,000,000 KRW
  - 3rd Prize: Match 5 numbers → 1,500,000 KRW
  - 4th Prize: Match 4 numbers → 50,000 KRW
  - 5th Prize: Match 3 numbers → 5,000 KRW

### Display Statistics

- Show the number of tickets per prize rank.
- Calculate the **total return rate** (rounded to 1 decimal place, `%`).

---

## Architecture

### Layered Structure

- Business Logic

  - `Lotto`
  - `LottoTicket`
  - `LottoMachine`
  - `WinningLotto`
  - `LottoResult`
  - `Rank` (Enum)

- UI Layer
  - `InputView`
  - `OutputView`

### Coding Rules

- Follow **Kotlin Coding Conventions**.
- No function exceeds **10 lines**.
- Maximum **2 levels** of indentation.
- Avoid using `else` by returning early.
- Use **Enums** where appropriate (e.g., `Rank`).
- **Randoms** and **Console** APIs from `camp.nextstep.edu.missionutils` are used (no external libraries).

### Testing

- Use **JUnit 5** and **AssertJ**.
- Unit test all business logic classes and functions.
- No tests required for `System.out` or `System.in`.
- Ensure 100% test pass with the following command:
  ```bash
  ./gradlew clean test
  ```
