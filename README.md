# kotlin-lotto-precourse

## Features to implement
- [x] Separate Input and Output view
  - [x] Use dedicated classes such as InputView and OutputView to clearly isolate UI-related code from core functionality.
  - [x] If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.
  - [x] Implement Lotto Ticket Generator
- [ ] Testing
  - [ ] Implement unit tests for all logic, except for UI interactions (System.out, System.in).
  - [ ] Write unit tests for each class and function to ensure they work as intended.
- [x] Exception Handling
  - [x] Handle only specific exception types such as IllegalArgumentException or IllegalStateException, not generic Exception.

## Tech Stack

- Kotlin 1.9.24
- Gradle 8.7
- JUnit 5, AssertJ
- IntelliJ IDEA CE(recommended)

---

## How to Run Tests
```
bash
./gradlew clean test
```
All tests must pass.