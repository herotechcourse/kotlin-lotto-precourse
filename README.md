# kotlin-lotto-precourse

## 📚 Overview
A simple lottery simulation built with **Kotlin 1.9.24**.  
The program allows users to purchase tickets, input winning numbers, and receive result statistics including profit rate.

---

## ⚙ Technologies Used
- **Kotlin 1.9.24** — Main programming language.
- **Gradle** — Build tool (using `build.gradle.kts`).
- **JUnit 5** — Unit testing framework.
- **AssertJ** — Fluent assertions for tests.

---

🔍 Features

1. Implement Lotto class to validate numbers

- Accept a list of 6 unique numbers (as provided in the input).
- Validate that the list has exactly 6 numbers in the range of 1-45.

2. Input Handling

- Validate purchase amount (must be divisible by 1000)
- Read and validate winning numbers (6 unique numbers between 1–45)
- Read and validate bonus number (not in the winning numbers)

3. Ticket Generation

- Generate correct number of tickets using Randoms API
- Ensure each ticket has 6 unique sorted numbers

4. Winning Logic

- Compare tickets with winning numbers and bonus
- Determine ranking for each ticket

5. Statistics

- Count number of tickets per prize category
- Calculate total winnings and profit rate

6. Views

- InputView: handles reading inputs
- OutputView: handles displaying results and errors

7. Unit Tests

- Test Lotto number validation
- Test rank logic
- Test ticket matching and prize calculation
