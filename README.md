# kotlin-lotto-precourse

This is a simple lottery ticket machine implemented in Kotlin as part of the pre-course selection process.  
It fulfills process, functional, and programming requirements provided in the mission brief.

---

## Features

### 1. Purchase Flow
- Validate purchase amount (must be divisible by 1,000)
- Prompt user to enter purchase amount
- Calculate number of tickets to issue
- Generate specified number of Lotto tickets

### 2. Lotto Ticket Generation
- Generate 6 unique random numbers between 1 and 45
- Sort numbers in ascending order
- Represent each ticket as an instance of `Lotto` class

### 3. Winning Numbers Input
- Prompt user to enter 6 unique winning numbers
- Prompt user to enter a bonus number
- Validate that numbers are in range and unique
- Validate that bonus number is not included in the 6 winning numbers

### 4. Lotto Result Evaluation
- Compare each ticket against winning numbers
- Determine number of matches and whether bonus number is matched
- Classify result into one of the 5 prize ranks

### 5. Result Display
- Print the tickets purchased
- Display statistics for number of matches per prize tier
- Calculate and display the total return rate

### 6. Error Handling
- Handle invalid inputs with `IllegalArgumentException`
- Display errors with prefix `[ERROR]`
- Prompt user again after invalid input

### 7. Code Structure and Design
- Use `InputView` and `OutputView` for UI separation
- Group business logic into dedicated classes
- Keep indentation depth ≤ 2 levels
- Avoid use of `else`, use early returns
- Limit functions to ≤ 10 lines

### 8. Testing
- Write unit tests for each class and method using JUnit 5 and AssertJ
- Ensure all tests pass with `./gradlew clean test`

---

## Requirements

- Kotlin 1.9.24
- JUnit 5 & AssertJ
- Console and Randoms API from `camp.nextstep.edu.missionutils`
