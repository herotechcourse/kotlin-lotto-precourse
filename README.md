# Kotlin Lotto Precourse

A simple lottery ticket simulator written in Kotlin as part of the `Hero Tech precourse` mission.  
This project focuses on clean OOP design, test-driven development, and user input handling.

---

## 💡 Feature Plan

1. **Lotto model**
    - `Lotto` class holds 6 unique, sorted numbers
    - Includes unit tests.

2. **Ticket generation**
    - Generates the correct number of tickets based on user input
    - Uses `Randoms.pickUniqueNumbersInRange()`
    - Includes unit tests.

3. **Lotto logic**
    - Matches tickets against winning numbers and bonus
    - Uses `enum` for prize ranks
    - Includes unit tests.

4. **Statistics**
    - Calculates prize distribution and total return rate
    - Return rate is rounded to 1 decimal place
    - Includes unit tests.

5. **User interface**
    - `InputView` for reading and verifying user input
    - `OutputView` for printing tickets, results, and statistics
    - Output format matches the mission requirements exactly
    - Includes unit tests.

6. **Application flow**
    - Combine all components in `main()`
    - Controls the entire app lifecycle
    - Includes integration tests

---

## 🚀 How to Run

```bash
./gradlew clean test